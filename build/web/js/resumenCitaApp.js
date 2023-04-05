


carritoHTML();
function carritoHTML() {
    //Obtener el Array del LocalStorage de tipo LS
    let carritoLS = localStorage.getItem('carritoLS');
    //Convertir el arreglo a JSON MANEJABLE
    var carritoJSON = JSON.parse(carritoLS);
    //Si esta vacio eliminamos el LS de codigos, el LS de carrito y redirigimos a SeleccionarCita.jsp
    if (carritoJSON.length === 0) {
        localStorage.removeItem('ultimoCodigoLS');
        localStorage.removeItem('carritoLS');
        location.href = "seleccionarCita.jsp";
    }
    //Ubicamos el id del tbody
    let contenedorCarrito = document.querySelector('#contenedorCarrito');
    //Recorremos el array y llenamos el tbody
    var total = 0;
    carritoJSON.forEach(reserva => {
        total = total + Number.parseFloat(reserva.precio);
        let row = document.createElement('tr');
        row.innerHTML = `
                    <td style="text-align: center;">${reserva.codigo_carrito}</td>
                    <td style="text-align: center;">${reserva.paciente}</td>
                    <td style="text-align: center;">${reserva.especialidad}</td>
                    <td style="text-align: center;">${reserva.nombre_medico}</td>
                    <td style="text-align: center;">${reserva.fecha} ${reserva.hora}</td>
                    <td style="text-align: center;">${reserva.precio}</td>
                    <td style="text-align: center;"> 
                        <a  style="color: red;" class="btn-eliminar text-decoration-none" data-id="${reserva.codigo_carrito}" onclick="eliminarLS(${reserva.codigo_carrito})"><i class="fas fa-trash"></i></a>
                    </td>
          `;
        contenedorCarrito.appendChild(row);
    });
    //Calcula total de precio
    $('#total').text(total);
}





//boton que abre la pasarela
$('.btn-pasarela').on('click', function (e) {
    e.preventDefault();
    console.log('Se abre pasarela...');
    $('#modalPago').modal('show');


});



function eliminarLS(id) {

    //inicia alert
    Swal.fire({
        title: 'Estas seguro?',
        text: "perderas la reserva!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'No, cancelalo!',
        confirmButtonText: 'Sí, elimínalo!'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                    'Eliminado!',
                    'Tu reserva ha sido eliminada.',
                    'success'
                    ).then((result) => {
                if (result) {
                    //Desconvierto de JSON a Objeto
                    var carritoArray = JSON.parse(localStorage.getItem('carritoLS'));
                    //fltramos y eliminamos
                    carritoArray = carritoArray.filter(reserva => reserva.codigo_carrito !== id);
                    //convertimos el arreglo a JSON
                    let nuevocarritoJSON = JSON.stringify(carritoArray);
                    localStorage.removeItem('carritoLS');
                    //Guardo mi JSON en el LocalStorage
                    localStorage.setItem('carritoLS', nuevocarritoJSON);
                    //guardamos en LS el arreglo en formato JSON
                    $('#contenedorCarrito').text("");
                    carritoHTML();
                }
            });
        }
    })
    //termina alert

}


//Boton Pagar
$('.btn-pagar').on('click', function (e) {
    e.preventDefault(); //previene recargar la pagina
    //inicia validando
    var tarjeta = $('.tarjeta').val();
    console.log("tarjeta: " + tarjeta);
    var mes = $(".mes option:selected").text();
    console.log("mes: " + mes);
    var year = $(".year option:selected").text();
    console.log("year: " + year);
    var cvv = $('.cvv').val();
    console.log("cvv: " + cvv);
    var email = $('.email').val();
    console.log("email: " + email);
    var id_paciente = $('.id_paciente').val();
    console.log("id_paciente: " + id_paciente);
    if (tarjeta !== "" && mes !== "" && year !== "" && cvv !== "" && email !== "") {
        //inicia sweet alert
        Swal.fire({
            title: '¿Confirmas el pago?',
            text: "El costo se descontará del Saldo de tu tarjeta",
            icon: 'info',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí, Deseo pagar!'
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire(
                        'El producto se ha pagado!',
                        'Veamos tu lista de compra',
                        'success'
                        ).then((result) => {
                    if (result) { //si es true envia a DB Y REDIRIGE
                        //inicia envio de datos a Servlet
                        //Obtener el Array del LocalStorage de tipo LS
                        let carritoLS = localStorage.getItem('carritoLS');
                        //Convertir el arreglo a JSON MANEJABLE
                        carritoJSON = JSON.parse(carritoLS);
                        //Recorremos el carrito
                        carritoJSON.forEach(reserva => {
                            //obtenemos las variables de cada fila
                            var fecha = reserva.fecha;
                            var hora = reserva.hora;
                            var id_usuario = reserva.codigousuario;
                            var id_medico = reserva.codigo_medico;
                            var id_especialidad = reserva.id_especialidad;
                            var precio = reserva.precio;
                            
                            //Enviamos por Ajax al Servlet
                            var url = "ProcesarServlet?accion=reservar";
                            $.ajax({
                                type: 'POST',
                                url: url,
                                data: "id_usuario=" + id_usuario + "&id_medico=" + id_medico + "&id_especialidad=" + id_especialidad + "&fecha=" + fecha + "&hora= " + hora + "&precio=" + precio + "&id_paciente=" + id_paciente,
                                success: function (data, textStatus, jqXHR) {
                                    console.log('Pagando...');
                                    localStorage.removeItem('carritoLS');
                                    localStorage.removeItem('ultimoCodigoLS');
                                    location.href = "UsuarioLoginServlet?accion=verHistorial";
                                }
                            });

                        });
                        //termina envio de datos al Servlet;

                    }
                    ;
                });
            }
        })
        //termina Sweet alert
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Hay campos vacios o incorrectos!',
            footer: 'Te recomendamos ingresar los campos'
        })
    }
    // fin validacion
});






