<%-- Document : reservaPanelDerecho Created on : 24/11/2022, 02:57:49 PM Author : Jonathan --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>

        <body>
            <!--INICIA Panel principal derecho-->
            <div class="col-md-10 bg-gris">
                <div class="row">
                    <p class="mt-3 fw-bold fs-5">Modificar Contraseña</p>
                    <p>En esta Sección podras modificar la contraseñade cualquier usuario</p>
                </div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-2 ps-0">
                            <input type="text" name="dni" id="dni" class="form-control" placeholder="Ingresa el DNI">

                        </div>
                        <div class="col-md-3 ps-0">
                            <a class="btn btn-warning" href="UsuarioServlet?accion=listar">buscar</a>
                        </div>
                    </div>
                    <div class="row mt-2 mb-3 pt-3 bg-light shadow">
                        <div class="container ">
                            <form action="UsuarioServlet" method="POST">
                                <div class="row g-3">
                                    <div class="col-md-6">
                                        <!--GRUPO ROL -->
                                        <label for="cborol" aria-label="Default select example">Rol</label>
                                        <input class="form-control" type="text" name="nombre" value="${lista.nombrerol}"
                                            id="" placeholder="" disabled>

                                    </div>
                                    <!--GRUPO NOMBRE -->
                                    <div class="col-md-6">
                                        <label for="nombre">Nombre:</label>
                                        <input class="form-control" type="text" name="nombre" value="${lista.nombre}"
                                            id="" placeholder="" disabled>
                                    </div>
                                </div>
                                <!--fila 2 del formulario -->
                                <div class="row g-3">
                                    <!--GRUPO APELLIDO -->
                                    <div class="col-md-6">
                                        <label for="apellido">Apellido Paterno</label>
                                        <input class="form-control" type="text" value="${lista.apellido}"
                                            name="apellido" id="" placeholder="" disabled>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="apellido">Apellido Materno</label>
                                        <input class="form-control" type="text" value="${lista.apellido}"
                                            name="apellido" id="" placeholder="" disabled>
                                    </div>
                                    <!-- Fecha de Estado -->
                                    <div class="col-md-6">
                                        <label for="cboestado">Estado</label>
                                        <input class="form-control" type="text" value="${lista.estado}" name="apellido"
                                            id="" placeholder="" disabled>
                                    </div>
                                </div>
                                <div class="row g-3">
                                    <!-- GRUPO CORREO -->
                                    <div class="col-md-6">
                                        <label for="correo">Correo</label>
                                        <input type="email" value="${lista.email}" name="correo" class="form-control" disabled>
                                    </div>
                                    <!-- Contraseña -->
                                    <div class="col-md-6">
                                        <label for="password">Nueva Contraseña</label>
                                        <input type="text" value="${lista.password}" name="password"
                                            class="form-control">
                                    </div>
                                </div>


                                <div class="form-group my-2">
                                    <input type="hidden" name="txtid" value="${lista.idusuario}">
                                    <input type="submit" name="accion" value="actualizar" class="btn btn-success">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!--FIN Panel principal derecho-->
        </body>

        </html>