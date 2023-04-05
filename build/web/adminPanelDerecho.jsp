<%-- 
    Document   : adminPanelDerecho
    Created on : 24/11/2022, 02:50:57 PM
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
        <div class="col-md-10 bg-gris">
            <div class="row">
                <p class="mt-3 fw-bold fs-5">Panel de Control</p>
                <p>Bienvenido ${user.getNombre()}, desde esta área podrás observar el Proceso de tus Pedidos y Ventas</p>
            </div>
            <div class="row justify-content-around text-center ">
                <div class="col-md-2 "><a class="btn btn-warning d-grid rounded-0 fs-1 mx-0 shadow"
                                          style="height: 100px;" href="#">24 <span class="fs-5"><i class="fas fa-shopping-cart"></i>
                            Pendientes</span></a></div>
                <div class="col-md-2 "><a class="btn btn-success d-grid rounded-0 fs-1 shadow" style="height: 100px;"
                                          href="#">10 <span class="fs-5"><i class="fas fa-desktop"></i> Vendidos</span></a></div>
                <div class="col-md-2"><a class="btn btn-primary d-grid rounded-0 fs-1 shadow" style="height: 100px;"
                                         href="#">400 <span class="fs-5"> <i class="fas fa-store"></i> stock</span></a></div>
                <div class="col-md-2"><a class="btn btn-secondary d-grid rounded-0 fs-1 shadow"
                                         style="height: 100px;" href="#">304 <span class="fs-5"><i class="fas fa-globe-europe"></i>
                            Registrados</span></a></div>
            </div>

            <div class="row mt-4">
                <div class="col-md-4 bg-gris shadow">
                    <table class="table bg-light table-hover p-1">
                        <p class="fw-bold text-center pt-2 bg-light mb-0">Productos mas vendidos</p>
                        <thead>
                            <tr>
                                <th scope="col">Top</th>
                                <th scope="col">Producto</th>
                                <th scope="col">Categoría</th>
                                <th scope="col">Subcategoria</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="bg-warning">
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">5</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                        </tbody>
                    </table>

                </div>
                <!--Productos en estado pendiente-->
                <div class="col-md-8 bg-light shadow">
                    <table class="table table-bordered table-hover">
                        <p class="fw-bold text-center pt-2 bg-light mb-0">Productos Pendientes de atención</p>
                        <thead>
                            <tr>
                                <th scope="col">Codigo</th>
                                <th scope="col">Producto</th>
                                <th scope="col">Cliente</th>
                                <th scope="col">Fecha Pedido</th>
                                <th scope="col">Estado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Broncotol</td>
                                <td>Otto Quispe</td>
                                <td>01/09/2021</td>
                                <td class="bg-warning text-light text-center">Pendiente</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Broncotol</td>
                                <td>Otto Quispe</td>
                                <td>01/09/2021</td>
                                <td class="bg-warning text-light  text-center">Pendiente</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Broncotol</td>
                                <td>Otto Quispe</td>
                                <td>01/09/2021</td>
                                <td class="bg-warning text-light  text-center">Pendiente</td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td>Broncotol</td>
                                <td>Otto Quispe</td>
                                <td>01/09/2021</td>
                                <td class="bg-warning text-light  text-center">Pendiente</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </body>
</html>
