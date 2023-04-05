/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.servlet;

import dao.impl.DaoEspecialidadImpl;
import dao.impl.DaoMedicoImpl;
import dao.impl.DaoReservaImpl;
import dto.Especialidad;
import dto.Medico;
import dto.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ProcesarServlet extends HttpServlet {

    DaoEspecialidadImpl daoEspe = new DaoEspecialidadImpl();
    DaoReservaImpl daore = new DaoReservaImpl();
    DaoMedicoImpl daomed = new DaoMedicoImpl();
    Especialidad ob = null;
    Reserva re = null;
    Medico me = null;
    ArrayList<Reserva> lista = null;
    ArrayList<Medico> listaMedico = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = "";

        action = request.getParameter("accion").toLowerCase();
        action = (action == null) ? "" : action;
        switch (action) {
            case "procesar":
                infomodal(request, response);

                break;
            case "reservar":

                try {
                    //recuperamos los datos que vienen del AJAX
                    String fecha = request.getParameter("fecha");
                    System.out.println("fecha: " + fecha);
                    String hora = request.getParameter("hora");
                    System.out.println("hora: " + hora);
                    String id_usuario = request.getParameter("id_usuario");
                    System.out.println("id de usuario: " + id_usuario);
                    String id_medico = request.getParameter("id_medico");
                    System.out.println("id de medico: " + id_medico);
                    String id_especialidad = request.getParameter("id_especialidad");
                    System.out.println("id de especialidad: " + id_especialidad);
                    Double precio = Double.parseDouble(request.getParameter("precio"));
                    System.out.println("precio: " + precio);
                    String id_paciente = request.getParameter("id_paciente");
                    System.out.println("id_paciente: " + id_paciente);
                    //lo metemos en un objeto
                    Reserva re = new Reserva();
                    re.setFecha(fecha);
                    re.setHora(hora);
                    re.setId_medico(id_medico);
                    re.setId_especialidad(id_especialidad);
                    re.setId_usuario(id_usuario);
                    re.setPrecio(precio);
                    re.setId_paciente(id_paciente);
                    boolean r = daore.agregar(re);
                    System.out.println("resultado:" + r);

                    //
                    DaoReservaImpl dao = new DaoReservaImpl();
                    lista = new ArrayList<>();
                    lista = dao.listarxIdCliente(Integer.parseInt(id_usuario));
                    request.setAttribute("historial", lista);
                    request.getRequestDispatcher("historialCitas.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("No se agrego en la tabla reserva");
                }

                break;
            case "vermedico":
                try {
                    verMedico(request, response);
                } catch (Exception e) {
                }
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

    private void infomodal(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            String especialidad = request.getParameter("especialidad");
            System.out.println("especialidad: " + especialidad);
            ob = daoEspe.medicoEspecialidadConsultorio(especialidad);
            JSONObject jsonesp = new JSONObject();
            request.setAttribute("obespecialidad", ob);
            jsonesp.put("codigo_medico", ob.getCodigo_medico());
            jsonesp.put("id_especialidad", ob.getId_especialidad());
            jsonesp.put("precio", ob.getPrecio());
            jsonesp.put("nombre_medico", ob.getNombres_medico());
            jsonesp.put("apepat_medico", ob.getApellido_paterno_medico());
            jsonesp.put("apemat_medico", ob.getApellido_materno_medico());
            jsonesp.put("consultorio", ob.getNombre_consultorio());
            pw.print(jsonesp);
//            http://localhost:8080/CitaMedica/ProcesarServlet?accion=procesar&especialidad=cred
        } catch (Exception e) {

        }
    }

    private void verMedico(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            //obtener especialidad
            String especialidad = request.getParameter("especialidad");
            System.out.println("especialidad: " + especialidad);
            //obtener lista
            listaMedico = daomed.listarPorEspecialidad(especialidad);
            //Creamos objeto json
            JSONArray jsonArray = new JSONArray();
            
            for (int i = 0; i < listaMedico.size(); i++) {
                JSONObject jsonmed = new JSONObject();
                request.setAttribute("obespecialidad", ob);
                jsonmed.put("id_medico", listaMedico.get(i).getId_medico());
                jsonmed.put("nombres_medico", listaMedico.get(i).getNombres_medico());
                jsonmed.put("apellido_paterno_medico", listaMedico.get(i).getApellido_paterno_medico());
                jsonmed.put("apellido_materno_medico", listaMedico.get(i).getApellido_materno_medico());
                jsonArray.add(jsonmed);
            }
            pw.print(jsonArray);
//            http://localhost:8080/CitaMedica/ProcesarServlet?accion=verMedico&especialidad=CIRUGIA%20GENERAL
        } catch (Exception e) {

        }
    }

}
