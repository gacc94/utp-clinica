package web.servlet;

import dao.impl.DaoDetalle_VentasImpl;
import dao.impl.DaoPacienteImpl;
import dao.impl.DaoProductosImpl;
import dao.impl.DaoReservaImpl;
import dao.impl.DaoUsuarioRegistroImpl;
import dao.impl.DaoVentaImpl;
import dto.Carrito;
import dto.Detalle_Ventas;
import dto.Paciente;
import dto.Productos;
import dto.Reserva;
import dto.Usuario;
import dto.Venta;
import dto.misCompras;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import web.validator.UsuarioValidator;
import web.validator.pagoValidator;

public class UsuarioLoginServlet extends HttpServlet {

    //Usuario
    Usuario userlogin = null;
    DaoUsuarioRegistroImpl dao = new DaoUsuarioRegistroImpl();
    UsuarioValidator val = new UsuarioValidator();
    
    //Paciente
    DaoPacienteImpl daopa = new DaoPacienteImpl();

    //Venta
    pagoValidator valp = null;
    DaoProductosImpl daoprod = new DaoProductosImpl();
    DaoDetalle_VentasImpl dvdao = new DaoDetalle_VentasImpl();
    DaoVentaImpl ventadao = new DaoVentaImpl();
    Productos ob = null;
    ArrayList<Productos> lista = new ArrayList<>();
    ArrayList<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    
    //Reserva
    DaoReservaImpl daores = new DaoReservaImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        String action = "";

        action = request.getParameter("accion").toLowerCase();
//        if(userlogin == null || action.equalsIgnoreCase("")){
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }
        switch (action) {
            case "ingresar":
                try {
                    String usuario = request.getParameter("txtcorreo");
                    String clave = request.getParameter("txtpassword");

                    String rcorreo = val.validarEmail(usuario);
                    String rpassword = val.validarPass(clave);

                    if (rcorreo.equalsIgnoreCase("") && rpassword.equalsIgnoreCase("")) {
                        userlogin = new Usuario();
                        userlogin = dao.usuarioLogin(usuario, clave);
                        if (userlogin.getNombre() != null) {//osea que hay dato en el objeto Usuario
                            if (userlogin.getEstado().equalsIgnoreCase("Bloqueado")) { //validamos estado bloqueado
                                request.setAttribute("bloqueado", "Tu cuenta ha sido bloqueada, por favor comunicate con el administrador");
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                            } else {
                                if (userlogin.getNombrerol().equalsIgnoreCase("Paciente")) {
                                    sesion.setAttribute("user", userlogin);
                                    request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
                                } else {
                                    sesion.setAttribute("user", userlogin);
                                    request.getRequestDispatcher("administrador.jsp").forward(request, response);
                                }
                            }

                        } else {
                            request.setAttribute("noexiste", "El Correo y/o contraseña es Incorrecto");
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }

                    } else {
                        request.setAttribute("msjeEmail", rcorreo);
                        request.setAttribute("msjePass", rpassword);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }

                } catch (Exception e) {//cuando actualice y todo se quiera borrar me llevara donde corresponda
                    if (userlogin.getNombrerol().equalsIgnoreCase("Paciente")) {
                        sesion.setAttribute("user", userlogin);
                        request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
                    } else {
                        sesion.setAttribute("user", userlogin);
                        request.getRequestDispatcher("administrador.jsp").forward(request, response);
                    }

                }

                break;
            case "registrar":
                try {
                    //obtener los datos
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String tipodocumento = request.getParameter("tipodocumento");
                    String dni = request.getParameter("dni");
                    String password = request.getParameter("password");
                    String correo = request.getParameter("correo");
                    String telefono = request.getParameter("telefono");
                    String id_paciente = "CODPA" + dni;
                    //llenamos un objeto Cliente
                    Usuario user = new Usuario();
                    user.setNombre(nombre);
                    user.setApellido(apellido);
                    user.setTipo_documento(tipodocumento);
                    user.setDni(dni);
                    user.setPassword(password);
                    user.setEmail(correo);
                    user.setTelefono(telefono);
                    user.setId_paciente(id_paciente);
                    
                    //Paciente
                    Paciente paciente = new Paciente();
                    paciente.setId_paciente(id_paciente);
                    paciente.setNombre(nombre);
                    paciente.setApe_paterno(apellido);
                    paciente.setDni(dni);
                    paciente.setEmail(correo);
                    paciente.setTelefono(telefono);
                    
                    //VALIDAR
                    String rdni = val.validarDni(dni);
                    String rnombre = val.validarnombre(nombre);
                    String rapellido = val.validarapellido(apellido);
                    String rtipo = val.validarTipo(tipodocumento);
                    String rtelefono = val.validartelefono(telefono);
                    String rcorreo = val.validarEmail(correo);
                    String rpassword = val.validarPass(password);
                    boolean correorep = dao.buscarCorreo(correo);
                    boolean dnirep = dao.buscardni(dni);
                    if (rnombre.equalsIgnoreCase("") && rapellido.equalsIgnoreCase("") && rtipo.equalsIgnoreCase("") && rtelefono.equalsIgnoreCase("") && rcorreo.equalsIgnoreCase("") && rpassword.equalsIgnoreCase("") && correorep && dnirep) {
                        daopa.agregar(paciente);
                        dao.agregarUsuarioRegistro(user);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        request.setAttribute("user", user);
                        request.setAttribute("rnombre", rnombre);
                        request.setAttribute("rapellido", rapellido);
                        request.setAttribute("rtipo", rtipo);
                        request.setAttribute("rdni", rdni);
                        request.setAttribute("rtelefono", rtelefono);
                        request.setAttribute("rcorreo", rcorreo);
                        request.setAttribute("rpass", rpassword);
                        request.setAttribute("correorep", correorep);
                        request.setAttribute("dnirep", dnirep);
                        request.getRequestDispatcher("registro.jsp").forward(request, response);
                    }

                } catch (Exception e) {

                    request.getRequestDispatcher("registro.jsp").forward(request, response);
                }
                break;
            case "salir":
                sesion.invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "verhistorial":
                if (userlogin != null) {
                    ArrayList<Reserva> listaCitas = new ArrayList<>();
                    listaCitas = daores.listarxIdCliente(userlogin.getIdusuario());
                    request.setAttribute("historial", listaCitas);
                    request.getRequestDispatcher("historialCitas.jsp").forward(request, response);
                } 
                break;
            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public String getnumComprobante(String doc) {
        int pedido = ventadao.getIdVenta() + 1;
        String codigocad = null;
        if (doc.equals("Boleta")) {
            codigocad = "B00" + pedido;
        } else {
            codigocad = "F00" + pedido;
        }
        return codigocad;
    }
    //Generar Codigo Paciente

}
