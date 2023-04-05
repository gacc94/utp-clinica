<%-- 
    Document   : bienvenida
    Created on : 28/10/2022, 11:24:02 PM
    Author     : Jonathan
--%>
<%@page import="dto.Productos"%>
<%@page import="dto.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.TextStyle"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- bienvenida CSS -->
        <link href="css/bienvenida.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            HttpSession sesion = request.getSession();
            Usuario usu = (Usuario) sesion.getAttribute("user");//se guarda el login
            if (usu != null) {//si se logueo bien ingresa
                if (!usu.getNombrerol().equalsIgnoreCase("Paciente")) { //si el admin quiere ir al index no lo dejará hasta que cierre Sesión
                    request.getRequestDispatcher("administrador.jsp").forward(request, response);

                }
            }
        %>
        <div class="container-fluid">
            <!--Menu-->
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="container-fluid">
                    <a style="color:#44469D; font-weight: bold"  class="navbar-brand " href="principal.jsp">CitaMed Online</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu" aria-current="page" href="#">SERVICIOS</a>
                            </li>
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu" href="#">CONVENIOS</a>
                            </li>
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu" href="#">PROMOCIONES</a>
                            </li>
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu">SEDES</a>
                            </li>
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu">RESULTADOS COVID 19</a>
                            </li>
                            <!--Dropdown-->
                            <c:if test="${user != null}">
                                <ul class="navbar-nav">
                                    <li class="nav-item dropdown">
                                        <a style="color:#44469D; font-weight: bold;border: 1px solid;border-radius: 10px" class="nav-link dropdown-toggle textomenu" href="#" id="navbarDropdownMenuLink"
                                           role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            <i class="fa fa-user"></i> ${user.getNombre()} ${user.getApellido()}
                                        </a>
                                        <ul style="top: 32px;right: 30px;" class="dropdown-menu dropdown-menu-end text-center bg-light text-Dark"
                                            aria-labelledby="navbarDropdownMenuLink">
                                            <li><a style="color: black !important;" class="dropdown-item text-Dark" href="UsuarioLoginServlet?accion=verHistorial">Historial de Citas</a></li>
                                            <li><a style="color: black !important;" class="dropdown-item text-Dark" href="UsuarioLoginServlet?accion=salir">Salir</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </nav>
            <!--Body-->
            <div style="background:#44469D;padding: 20px; " class="">
                <p class="text-light fw-bold"> <img style="width: 50px;" src="img/icon-doctor.png" /> COMPRA TU CITA PRESENCIAL</p>
            </div>
            <!--Producto-->
            <div class="container">
                <div style="margin-top: 20px;" class="row">
                    <div class="col-md-3">
                        <div style="border: 1px solid #5AC5C3;padding: 15px;border-radius: 30px;">
                            <h4 style=" color: #44469D; ">COMPLETAR LOS DATOS</h4>
                            <div class="form-group">
                                <label for="nombre" class="" style="color:#44469D;">Nombre del paciente</label>
                                <input style="text-align: center;" type="text" disabled class="form-control" name="nombre" id="nombre" value="${user.getNombre()} ${user.getApellido()}">
                            </div>
                            <div class="form-group">
                                <label style="color: #44469D;" for="especialidad" class="">Especialidad</label>
                                <select style="text-align: center;" class="form-select" name="cboespecialidad" id="cboespecialidad" onchange="mostrarMedico()">
                                    <option selected value="">Selecciona</option>
                                    <option value="CARDIOLOGIA">CARDIOLOGIA</option>
                                    <option value="CIRUGIA GENERAL">CIRUGIA GENERAL</option>
                                    <option value="CIRUGIA TORAX Y CARDIOVASCULAR">CIRUGIA TORAX Y CARDIOVASCULAR</option>
                                    <option value="CRED">CRED</option>
                                    <option value="DERMATOLOGIA">DERMATOLOGIA</option>
                                    <option value="ENDOCRINOLOGIA">ENDOCRINOLOGIA</option>
                                    <option value="GASTROENTEROLOGIA">GASTROENTEROLOGIA</option>
                                    <option value="GERIATRIA">GERIATRIA</option>
                                    <option value="GINECOLOGIA">GINECOLOGIA</option>
                                    <option value="MEDICINA INTERNA">MEDICINA INTERNA</option>
                                    <option value="NEUMOLOGIA">NEUMOLOGIA</option>
                                    <option value="NEUROLOGIA">NEUROLOGIA</option>
                                    <option value="NUTRICION">NUTRICION</option>
                                    <option value="OFTALMOLOGIA">OFTALMOLOGIA</option>
                                    <option value="OTORRINOLARINGOLOGIA">OTORRINOLARINGOLOGIA</option>
                                    <option value="PEDIATRIA">PEDIATRIA</option>
                                    <option value="PSIQUIATRIA">PSIQUIATRIA</option>
                                    <option value="REUMATOLOGIA">REUMATOLOGIA</option>
                                    <option value="TERAPIA FISICA Y REHABILITACION">TERAPIA FISICA Y REHABILITACION</option>
                                    <option value="TRAUMATOLOGIA">TRAUMATOLOGIA</option>
                                    <option value="UROLOGIA">UROLOGIA</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label id="lblmedico" style="color: #44469D;display: none" for="cbomedico" class="">Médico</label>
                                <select style="text-align: center; display: none" class="form-select" name="cbomedico" id="cbomedico">
                                </select>
                            </div>

                            <div style="margin: 15px 0px 2px 0px;" class="form-group">
                                <a style="padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;" class="text-decoration-none"  href="javascript:infomodal()" ><i style="margin-right: 5px;padding-top: 5px;" class="fas fa-search"></i> Procesar</a>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-9">
                        <div id="calendario" style="border: 1px solid #5AC5C3;padding: 15px;border-radius: 30px; display: none">
                            <h4 style="color: #44469D;">SELECCIONA TU DIA DE CITA</h4>
                                                        
                            <%
                                Calendar calendario = Calendar.getInstance();
                                int diaActual = calendario.get(Calendar.DAY_OF_WEEK);
                                int mesActual = calendario.get(Calendar.MONTH);
                                int añoActual = calendario.get(Calendar.YEAR);

                                calendario.set(Calendar.DAY_OF_MONTH, 1);
                                int primerDiaMes = calendario.get(Calendar.DAY_OF_WEEK);
                                int numDiasMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);

                                int dia = 1;
                                
                                // Obtienes el mes actual
                                Month mes = LocalDate.now().getMonth();
                               
                                // Obtienes el nombre del mes
                                String nombreMes = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
                                
                                //Convertir en mayuscula
                                String mayusculaMes = nombreMes.toUpperCase();
                               
                            %>
        
        <h5 style="color: #44469D;"> Fecha: <%= diaActual +1 %>/<%= mesActual + 1 %>/<%= añoActual %></h5>
        <h4 style="color: #44469D;"><%= mayusculaMes %></h4>
        <table style="width: 100%;">
            <thead>
                <tr style="text-align: center;">
                    <th>Domingo</th>
                    <th>Lunes</th>
                    <th>Martes</th>
                    <th>Miércoles</th>
                    <th>Jueves</th>
                    <th>Viernes</th>
                    <th>Sábado</th>
                </tr>
            </thead>
            <tbody>
                 <% for (int i = 1; i <= 6; i++) { %>
                <tr>
                    <% for (int j = 1; j <= 7; j++) { %>
                    <% if (i == 1 && j < primerDiaMes || dia > numDiasMes) { %>
                    <td></td>
                    <% } else { %>
                    <td  id="dia<%= dia %>" class="dia" style="border: 1px solid #fff;text-align: center;background: #dadada;"><a data-id="<%= dia %>/<%= mesActual + 1 %>/<%= añoActual %>" style="color: #fff;display: flex;justify-content: center;cursor: pointer;"  class="text-decoration-none btn-turno"><%= dia %></a></td>
                    <% dia++; } %>
                    <% } %>
                    
                </tr>
                <% } %>
                
            </tbody>
        </table>
                        </div>
                    </div>
                </div>
                <!--Resumen-->
                <div id="resumenpedido" class="row my-3 justify-content-end" style="display: none">
                    <div class="col-md-9">
                        <div>
                            <div style="border: 1px solid #5AC5C3;padding: 15px;border-radius: 30px;">
                                <h4 style="color: #44469D;">Resumen de Reserva</h4>
                                <input type="hidden" class='codigousuario' name="codigousuario" value=${user.getIdusuario()}>
                                <input type="hidden" class='codigomedico' name='codigomedico' value="" >
                                <input type="hidden" class='id_especialidad' name='id_especialidad' value="" >
                                <input type="hidden" class='precio' name='precio' value="" >
                                <p class="text-uppercase"><img style="width: 20px;padding-bottom: 5px;" src="img/icon-nombre.png" alt=""/> <span style="font-weight: bold">PACIENTE:</span> <span id="paciente-resumen">${user.getNombre()} ${user.getApellido()}</span></p>
                                <p class="text-uppercase"><img style="width: 20px;padding-bottom: 5px;" src="img/icon-especialidad.png" alt=""/> <span style="font-weight: bold">ESPECIALIDAD:</span> <span id="especialidad_resumen"></span></p>
                                <p class="text-uppercase"><img style="width: 20px;padding-bottom: 5px;" src="img/icon-medico.png" alt=""/> <span style="font-weight: bold">MEDICO:</span> <span id="medico-resumen"></span></p>
                                <p><img style="width: 20px;padding-bottom: 5px;" src="img/icon-fechahora.png" alt=""/> <span style="font-weight: bold">TURNO:</span> <span id="fecha_resumen"></span> <span id="hora-resumen"></span></p>
                                <div style="display: flex;justify-content: end;margin: 10px"><a style="padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;width: 120px;" class="text-decoration-none">S/ <span class="precio_btn"></span>.00</a></div>
                                <a style="padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-reservar">Reservar y pagar</a>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            <!--MODAL-->
            <div style="left: 350px !important;" class="modal" id="modal" tabindex="-1">
                <div style="max-width: none !important;" class="modal-dialog">
                    <div style="width: 800px !important;text-align: center;" class="modal-content">
                        <div class="modal-header">
                            <h5 style="color: #5AC5C3;font-weight: bold;" class="modal-title">Turnos disponibles</h5> 
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <label>Selecciona las horas disponibles</label><br>
                            <label>Especialidad: <span id="especialidad"></span> - Fecha: <span id="fecha"><%= diaActual %>/<%= mesActual + 1 %>/<%= añoActual %></span></label>
                            <p style="color: #5AC5C3;font-weight: bold;"><img style="width: 20px;padding-bottom: 5px;" src="img/icon-medico.png" alt=""/> <span id="medico"></span> Consultorio: <span id="consultorio"></span></p>

                            <div style="margin: 20px 0px;" class="row">
                                <div class="col-md-2"><a data-id="08:30 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">8:30 am</a></div>
                                <div class="col-md-2"><a data-id="08:42 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">8:42 am</a></div>
                                <div class="col-md-2"><a data-id="09:06 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">9:06 am</a></div>
                                <div class="col-md-2"><a data-id="09:18 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">9:18 am</a></div>
                                <div class="col-md-2"><a data-id="09:30 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">9:30 am</a></div>
                                <div class="col-md-2"><a data-id="09:42 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">9:42 am</a></div>
                            </div>
                            <div style="margin: 20px 0px;" class="row">
                                <div class="col-md-2"><a data-id="09:54 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">9:54 am</a></div>
                                <div class="col-md-2"><a data-id="10:06 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">10:06 am</a></div>
                                <div class="col-md-2"><a data-id="10:18 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">10:18 am</a></div>
                                <div class="col-md-2"><a data-id="10:42 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">10:42 am</a></div>
                                <div class="col-md-2"><a data-id="10:54 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">10:54 am</a></div>
                                <div class="col-md-2"><a data-id="11:06 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">11:06 am</a></div>
                            </div>
                            <div style="margin: 20px 0px;" class="row">
                                <div class="col-md-2"><a data-id="11:15 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">11:15 am</a></div>
                                <div class="col-md-2"><a data-id="11:20 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">11:20 am</a></div>
                                <div class="col-md-2"><a data-id="11:30 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">11:30 am</a></div>
                                <div class="col-md-2"><a data-id="11:40 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">11:40 am</a></div>
                                <div class="col-md-2"><a data-id="11:50 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">11:50 am</a></div>
                                <div class="col-md-2"><a data-id="12:00 am" style="display: flex;padding: 10px 1px;background: #5AC5C3;color: #fff;border-radius: 10%;font-size: 14px;justify-content: center;font-weight: bold;cursor: pointer;" class="text-decoration-none btn-hora">12:00 pm</a></div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>

                        </div>
                    </div>
                </div>
            </div>
            <!--FIN MODAL-->
        </div>
                               
    </body>
    <script src="jquery/jquery-3.6.0.min.js" type="text/javascript"></script> 
    <!--Sweet Alert 2-->
    <script src="js/sweetalert2.all.min.js" type="text/javascript"></script>
    <script src="js/seleccionarCitaApp.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="jquery/popper.min.js" type="text/javascript"></script>
    <!--Fontawesome-->
    <script src="https://kit.fontawesome.com/27f204c8a9.js" crossorigin="anonymous"></script>
    
     <script>
            var dias = document.getElementsByClassName("dia");
            for (var i = 0; i < dias.length; i++) {
                dias[i].addEventListener("click", function() {
                    var diaSeleccionado = this.innerHTML;
                    var mesSeleccionado = <%= mesActual + 1 %>;
                    var añoSeleccionado = <%= añoActual %>;
                    var retornoFecha = (diaSeleccionado + "/" + mesSeleccionado + "/" + añoSeleccionado);
                    console.log(diaSeleccionado + "/" + mesSeleccionado + "/" + añoSeleccionado);
                    return retornoFecha; 
                });
            }
        </script>
</html>
