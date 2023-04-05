<%-- 
    Document   : reservaPanelDerecho
    Created on : 24/11/2022, 02:57:49 PM
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
        <!--INICIA Panel principal derecho-->
        <div class="col-md-10 bg-gris">
            <div class="row">
                <p class="mt-3 fw-bold fs-5">Registro de Usuarios</p>
                <p>Bienvenido ${user.getNombre()}, desde esta área podrás registrar, actualiza y eliminar los datos de tus usuarios</p>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3"> 
                        <a class="btn btn-success btn-crear" href="">Nuevo Usuario</a>
                    </div> 
                </div>
                <div class="row mt-2 pt-3 bg-light shadow">
                    <div class="container ">
                        <table class="table table-bordered text-center">
                            <thead>
                                <tr>
                                    <th scope="col">Id Usuario</th>
                                    <th scope="col">Id Paciente</th>
                                    <th scope="col">Rol</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col" colspan="2">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>CODPA77665544</td>
                                    <td>Paciente</td>
                                    <td>Jonathan Paniagua Ccahuana</td>
                                    <td>jpaniagua@gmail.com</td>
                                    <td>983514699</td>
                                    <td>Activo</td>
                                    <td>
                                        <a class="btn btn-warning text-light btn-editar" href=""><i class="fas fa-pen"></i></a>
                                    </td>
                                    <td>
                                        <!--Usamos button por que no queremos que vaya a ningun lado-->
                                        <button class="btn btn-danger mibtn-cancelar" data-id="${ob.idusuario}" ><i class="fas fa-trash"></i></button>

                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!--FIN Panel principal derecho-->
        <!--MODAL CREAR-->
        <div class="modal" id="modalCrear" tabindex="-1">
            <div class="modal-dialog">
                <div  class="modal-content">
                    <div class="modal-header">
                        <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">Nuevo Usuario</p>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p style="color:#ffb300; font-weight: bold;font-size: 30px;text-align: center;"> Crea una nuevo usuario</p>
                        <div class="col-12  py-3 px-3">
                            <div class="row">
                                <!-- Grupo: Rol -->
                                <div class="form-group">
                                    <label for="cboRol">RoL</label>
                                    <select class="form-select" name="cboRol" id="cboRol">
                                        <option value="101">Administrador</option>
                                        <option value="102">Medico</option>
                                        <option value="102">Paciente</option>
                                        <option value="102">Enfermera</option>
                                    </select>
                                </div>
                                <!-- Grupo: Código de especialidad -->
                                <div class="form-group">
                                    <label for="Codespecialidad">Nombre</label>
                                    <input type="text" class="form-control" name="Codespecialidad" value="" placeholder="Jhon Doe">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="especialidad">Apellido Paterno</label>
                                    <input type="text" class="form-control" name="especialidad" value="" placeholder="Pacheco">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="especialidad">Apellido Materno</label>
                                    <input type="text" class="form-control" name="especialidad" value="" placeholder="Suarez">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="email">Correo</label>
                                    <input type="email" class="form-control" name="email" value="" placeholder="jpaniagua@gmail.com">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" name="password" value="" placeholder="*************">
                                </div>
                                <!-- Grupo: Medico -->
                                <div class="form-group">
                                    <label for="tipoDocumento">Tipo Documento</label>
                                    <select class="form-select" name="tipoDocumento" id="tipoDocumento">
                                        <option value="Medico 1">DNI</option>
                                        <option value="Medico 2">C.E.</option>
                                    </select>
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="dni">Dni</label>
                                    <input type="text" class="form-control" name="dni" value="" placeholder="70030602">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="telefono">Telefono</label>
                                    <input type="text" class="form-control" name="telefono" value="" placeholder="983514699">
                                </div>
                                <!-- Grupo: Medico -->
                                <div class="form-group">
                                    <label for="cboEstado">Estado</label>
                                    <select class="form-select" name="cboEstado" id="cboEstado">
                                        <option value="Activo">Activo</option>
                                        <option value="Bloqueado">Bloqueado</option>
                                    </select>
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
        <!--FIN MODAL CREAR-->

        <!--MODAL EDITAR-->
        <div class="modal" id="modalEditar" tabindex="-1">
            <div class="modal-dialog">
                <div  class="modal-content">
                    <div class="modal-header">
                        <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">Editar</p>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p style="color:#ffb300; font-weight: bold;font-size: 30px;text-align: center;"> Editemos el usuario</p>
                        <div class="col-12  py-3 px-3">
                            <div class="row">
                                <!-- Grupo: Código de especialidad -->
                                <div class="form-group">
                                    <label for="codUsuario">Codigo de Usuario</label>
                                    <input type="text" class="form-control" name="codUsuario" value="cod0120202" disabled>
                                </div>
                                <!-- Grupo: Rol -->
                                <div class="form-group">
                                    <label for="cboRol">RoL</label>
                                    <select class="form-select" name="cboRol" id="cboRol">
                                        <option value="101">Administrador</option>
                                        <option value="102">Medico</option>
                                        <option value="102">Paciente</option>
                                    </select>
                                </div>
                                <!-- Grupo: Código de especialidad -->
                                <div class="form-group">
                                    <label for="Codespecialidad">Nombre</label>
                                    <input type="text" class="form-control" name="Codespecialidad" value="" placeholder="Jhon Doe">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="especialidad">Apellido Paterno</label>
                                    <input type="text" class="form-control" name="especialidad" value="" placeholder="Pacheco">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="especialidad">Apellido Materno</label>
                                    <input type="text" class="form-control" name="especialidad" value="" placeholder="Suarez">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="email">Correo</label>
                                    <input type="email" class="form-control" name="email" value="" placeholder="jpaniagua@gmail.com">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" name="password" value="" placeholder="*************">
                                </div>
                                <!-- Grupo: Medico -->
                                <div class="form-group">
                                    <label for="tipoDocumento">Tipo Documento</label>
                                    <select class="form-select" name="tipoDocumento" id="tipoDocumento">
                                        <option value="Medico 1">DNI</option>
                                        <option value="Medico 2">C.E.</option>
                                    </select>
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="dni">Dni</label>
                                    <input type="text" class="form-control" name="dni" value="" placeholder="70030602">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="telefono">Telefono</label>
                                    <input type="text" class="form-control" name="telefono" value="" placeholder="983514699">
                                </div>
                                <!-- Grupo: Medico -->
                                <div class="form-group">
                                    <label for="cboEstado">Estado</label>
                                    <select class="form-select" name="cboEstado" id="cboEstado">
                                        <option value="Activo">Activo</option>
                                        <option value="Bloqueado">Bloqueado</option>
                                    </select>
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
        <!--FIN MODAL EDITAR-->
    </body>
</html>
