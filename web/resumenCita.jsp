<%-- Document : bienvenida Created on : 28/10/2022, 11:24:02 PM Author : Jonathan --%>

<%@page import="dto.Productos"%>
<%@page import="dto.Usuario"%>
<%@page import="dao.impl.DaoProductosImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
        <!-- bienvenida CSS -->
        <link href="css/resumenCitaEstilos.css" rel="stylesheet" type="text/css" />
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
                    <a style="color:#44469D; font-weight: bold" class="navbar-brand " href="#">CitaMed Online</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu"
                                   aria-current="page" href="#">SERVICIOS</a>
                            </li>
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu"
                                   href="#">CONVENIOS</a>
                            </li>
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu"
                                   href="#">PROMOCIONES</a>
                            </li>
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu">SEDES</a>
                            </li>
                            <li class="nav-item">
                                <a style="color:#44469D; font-weight: bold" class="nav-link textomenu">RESULTADOS
                                    COVID 19</a>
                            </li>
                            <!--Dropdown-->
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a style="color:#44469D; font-weight: bold;border: 1px solid;border-radius: 10px"
                                       class="nav-link dropdown-toggle textomenu" href="#"
                                       id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
                                       aria-expanded="false">
                                        <i class="fa fa-user"></i> ${user.getNombre()}
                                        ${user.getApellido()}
                                    </a>
                                    <ul style="top: 32px;right: 30px;"
                                        class="dropdown-menu dropdown-menu-end text-center bg-light text-Dark"
                                        aria-labelledby="navbarDropdownMenuLink">
                                        <li><a style="color: black !important;" class="dropdown-item text-Dark" href="UsuarioLoginServlet?accion=verHistorial">Historial de Citas</a></li>
                                        <li><a style="color: black !important;" class="dropdown-item text-Dark"
                                               href="UsuarioLoginServlet?accion=salir">Salir</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </ul>
                    </div>
                </div>
            </nav>
            <!--Body-->
            <div class="container justify-content-center">
                <div class="row">
                    <h1 style="color: #5AC5C3;font-weight: bold;">Resumen de citas</h1>
                    <p style="color:#ffb300; font-weight: bold" >Revisa detenidamente tu selección y realiza tu pago en 1 click.</p>
                </div>
                <div class="row justify-content-center">
                    <table style="width: 80%;" class="">
                        <thead>
                            <tr style="text-align: center;">
                                <td style="text-align: center;background: #5AC5C3;color: #fff;">Id</td>
                                <td style="text-align: center;background: #5AC5C3;color: #fff;">Paciente</td>
                                <td style="text-align: center;background: #5AC5C3;color: #fff;">Especialidad</td>
                                <td style="text-align: center;background: #5AC5C3;color: #fff;">Medico</td>
                                <td style="text-align: center;background: #5AC5C3;color: #fff;">Fecha y hora</td>
                                <td style="text-align: center;background: #5AC5C3;color: #fff;">Precio S/.</td>
                                <td style="text-align: center;background: #5AC5C3;color: #fff;">Acción</td>
                            </tr>
                        </thead>
                        <tbody id="contenedorCarrito">

                        </tbody>
                    </table>
                </div>
                <!--input id_paciente-->
                <input type="hidden" class='id_paciente' name='id_paciente' value="${user.getId_paciente()}" >
                <div style="width: 80%;display: flex;flex-direction: row;justify-content: end;text-align: end;margin: auto;"
                     class="row">
                    <p style="margin: 20px 0px;font-weight: bold;">Total a Pagar: S/.<span id="total">40</span>.00</p>
                    <a style="width: auto;padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;"
                       class="text-decoration-none btn-pasarela" href="#"><i style="margin-right: 5px;padding-top: 5px;"
                                                                          class="fa fa-credit-card"></i> Pagar</a>
                </div>
                <div style="width: 80%;margin:20px auto;" class="row">
                    <p style="margin-bottom: 0;color: #5AC5C3;font-weight: bold;">
                        <input style="margin-right: 5px;" type="checkbox" name="" id="terminos">Acepto los Términos y
                        Condiciones y la Política de Privacidad establecidos (Lea detenidamente esta sección)
                    </p>
                    <ul>
                        <li>Luego de efectuar el pago, el dinero no será reembolsado.</li>
                        <li>En caso de no poder asistir a su cita en la fecha pautada, podrá realizar una
                            reprogramación de
                            la misma (antes de la fecha programada).</li>
                    </ul>


                </div>
                <div style="width: 80%;margin:20px auto;justify-content: space-evenly;" class="row">
                    <a style="width: auto;padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;"
                       class="text-decoration-none" href="seleccionarCita.jsp">Programar otra cita</a>
                    <a style="width: auto;padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;"
                       class="text-decoration-none" href="UsuarioLoginServlet?accion=verHistorial">Mira tu historial de citas</a>


                </div>


            </div>
        </div>
        <!--MODAL PAGO-->
        <div  class="modal" id="modalPago" tabindex="-1">
            <div class="modal-dialog">
                <div  style="text-align: center;" class="modal-content">
                    <div class="modal-header">
                        <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">CitaMed</p>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p style="color:#ffb300; font-weight: bold;font-size: 30px;"><i class="fab fa-cc-visa"></i> Pago de citas en linea</p>
                        <div id="formPago" class="col-12  py-3 px-3">
                            <div class="row">
                                <!-- Grupo: Numero de Tarjeta -->
                                <div class="form-group">
                                    <label for="tarjeta">Número de Tarjeta</label>
                                    <input id="tarjeta" type="number" class="form-control tarjeta" name="tarjeta" 
                                           placeholder="•••• •••• •••• ••••" value="" >   
                                </div>
                                 <div class="form-group">
                                    <label id ="errorTarjeta" class="text-danger fw-bold" style="display: none" for="" ></label>
                                </div>
                                
                                <div class="form-group">
                                    <label>Fecha de expiración de la tarjeta</label>
                                    <div class="row">
                                        <div class="col-6">
                                            <select class="form-select mes" name="cbomes" id="">
                                                <option value="Selecciona">Selecciona</option>
                                                <option value="01">01</option>
                                                <option value="02">02</option>
                                                <option value="03">03</option>
                                                <option value="04">04</option>
                                                <option value="05">05</option>
                                                <option value="06">06</option>
                                                <option value="07">07</option>
                                                <option value="08">08</option>
                                                <option value="09">09</option>
                                                <option value="10">10</option>
                                                <option value="11">11</option>
                                                <option value="12">12</option>
                                            </select>
                                        </div>
                                        <div class="col-6">
                                            <select class="form-select year" name="cboyear" id="">
                                                <option value="Selecciona">Selecciona</option>
                                                <option value="2030">2030</option>
                                                <option value="2029">2029</option>
                                                <option value="2028">2028</option>
                                                <option value="2027">2027</option>
                                                <option value="2026">2026</option>
                                                <option value="2025">2025</option>
                                                <option value="2024">2024</option>
                                                <option value="2023">2023</option>
                                                <option value="2022">2022</option>
                                                <option value="2021">2021</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label id ="errorMes" class="text-danger fw-bold" style="display: none" for="" >El mes no tiene el formato correcto</label>
                                </div>
                                <div class="form-group">
                                    <label id ="errorAnio" class="text-danger fw-bold" style="display: none" for="" >El año no tiene el formato correcto</label>
                                </div>
                                <!-- Grupo: CVV -->
                                <div class="form-group">
                                    <label for="cvv">CVV</label>
                                    <input id="cvv" type="number" class="form-control cvv" min="1" max="3" name="cvv" value=""
                                           placeholder="Ingresa 3 digitos">
                                </div>
                                 <div class="form-group">
                                    <label id ="errorCvv" class="text-danger fw-bold" style="display: none" for="" ></label>
                                </div>
                                <!-- Grupo: Email -->
                                <div class="form-group">
                                    <label for="email" >Email</label>
                                    <input id="correo" type="email" class="form-control email" name="email" value=""
                                           placeholder="Jhon@gmail.com" value="">
                                </div>
                                <div class="form-group">
                                    <label id ="errorEmail" class="text-danger fw-bold" style="display: none" for="" >El email no tiene el formato correcto</label>
                                </div>
                                
                                
                            </div>

                        </div>


                    </div>
                    <div class="modal-footer">
                        <a style="width: auto;padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;"
                           class="text-decoration-none btn-pagar" href="#" ><i style="margin-right: 5px;padding-top: 5px;"
                                                                            class="fa fa-credit-card"></i> Pagar</a>
                    </div>
                </div>
            </div>
        </div>
        <!--FIN MODAL PAGO-->
    </body>
    <script src="jquery/jquery-3.6.0.min.js" type="text/javascript"></script>
    <!--Sweet Alert 2-->
    <script src="js/sweetalert2.all.min.js" type="text/javascript"></script>
    <script src="js/resumenCitaApp.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="jquery/popper.min.js" type="text/javascript"></script>
    <!--Fontawesome-->
    <script src="https://kit.fontawesome.com/27f204c8a9.js" crossorigin="anonymous"></script>

</html>