<%-- Document : bienvenida Created on : 28/10/2022, 11:24:02 PM Author : Jonathan --%>

<%@page import="dto.Reserva"%>
<%@page import="dao.impl.DaoReservaImpl"%>
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

        </div>
        <input type="hidden" value="${user.getIdusuario()}" id="idUsuario" >
        <!--Body-->
        <div class="container justify-content-center">
            <div class="row">
                <h1 style="color: #5AC5C3;font-weight: bold;">Historial de citas</h1>
                <p style="color:#ffb300; font-weight: bold" >Mira tu historial de citas... Próximas y Pasadas.</p>
            </div>
            <div class="row justify-content-center">
                <table style="width: 80%;" class="">
                    <thead>
                        <tr style="text-align: center;">
                            <td style="text-align: center;background: #5AC5C3;color: #fff;">Fecha Compra</td>
                            <td style="text-align: center;background: #5AC5C3;color: #fff;">Paciente</td>
                            <td style="text-align: center;background: #5AC5C3;color: #fff;">Especialidad</td>
                            <td style="text-align: center;background: #5AC5C3;color: #fff;">Medico</td>
                            <td style="text-align: center;background: #5AC5C3;color: #fff;">Fecha y hora de Reserva</td>
                            <td style="text-align: center;background: #5AC5C3;color: #fff;">Precio S/.</td>
                            <td style="text-align: center;background: #5AC5C3;color: #fff;">Estado</td>
                            <td style="text-align: center;background: #5AC5C3;color: #fff;"><i class="fa fa-download"></i></td>
                            <td style="text-align: center;background: #5AC5C3;color: #fff;"><i class="fa fa-file-text-o"></i></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="reserva" items="${historial}" >
                            <tr>
                                <td style="text-align: center;">${reserva.getFecha_reserva()}</td>
                                <td style="text-align: center;">${reserva.getNombre_usuario()} ${reserva.getApellido_usuario()}</td>
                                <td style="text-align: center;">${reserva.getNombre_especialidad()}</td>
                                <td style="text-align: center;">${reserva.getNombre_medico()} ${reserva.getApellidopat_medico()} ${reserva.getApellidomat_medico()}</td>
                                <td style="text-align: center;">${reserva.getFecha()}${reserva.getHora()}</td>
                                <td style="text-align: center;">${reserva.getPrecio()}</td>
                                <td style="text-align: center;">${reserva.getEstado_cita()}</td>
                                <td style="text-align: center;"><i class="fa fa-file-pdf-o"></i></td>
                                <td style="text-align: center;"><i class="fa fa-file-text-o"></i></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <c:if test="${historial == null}">
                <div style="width: 80%;margin:20px auto;" class="row">
                    <p style="margin-bottom: 0;background: #ffecb3;color: #ffb300;;font-weight: bold;">
                        No hay citas registradas, intenta realizar una cita...
                    </p>
                </div>
            </c:if>

            <div style="width: 80%;margin:20px auto;justify-content: space-evenly;" class="row">
                <a style="width: auto;padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;"
                   class="text-decoration-none" href="seleccionarCita.jsp">Programar una cita</a>
            </div>

        </div>

    </body>
    <script src="jquery/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="js/historialCitaApp.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="jquery/popper.min.js" type="text/javascript"></script>

    <!--Fontawesome-->
    <script src="https://kit.fontawesome.com/27f204c8a9.js" crossorigin="anonymous"></script>

</html>