<%-- 
    Document   : registro
    Created on : 02/10/2021, 10:58:48 PM
    Author     : Innova
--%>

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
        <link href="css/estilosregistro.css" rel="stylesheet" type="text/css"/>
        <title>Registrate</title>
    </head>
    <body>
        <!--Banner-->
        <div class="container-fluid" style="height: 50px">
            <div class="row bg-verdeclaro">
                <div class="col-md-4">
               
                </div>
            </div>
        </div>
        <!--fin Banner-->
        <div class="container-fluid">
            <!--inicia formulario-->
            <div class="row justify-content-center my-4">
                <div class="col-md-6 bg-verdeoscuro">
                    <div class="container bg-principal py-3 rounded ">
                        <div class="row">
                            <div class="col-12 text-center">
                                <p class="fw-bold h1 text-light">Crea una Cuenta</p>
                            </div>

                        </div>

                        <div class="row">
                            <form action="UsuarioLoginServlet" method = "POST" class="formulario" id="formulario">

                                <div class="row">
                                    <!-- Grupo: Nombre -->
                                    <div class="form-group col-md-6" id="grupo__nombre">
                                        <label for="nombre" class="formulario__label">Nombre</label>
                                        <div class="formulario__grupo-input">
                                            <input type="text" class="form-control" name="nombre" id="nombre"
                                                   placeholder="Jean Claud" value="${user.getNombre()}">
                                            <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                        </div>
                                        <c:if test="${rnombre != null}">
                                            <p class="text-danger ">${rnombre}</p>
                                        </c:if> 

                                    </div>
                                    <!-- Grupo: Apellido -->
                                    <div class="form-group col-md-6" id="grupo__apellido">
                                        <label for="apellido" class="formulario__label">Apellido</label>
                                        <div class="formulario__grupo-input">
                                            <input type="text" class="form-control" name="apellido" id="apellido"
                                                   placeholder="Van Damme" value="${user.getApellido()}">
                                            <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                        </div>
                                        <c:if test="${rapellido != null}">
                                            <p class="text-danger ">${rapellido}</p>
                                        </c:if>   
                                    </div>
                                </div>

                                <div class="row">
                                    <!-- Grupo: Tipo de Documento -->
                                    <div class="form-group col-md-6" id="grupo__tipodocumento">
                                        <label for="tipo_documento" class="formulario__label">Tipo de Documento</label>
                                        <div class="formulario__grupo-input">
                                            <select class="form-select" name="tipodocumento" id="tipodocumento">
                                                <option selected value="">Selecciona</option>
                                                <option value="Dni">Dni</option>
                                                <option value="CE">CE</option>
                                                <c:if test="${user.getTipo_documento() != null}">
                                                    <option selected value="${user.getTipo_documento()}">${user.getTipo_documento()}</option>
                                                </c:if>
                                            </select>

                                        </div>
                                        <c:if test="${rtipo != null}">
                                            <p class="text-danger ">${rtipo}</p>
                                        </c:if> 

                                    </div>
                                    <!-- Grupo: DNI -->
                                    <div class="form-group col-md-6" id="grupo__dni">
                                        <label for="dni" class="formulario__label">DNI</label>
                                        <div class="formulario__grupo-input">
                                            <input type="number" class="form-control" name="dni" id="dni"
                                                   placeholder="DNI ó CE" value="${user.getDni()}">
                                            <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                        </div>
                                        <c:if test="${rdni != null}">
                                            <p class="text-danger ">${rdni}</p>
                                            <c:if test="${dnirep != true}">
                                                <p class="text-danger">El Dni ya ha sido registrado anteriormente</p>
                                            </c:if>
                                        </c:if> 
                                    </div>
                                </div>

                                <div class="row">
                                    <!-- Grupo: Correo Electronico -->
                                    <div class="form-group col-md-6" id="grupo__correo">
                                        <label for="correo" class="formulario__label">Correo Electrónico</label>
                                        <div class="formulario__grupo-input">
                                            <input type="email" class="form-control" name="correo" id="correo"
                                                   placeholder="correo@correo.com" value="${user.getEmail()}">
                                            <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                        </div>
                                        <c:if test="${rcorreo != null}">
                                            <p class="text-danger ">${rcorreo}</p>
                                            <c:if test="${correorep != true}">
                                                <p class="text-danger">El correo ya ha sido registrado anteriormente</p>
                                            </c:if>
                                        </c:if> 
                                    </div>

                                    <!-- Grupo: Contraseña -->
                                    <div class="form-group col-md-6" id="grupo__password">
                                        <label for="password" class="formulario__label">Contraseña</label>
                                        <div class="formulario__grupo-input">
                                            <input type="password" class="form-control" name="password" id="password" placeholder="Password" value="${user.getPassword()}">
                                            <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                        </div>
                                        <c:if test="${rpass != null}">
                                            <p class="text-danger ">${rpass}</p>
                                        </c:if> 

                                    </div>
                                </div>

                                <div class="row">
                                    <!-- Grupo: Teléfono -->
                                    <div class="form-group col-md-6" id="grupo__telefono">
                                        <label for="telefono" class="formulario__label">Teléfono</label>
                                        <div class="formulario__grupo-input">
                                            <input type="text" class="form-control" name="telefono" id="telefono"
                                                   placeholder="987 654 321" value="${user.getTelefono()}">
                                            <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                        </div>
                                        <c:if test="${rtelefono != null}">
                                            <p class="text-danger ">${rtelefono}</p>
                                        </c:if> 
                                    </div>
                                </div>
                                <div class="form-group mt-3 text-center">
                                    <input type="submit" name="accion" value="Registrar" class=" flex btn btn-secondary fs-4">
                                    <a class="btn btn-secondary fs-4" href="login.jsp">Volver</a>
                                    
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="jquery/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="jquery/popper.min.js" type="text/javascript"></script>
    <script src="js/registro.js" type="text/javascript"></script>
    <!--Fontawesome-->
    <script src="https://kit.fontawesome.com/27f204c8a9.js" crossorigin="anonymous"></script>
</html>
