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
                <p class="mt-3 fw-bold fs-5">Registro de roles</p>
                <p>Bienvenido ${user.getNombre()}, desde esta área podrás registrar, actualiza y eliminar los datos de tus roles</p>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3"> 
                        <a class="btn btn-success btn-crear" href="#">Nuevo rol</a>
                    </div> 
                </div>
                <div class="row mt-2 pt-3 bg-light shadow">
                    <div class="container ">
                        <table class="table table-bordered text-center">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Descripción</th>
                                    <th scope="col" colspan="2">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>2</td>
                                    <td>Paciente</td>
                                    <td>Es el cliente del negocio</td>
                                    <td>
                                        <a class="btn btn-warning text-light btn-editar" href="#"><i class="fas fa-pen"></i></a>
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
        <!--MODAL EDITAR-->
        <div  class="modal" id="modalEditar" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header text-align-center">
                        <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">Editar</p>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p style="color:#ffb300; font-weight: bold;font-size: 30px;text-align: center;">Editemos el rol</p>
                        <div class="col-12  py-3 px-3">
                            <div class="row">
                                <!-- Grupo: ID -->
                                <div class="form-group">
                                    <label for="id">Id</label>
                                    <input type="text" class="form-control cvv" name="id" value=""
                                           placeholder="">
                                </div>
                                <!-- Grupo: NOMBRE -->
                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control cvv" name="nombre" value=""
                                           placeholder="">
                                </div>
                                <!-- Grupo: DESCRIPCION -->
                                <div class="form-group">
                                    <label for="descripcion" >Descripción</label>
                                    <input type="text" class="form-control email" name="email" value=""
                                           placeholder="" value="">
                                </div>
                            </div>

                        </div>


                    </div>
                    <div class="modal-footer">
                        <a style="width: auto;padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;"
                           class="text-decoration-none btn-pagar" href="#" ><i style="margin-right: 5px;padding-top: 5px;"
                                                                            class="fa fa-credit-card"></i> Pagar</a>
                    </div>
                </div>
            </div>
        </div>
        <!--FIN MODAL EDITAR-->

        <!--MODAL CREAR-->
        <div  class="modal" id="modalCrear" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">Crear</p>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p style="color:#ffb300; font-weight: bold;font-size: 30px;text-align: center;">Crear rol</p>
                        <div class="col-12  py-3 px-3">
                            <div class="row">
                                <!-- Grupo: NOMBRE -->
                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" class="form-control cvv" name="nombre" value=""
                                           placeholder="">
                                </div>
                                <!-- Grupo: DESCRIPCION -->
                                <div class="form-group">
                                    <label for="descripcion" >Descripción</label>
                                    <input type="text" class="form-control email" name="email" value=""
                                           placeholder="" value="">
                                </div>
                            </div>

                        </div>


                    </div>
                    <div class="modal-footer">
                        <a style="width: auto;padding: 10px;background: #44469D;color: #ffff;border-radius: 10px;display: flex;justify-content: center;font-size: 20px;font-weight: bold;"
                           class="text-decoration-none btn-pagar" href="#" ><i style="margin-right: 5px;padding-top: 5px;"
                                                                            class="fa fa-credit-card"></i> Pagar</a>
                    </div>
                </div>
            </div>
        </div>
        <!--FIN MODAL CREAR-->
    </body>
</html>
