//espresiones regulares
var expresiones = {
	usuario: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo
	nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	password: /^.{4,12}$/, // 4 a 12 digitos.
	correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	tarjeta: /^[0-9]{13,20}$/, // 7 a 14 numeros.
        cvv : /^[0-9]{3}$/
}
 var valStatusTarjeta = false;
 var valStatusCvv = false;
 var valStatusCorreo = false;
 

//Validamos input tarjeta
$('#tarjeta').on('keyup', function (event) { 
  if(expresiones.tarjeta.test($('#tarjeta').val())){
      console.log("tarjeta valida");
      $('#errorTarjeta').removeClass('text-danger');
      $('#errorTarjeta').addClass('text-success');
      $('#errorTarjeta').text("El numero ingresado es correcto");
      $('#errorTarjeta').show();
      valStatusTarjeta = true;
  }else{
      console.log("tarjeta invalida");
      $('#errorTarjeta').removeClass('text-success');
      $('#errorTarjeta').addClass('text-danger');
      $('#errorTarjeta').text("El numero ingresado debe tener 13 a 20 digitos");
      $('#errorTarjeta').show();
      valStatusTarjeta = false;
  }

});

//validamos input ccv
$('#cvv').on('keyup', function (event) { 
  if(expresiones.cvv.test($('#cvv').val())){
      console.log("cvv valida");
      $('#errorCvv').removeClass('text-danger');
      $('#errorCvv').addClass('text-success');
      $('#errorCvv').text("El cvv ingresado es correcto");
      $('#errorCvv').show();
      valStatusCvv = true;
  }else{
      console.log("cvv invalida");
      $('#errorCvv').removeClass('text-success');
      $('#errorCvv').addClass('text-danger');
      $('#errorCvv').text("El cvv ingresado debe tener 3 digitos");
      $('#errorCvv').show();
      valStatusCvv = false;
  }

});

//validamos input correo
$('#correo').on('keyup', function (event) { 
  if(expresiones.correo.test($('#correo').val())){
      console.log("correo valida");
      $('#errorEmail').removeClass('text-danger');
      $('#errorEmail').addClass('text-success');
      $('#errorEmail').text("El formato de correo es correcto");
      $('#errorEmail').show();
      valStatusCorreo = true;
  }else{
      console.log("correo invalida");
      $('#errorEmail').removeClass('text-success');
      $('#errorEmail').addClass('text-danger');
      $('#errorEmail').text("El formato de correo no es el correcto");
      $('#errorEmail').show();
      valStatusCorreo = false;
  }

});

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
    console.log($('#terminos').is(':checked'));
    if($('#terminos').is(':checked')){
    console.log('Se abre pasarela...');
    $('#modalPago').modal('show');
    }else{
      Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'No has marcado terminos y condiciones',
            footer: 'Es importante que acepte los terminos de la compra.'
        });
    }



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

    if (tarjeta !== "" && mes !== "Selecciona" && year !== "Selecciona" && cvv !== "" && email !== "" && valStatusTarjeta && valStatusCvv && valStatusCorreo) {
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
                           // var id_medico = reserva.codigo_medico;
                            var id_especialidad = reserva.id_especialidad;
                            var precio = reserva.precio;
                            
                            //Enviamos por Ajax al Servlet
                            var url = "ProcesarServlet?accion=reservar";
                            $.ajax({
                                type: 'POST',
                                url: url,
                                data: "id_usuario=" + id_usuario  + "&id_especialidad=" + id_especialidad + "&fecha=" + fecha + "&hora= " + hora + "&precio=" + precio,
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








