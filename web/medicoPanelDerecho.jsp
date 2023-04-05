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
                    <p class="mt-3 fw-bold fs-5">Registro de médicos</p>
                    <p>Bienvenido ${user.getNombre()}, desde esta área podrás registrar, actualiza y eliminar los datos
                        de tus médicos</p>
                </div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-3">
                            <a class="btn btn-success btn-nuevo">Nuevo médico</a>
                        </div>
                    </div>
                    <div class="row mt-2 pt-3 bg-light shadow">
                        <div class="container ">
                            <table class="table table-bordered text-center">
                                <thead>
                                    <tr>
                                        <th scope="col">Id medico</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Apellidos </th>
                                        <th scope="col" colspan="2">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>m01</td>
                                        <td>Naomi</td>
                                        <td>Garmendia Figueras</td>
                                        <td>
                                            <a class="btn btn-warning text-light btn-editar"
                                                href="UsuarioServlet?accion=editar&id=${ob.idusuario}"><i
                                                    class="fas fa-pen"></i></a>
                                        </td>
                                        <td>
                                            <!--Usamos button por que no queremos que vaya a ningun lado-->
                                            <button class="btn btn-danger mibtn-cancelar" data-id="${ob.idusuario}"><i
                                                    class="fas fa-trash"></i></button>

                                        </td>
                                    </tr>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!--FIN Panel principal derecho-->
            <!--MODAL-->
            <div class="modal" id="modalEditar" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">Editar</p>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p style="color:#ffb300; font-weight: bold;font-size: 30px;text-align: center;"> Editemos
                                los datos del médico</p>
                            <div class="col-12  py-3 px-3">
                                <div class="row">
                                    <!-- Grupo: Código de medico -->
                                    <div class="form-group">
                                        <label for="codmedico">Código de medico</label>
                                        <input type="text" class="form-control" name="codmedico" value="m01">
                                    </div>
                                    <!-- Grupo: Nombre -->
                                    <div class="form-group">
                                        <label for="especialidad">Nombre</label>
                                        <input type="text" class="form-control" name="especialidad" value="Naomi">
                                    </div>
                                    <!-- Grupo: Nombre -->
                                    <div class="form-group">
                                        <label for="apepat">Apellido Paterno</label>
                                        <input type="text" class="form-control" name="apepat" value="Garmendia">
                                    </div>
                                    <!-- Grupo: Nombre -->
                                    <div class="form-group">
                                        <label for="apemat">Apellido Materno</label>
                                        <input type="text" class="form-control" name="apemat" value="Figueroa">
                                    </div>
                                    <!-- Grupo: Nombre -->
                                    <div class="form-group">
                                        <label for="codusuario">Código de  Usuario</label>
                                        <input type="text" class="form-control" name="codusuario" value="cod03">
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a style="width: auto;padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;"
                                class="text-decoration-none btn-pagar" href="#">Actualizar</a>
                        </div>
                    </div>
                </div>
            </div>
            <!--FIN MODAL-->
            
             <!--MODAL REGISTRO MEDICO-->
            <div class="modal" id="modalRegistro" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">Registrar</p>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p style="color:#ffb300; font-weight: bold;font-size: 20px;text-align: center;"> Registremos los datos del médico</p>
                            <div class="col-12  py-3 px-3">
                                <div class="row">
                                    <!-- Grupo: Código de medico -->
                                    <div class="form-group">
                                        <label for="codmedico">Código de medico</label>
                                        <input type="text" class="form-control" name="codmedico" value="m01">
                                    </div>
                                    <!-- Grupo: Nombre -->
                                    <div class="form-group">
                                        <label for="especialidad">Nombre</label>
                                        <input type="text" class="form-control" name="especialidad" value="Naomi">
                                    </div>
                                    <!-- Grupo: Nombre -->
                                    <div class="form-group">
                                        <label for="apepat">Apellido Paterno</label>
                                        <input type="text" class="form-control" name="apepat" value="Garmendia">
                                    </div>
                                    <!-- Grupo: Nombre -->
                                    <div class="form-group">
                                        <label for="apemat">Apellido Materno</label>
                                        <input type="text" class="form-control" name="apemat" value="Figueroa">
                                    </div>
                                    <!-- Grupo: Nombre -->
                                    <div class="form-group">
                                        <label for="codusuario">Código de  Usuario</label>
                                        <input type="text" class="form-control" name="codusuario" value="cod03">
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a style="width: auto;padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;"
                                class="text-decoration-none btn-pagar" href="#">Crear</a>
                        </div>
                    </div>
                </div>
            </div>
            <!--FIN MODAL-->
        </body>

        </html>