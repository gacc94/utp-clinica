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
        <title>JSP Page</title>
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
                <%@include file="historiaClinicaPanelDerecho.jsp" %>
            </div>
        </div>


    </body>
    <script src="jquery/jquery-3.6.0.min.js" type="text/javascript"></script> 
    <!--Sweet Alert 2-->
    <script src="js/sweetalert2.all.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="jquery/popper.min.js" type="text/javascript"></script>
    <script src="js/historiaClinicaApp.js" type="text/javascript"></script>
    <!--Fontawesome-->
    <script src="https://kit.fontawesome.com/27f204c8a9.js" crossorigin="anonymous"></script>
</html>
