<%-- 
    Document   : adminPanelIzquierdo
    Created on : 24/11/2022, 02:46:04 PM
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
        <div class="col-md-2 bg-dark px-0">
            <div class="navbar navbar-expand-lg text-light">
                <div class="container-fluid px-0">
                    <div class="collapse navbar-collapse justify-content-center px-0" id="navbarNavDropdown">
                        <div class="row">
                            <div class="col-12 altura px-0">
                                <a class="text-decoration-none text-light btn btn-dark rounded-0 py-3" style="width: 225px;" href="controladorAd?action=listarEspecialidades"><i class="fas fa-store"></i> Especialidades</a>  <br>
                                <a class="text-decoration-none text-light btn btn-dark rounded-0 py-3" style="width: 225px;" href="medico.jsp"><i class="fas fa-window-restore"></i> Medicos</a>  <br>
                                <a class="text-decoration-none text-light btn btn-dark rounded-0 py-3" style="width: 225px;" href="rol.jsp"><i class="fas fa-star"></i> Roles</a>  <br>
                                <a class="text-decoration-none text-light btn btn-dark rounded-0 py-3" style="width: 225px;" href="reservas.jsp"><i class="fas fa-desktop"></i> Citas medicas</a>  <br>
                                <a class="text-decoration-none text-light btn btn-dark rounded-0 py-3" style="width: 225px;" href="controladorAd?action=listarTurnos"><i class="fas fa-desktop"></i> Turnos Medicos</a>  <br>
                                <a class="text-decoration-none text-light btn btn-dark rounded-0 py-3" style="width: 225px;" href="consultorio.jsp"><i class="fas fa-people-carry"></i> Consultorios</a><br>
                                <a class="text-decoration-none text-light btn btn-dark rounded-0 py-3" style="width: 225px;" href="password.jsp"><i class="fas fa-unlock-alt"></i> Cambiar contraseña</a>  <br>
                                <a class="text-decoration-none text-light btn btn-dark rounded-0 py-3" style="width: 225px;" href="controladorAd?action=listarUsuarios"><i class="fas fa-user"></i> Usuarios</a>  <br>
                                <a class="text-decoration-none text-light btn btn-dark rounded-0 py-3" style="width: 225px;" href="historiaClinica.jsp"><i class="fas fa-user"></i> Historia Clinica</a>  <br>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
