<%-- 
    Document   : medico_lista
    Created on : 24/11/2022, 11:14:04 AM
    Author     : Jonathan
--%>

<%@page import="dto.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- CSS -->
        <link href="css/administrador.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turnos Medicos</title>
    </head>
    <body>
        <%

            HttpSession sesion = request.getSession();
            Usuario usu = (Usuario) sesion.getAttribute("user");
            //Si alguien ingresar al link: administrador.jsp
            if (usu != null) {//Inicio Sesión: osea el objeto existe
                if (usu.getNombrerol().equalsIgnoreCase("Cliente")) {
                    request.getRequestDispatcher("login.jsp").forward(request, response);

                }
            }

        %>
        <%@include file="adminHeader.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <!--Panel izquierdo-->
                <%@include file="adminPanelIzquierdo.jsp" %>
                <!--Panel principal derecho-->
                
                <!--INICIA Panel principal derecho Turnos Medicos-->
                <div class="col-md-10 bg-gris">
                    <div class="row">
                        <p class="mt-3 fw-bold fs-5">Registro Turnos Medicos</p>
                        <p>Bienvenido ${user.getNombre()}, desde esta área podrás registrar, actualiza y eliminar los Turnos Medicos</p>
                    </div>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-3"> 
                                <a class="btn btn-success btn-crear" href="">Registrar Turno</a>
                            </div> 
                        </div>
                        <div class="row mt-2 pt-3 bg-light shadow">
                            <div class="container ">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">Fecha</th>
                                            <th scope="col">Hora</th>
                                            <th scope="col">Especialidad</th>
                                            <th scope="col">Medico</th>
                                            <th scope="col">Disponible</th>
                                            <th scope="col" colspan="2">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${turnosList}" var='ul'>
                                        <tr>
                                            <td>${ul.fecha}</td>
                                            <td>${ul.hora}</td>
                                            <td>${ul.especialidad} ${e.nombre}</td>
                                            <td>${ul.medico}</td>
                                            <td>${ul.disponible}</td>
                                            <td>
                                                <a class="btn btn-warning text-light btn-editar" href=""><i class="fas fa-pen"></i></a>
                                            </td>
                                            <td>
                                                <!--Usamos button por que no queremos que vaya a ningun lado-->
                                                <button class="btn btn-danger mibtn-cancelar" data-id="${ob.idusuario}" ><i class="fas fa-trash"></i></button>

                                            </td>

                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div><!--FIN Panel principal derecho-->
                        
            </div> <!--fin row-->
        </div> <!--container-fluid -->


    </body>
    <script src="jquery/jquery-3.6.0.min.js" type="text/javascript"></script> 
    <!--Sweet Alert 2-->
    <script src="js/sweetalert2.all.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="jquery/popper.min.js" type="text/javascript"></script>
    <script src="js/turnoApp.js" type="text/javascript"></script>
    <!--Fontawesome-->
    <script src="https://kit.fontawesome.com/27f204c8a9.js" crossorigin="anonymous"></script>
</html>
