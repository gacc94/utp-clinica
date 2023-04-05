<%-- 
    Document   : adminHeader
    Created on : 24/11/2022, 02:38:36 PM
    Author     : Jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--Inicio Navbar-->
        <nav class="navbar navbar-expand-lg navbar-light bg-azul">
            <div class="container-fluid">
                <a class="navbar-brand text-light fs-4" href="administrador.jsp">Administración</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdownMenuLink"
                               role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fas fa-user"></i> ${user.getNombre()} ${user.getApellido()}
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end text-center bg-azul"
                                aria-labelledby="navbarDropdownMenuLink">
                                <li><a class="dropdown-item text-light" href="#">${user.getEmail()}</a></li>
                                <li><a class="dropdown-item text-light" href="#">Cambiar contraseña</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item text-light" href="UsuarioLoginServlet?accion=salir">Salir</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--Fin Navbar-->
    </body>
</html>
