


//Boton de Hora: Obtener la hora 
$('.btn-hora').on('click', function () {
    $('#resumenpedido').show();
    var hora = $(this).attr('data-id'); /* Id */
    $('#hora-resumen').text(hora);
    console.log("Hora: " + hora);
    //Cerramos el modal
    $("#modal").modal('hide');
    $('body').removeClass('modal-open');
    $('.modal-backdrop').remove();

});

//Boton dia: obtener el data-id
$('.btn-turno').on('click', function () {
    var Id = $(this).attr('data-id'); /* Id */
    console.log("id del turno: " + Id);
    //cambiar fecha en el modal
    var fecha = Id;
    $('#fecha').text(fecha);
    $('#fecha_resumen').text(fecha);
    //especialidad
    var especialidad = $("#cboespecialidad option:selected").text();
    console.log("especialidad: " + especialidad);
    if (especialidad == "Selecciona") {
        alert('No ha seleccionado una especialidad');
    } else {
        $('#especialidad').text(especialidad);
        $('#especialidad_resumen').text(especialidad);

        //Mostrar Modal
        $('#modal').modal('show');
        console.log("Se abre el modal");
        $('.modal-backdrop').add();
    }

});

//llenar el cboMedico
function mostrarMedico() {
    let especialidad = $("#cboespecialidad option:selected").text();
    let cboselect = document.querySelector('#cbomedico');
    $.ajax({
        url: "ProcesarServlet?accion=verMedico&especialidad=" + especialidad,
        type: "GET",
        datatype: "JSON",
        success: function (data) {
            //Parseamos el data a un array
            var medicos = JSON.parse(data);
            //ordenar alfabeticamente
            medicos.sort();
            //limpiamos el SELECT
            $('#cbomedico').empty();
            //mostramos el SELECT
            $('#cbomedico').show();
            $('#lblmedico').show();
            //Iteramos
            medicos.forEach(medico => {
                var option = document.createElement("option");
                option.text = medico.nombres_medico + " " + medico.apellido_paterno_medico + " " + medico.apellido_materno_medico;
                option.value = medico.nombres_medico + " " + medico.apellido_paterno_medico + " " + medico.apellido_materno_medico;
                cboselect.add(option);
            });



        }

    });
}

//Si el SELECT CBOMEDICO CAMBIA SUCEDE LO SIGUIENTE
$( "#cbomedico" ).change(function() {
  $('#calendario').hide();
  $('#resumenpedido').hide();
});

$( "#cboespecialidad" ).change(function() {
  $('#calendario').hide();
  $('#resumenpedido').hide();
});

//llenamos el Modal de horarios de datos según la especialidad enviada
function infomodal() {
    //especialidad
    var especialidad = $("#cboespecialidad option:selected").text();
    console.log("especialidad que se envía al Servlet: " + especialidad);
    if (especialidad == "Selecciona") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'No has elegido una especialidad',
            footer: 'Elige una especialidad por favor.'
        })
    } else {
        $('#calendario').show();
        $('#resumenpedido').hide();
        Swal.fire({
            position: 'top-center',
            icon: 'success',
            title: 'Felicitaciones! Tenemos horarios disponibles!',
            showConfirmButton: false,
            timer: 1500
        })
        $.ajax({
            url: "ProcesarServlet?accion=procesar&especialidad=" + especialidad,
            type: "GET",
            datatype: "JSON",
            success: function (data) {
                var item = JSON.parse(data);
                var medico = $("#cbomedico option:selected").text();
                $('#medico').text(medico);
                $('#medico-resumen').text(medico);
                $('#consultorio').text(item.consultorio);
                $('.codigomedico').val(item.codigo_medico);
                $('.id_especialidad').val(item.id_especialidad);
                $('.precio').val(item.precio);
                $('.precio_btn').text(item.precio);
            }

        })
    }

}

//Function Reserar

$('.btn-reservar').on('click', function () {
    //inicia sweet alert
    Swal.fire({
        title: '¿Deseas agregarlo al carrito?',
        text: "Estamos muy cerca de terminar el proceso de compra.",
        icon: 'info',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, Deseo agregarlo al carrito.'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                    'El producto se ha agregado al carrito!',
                    'Veamos el carrito',
                    'success'
                    ).then((result) => {
                if (result) {
                    //RESERVACION
                    console.log("codigo usuario: " + $('.codigousuario').val());
                    console.log("paciente: " + $('#paciente-resumen').text())
                    console.log("codigo medico: " + $('.codigomedico').val());
                    console.log("nombre medico: " + $('#medico-resumen').text());
                    console.log("id especialidad: " + $('.id_especialidad').val());
                    console.log("especialidad: " + $('#especialidad_resumen').text());
                    console.log("precio: " + $('.precio').val());
                    console.log("fecha: " + $('#fecha_resumen').text());
                    console.log("hora: " + $('#hora-resumen').text());

                    var codigousuario = $('.codigousuario').val();
                    var paciente_resumen = $('#paciente-resumen').text();
                    var codigo_medico = $('.codigomedico').val();
                    var nombre_medico = $('#medico-resumen').text();
                    var id_especialidad = $('.id_especialidad').val();
                    var especialidad = $('#especialidad_resumen').text();
                    var precio = $('.precio').val();
                    var fecha = $('#fecha_resumen').text();
                    var hora = $('#hora-resumen').text();


                    //creamos un objeto
                    let reserva = {
                        codigo_carrito: getCodCarrito(),
                        codigousuario: codigousuario,
                        paciente: paciente_resumen,
                        codigo_medico: codigo_medico,
                        nombre_medico: nombre_medico,
                        id_especialidad: id_especialidad,
                        especialidad: especialidad,
                        precio: precio,
                        fecha: fecha,
                        hora: hora
                    };
                    //guardamos la reserva
                    agregarReserva(reserva);

                    //redirigimos a jsp
                    location.href = "resumenCita.jsp";
                    //FIN RESERVACION

                }
                ;
            });
        }
    })
    //termina Sweet alert


});

function agregarReserva(reserva) {

    // guardamos en carrito el arreglo JSON actual en un arreglo simple. Si el arreglo JSON esta vacio guardamos el arreglo simple vacío.
    let carrito = JSON.parse(localStorage.getItem('carritoLS')) || [];
    //Agregamos al arreglo simple la reserva
    carrito.push(reserva);
    //convertimos el arreglo a JSON
    let carritoJSON = JSON.stringify(carrito);
    //guardamos en LS el arreglo en formato JSON
    localStorage.setItem('carritoLS', carritoJSON);
}

function getCodCarrito() {
    //tomo el valor actual del codigo en LS, si esta vacio le da 0
    let ultimoCodigo = localStorage.getItem('ultimoCodigoLS') || "0";
    //obtengo el ultimo codigo y le sumo 1
    let nuevoCodigo = JSON.parse(ultimoCodigo) + 1;
    //actualizo el ultimo codigo con el nuevo
    localStorage.setItem('ultimoCodigoLS', nuevoCodigo);
    return nuevoCodigo;

}






