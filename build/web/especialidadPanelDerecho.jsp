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
                <p class="mt-3 fw-bold fs-5">Registro de especialidades</p>
                <p>Bienvenido ${user.getNombre()}, desde esta área podrás registrar, actualiza y eliminar los datos
                    de tus especialidades</p>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">
                        <a class="btn btn-success btn-crear" href="#">Nueva especialidad</a>
                    </div>
                </div>
                <div class="row mt-2 pt-3 bg-light shadow">
                    <div class="container ">
                        <table class="table table-bordered text-center">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">Medico</th>
                                    <th scope="col">Consultorio</th>
                                    <th scope="col">precio S/.</th>
                                    <th scope="col" colspan="2">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Esp01</td>
                                    <td>Cardiología</td>
                                    <td>Naomi Armendia Figueras</td>
                                    <td>101</td>
                                    <td>50.00</td>
                                    <td>
                                        <a class="btn btn-warning text-light btn-editar" href="#"><i
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
        <!--MODAL EDITAR-->
        <div class="modal" id="modalEditar" tabindex="-1">
            <div class="modal-dialog">
                <div  class="modal-content">
                    <div class="modal-header">
                        <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">Editar</p>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p style="color:#ffb300; font-weight: bold;font-size: 30px;text-align: center;"> Editemos la especialidad</p>
                        <div class="col-12  py-3 px-3">
                            <div class="row">
                                <!-- Grupo: Código de especialidad -->
                                <div class="form-group">
                                    <label for="Codespecialidad">Código de especialidad</label>
                                    <input type="text" class="form-control" name="Codespecialidad" value="Esp01">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="especialidad">Especialidad</label>
                                    <input type="text" class="form-control" name="especialidad" value="Cardiología">
                                </div>
                                <!-- Grupo: Medico -->
                                <div class="form-group">
                                    <label for="cbomedico">Médico</label>
                                    <select class="form-select" name="cbomedico" id="">
                                        <option value="Medico 1">Medico 1</option>
                                        <option value="Medico 2">Medico 2</option>
                                    </select>
                                </div>
                                <!-- Grupo: Consultorio -->
                                <div class="form-group">
                                    <label for="cboconsultorio">Consultorio</label>
                                    <select class="form-select" name="cboconsultorio" id="">
                                        <option value="101">101</option>
                                        <option value="102">102</option>
                                    </select>
                                </div>
                                <!-- Grupo: Precio -->
                                <div class="form-group">
                                    <label for="precio">Precio S/.</label>
                                    <input type="text" class="form-control" name="precio" value="50.00">
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

        <!--MODAL CREAR-->
        <div class="modal" id="modalCrear" tabindex="-1">
            <div class="modal-dialog">
                <div  class="modal-content">
                    <div class="modal-header">
                        <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">Nueva especialidad</p>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p style="color:#ffb300; font-weight: bold;font-size: 30px;text-align: center;"> Crea una nueva especialidad</p>
                        <div class="col-12  py-3 px-3">
                            <div class="row">
                                <!-- Grupo: Código de especialidad -->
                                <div class="form-group">
                                    <label for="Codespecialidad">Código de especialidad</label>
                                    <input type="text" class="form-control" name="Codespecialidad" value="Esp01">
                                </div>
                                <!-- Grupo: Nombre especialidad -->
                                <div class="form-group">
                                    <label for="especialidad">Especialidad</label>
                                    <input type="text" class="form-control" name="especialidad" value="Cardiología">
                                </div>
                                <!-- Grupo: Medico -->
                                <div class="form-group">
                                    <label for="cbomedico">Médico</label>
                                    <select class="form-select" name="cbomedico" id="">
                                        <option value="Medico 1">Medico 1</option>
                                        <option value="Medico 2">Medico 2</option>
                                    </select>
                                </div>
                                <!-- Grupo: Consultorio -->
                                <div class="form-group">
                                    <label for="cboconsultorio">Consultorio</label>
                                    <select class="form-select" name="cboconsultorio" id="">
                                        <option value="101">101</option>
                                        <option value="102">102</option>
                                    </select>
                                </div>
                                <!-- Grupo: Precio -->
                                <div class="form-group">
                                    <label for="precio">Precio S/.</label>
                                    <input type="text" class="form-control" name="precio" value="50.00">
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

    </body>

</html>