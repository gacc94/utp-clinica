<%-- 
    Document   : login
    Created on : 19/10/2022, 07:54:15 PM
    Author     : Jonathan
--%>
<%@page import="dto.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!--css personal-->
        <link href="css/estiloslogin.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
         <div class="container-fluid">
            <div class="row justify-content-center " style="margin-top: 100px" >
                <div class="col-md-4 bg-verdeoscuro">
                    <div class="container  py-3 rounded ">
                        <h1 class="text-center text-light fw-bold">Login</h1>
                        <!--login -->
                        <form action="UsuarioLoginServlet" id="formlogin" method="POST">
                            <c:if test="${noexiste != null}">
                                <p class="text-danger">${noexiste}</p>
                            </c:if>
                            <div class=" mb-2 ">
                                <input class="form-control rounded-lg " type="text" name="txtcorreo" id="correo" placeholder="Jhon@correo.com">
                                <c:if test="${msjeEmail != null}">
                                    <p class="text-danger">${msjeEmail}</p>
                                </c:if>
                            </div>
                            <div class="mb-4">

                                <input class="form-control" type="password" name="txtpassword" id="contraseña" placeholder="Password">
                                <c:if test="${msjePass != null}">
                                    <p class="text-danger">${msjePass}</p>
                                </c:if>
                            </div>
                                <c:if test="${bloqueado !=null}">
                                    <p class="text-danger">${bloqueado}</p>
                                </c:if> 
                            <div class="d-grid">
                                <!-- estira el boton en todo el contenedor -->
                                <input class="btn btn-secondary rounded-pill text-light fw-bold " type="submit" name="accion" value="Ingresar">
                                <a class=" text-light text-center mt-2" href="recuperar.jsp">¿Olvidaste tu contraseña?</a>
                            </div>
                            <div class="d-grid mt-2">
                                <a class="btn btn-secondary text-light  rounded-pill fw-bold " href="registro.jsp">¿No tienes cuenta? Registrate aquí</a>
                                <a class=" text-light text-center mt-2" href="principal.jsp"> Página Principal </a>
                            </div>
                        </form>
                    </div>

                </div>
            </div>

        </div>
        <script type="text/javascript">
                history.pushState(null, null, location.href);
                history.back();
                history.forward();
                window.onpopstate = function () { history.go(1); };
        </script>
    </body>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="jquery/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="jquery/popper.min.js" type="text/javascript"></script>
    <!--Fontawesome-->
    <script src="https://kit.fontawesome.com/27f204c8a9.js" crossorigin="anonymous"></script>
</html>
