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
                <p class="mt-3 fw-bold fs-5">Visualizar historias clínicas</p>
                <p>En esta Sección podras visualizar la historia clínica de cualquier paciente</p>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2 ps-0">
                        <input type="text" name="dni" id="dni" class="form-control" placeholder="Ingrese el DNI">

                    </div>
                    <div class="col-md-3 ps-0">
                        <a class="btn btn-warning" href="UsuarioServlet?accion=listar">buscar</a>
                    </div>
                </div>
                <div class="row mt-2 mb-3 pt-3 bg-light shadow">
                    <div class="container ">
                        <table class="table table-bordered text-center">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Fecha</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">DNI</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>2</td>
                                    <td>27/11/2022</td>
                                    <td>Jonathan Paniagua Ccahuana</td>
                                    <td>70030602</td>
                                    <td>Activo</td>
                                    <td>
                                        <a class="btn btn-primary text-light btn-ver" href="UsuarioServlet?accion=editar&id=${ob.idusuario}"><i class="fa fa-eye"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>26/11/2022</td>
                                    <td>Jonathan Paniagua Ccahuana</td>
                                    <td>70030602</td>
                                    <td>Activo</td>
                                    <td>
                                        <a class="btn btn-primary text-light btn-ver" href="UsuarioServlet?accion=editar&id=${ob.idusuario}"><i class="fa fa-eye"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>25/11/2022</td>
                                    <td>Jonathan Paniagua Ccahuana</td>
                                    <td>70030602</td>
                                    <td>Activo</td>
                                    <td>
                                        <a class="btn btn-primary text-light btn-ver" href="UsuarioServlet?accion=editar&id=${ob.idusuario}"><i class="fa fa-eye"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>24/11/2022</td>
                                    <td>Jonathan Paniagua Ccahuana</td>
                                    <td>70030602</td>
                                    <td>Activo</td>
                                    <td>
                                        <a class="btn btn-primary text-light btn-ver" href="UsuarioServlet?accion=editar&id=${ob.idusuario}"><i class="fa fa-eye"></i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>23/11/2022</td>
                                    <td>Jonathan Paniagua Ccahuana</td>
                                    <td>70030602</td>
                                    <td>Activo</td>
                                    <td>
                                        <a class="btn btn-primary text-light btn-ver" href="UsuarioServlet?accion=editar&id=${ob.idusuario}"><i class="fa fa-eye"></i></a>
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
        <div  class="modal" id="modalVer" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <p style="color: #5AC5C3;font-weight: bold;font-size: 30px;" class="modal-title">Detalle</p>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p style="color:#ffb300; font-weight: bold;font-size: 30px;text-align: center;">Detalle de la atención</p>
                        <div class="col-12  py-3 px-3">
                            <div class="row">
                                <!-- Grupo: Numero de Tarjeta -->
                                <div class="form-group">
                                    <label for="diagnostico">Diagnotico</label>
                                    <input type="text" class="form-control tarjeta" name="diagnostico" 
                                           placeholder="" value="Fiebre alta" >   
                                </div>
                                <div class="form-group">
                                    <label>Medicamento</label>
                                    <div class="row">
                                        <table class="table table-bordered text-center">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Medicamento / Dosis / Dias/ UM-FF / Cant</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><textarea style="height: 200px;" class="form-control" value=" Paracetamol / 1 cada 8 horas / 10 dias / TB / 20" ></textarea></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>


                    </div>
                </div>
            </div>
        </div>
        <!--FIN MODAL-->
    </body>
</html>
