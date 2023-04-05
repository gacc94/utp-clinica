<%-- 
    Document   : index.jsp
    Created on : 15/09/2021, 08:39:03 PM
    Author     : Innova
--%>

<%@page import="dto.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!--css personal-->
        <link href="css/administrador.css" rel="stylesheet" type="text/css"/>
        <!--fuente de letra-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300&display=swap" rel="stylesheet">
        <title>Farma Store</title>
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
                <%@include file="adminPanelDerecho.jsp" %>
            </div>
        </div>


    </body>
    <script src="jquery/jquery-3.6.0.min.js" type="text/javascript"></script> 
    <!--Sweet Alert 2-->
    <script src="js/sweetalert2.all.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="jquery/popper.min.js" type="text/javascript"></script>
    <!--Fontawesome-->
    <script src="https://kit.fontawesome.com/27f204c8a9.js" crossorigin="anonymous"></script>
</html>
