package web.servlet;

import dao.impl.DaoEspecialidadImpl;
import dao.impl.DaoUsuarioImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author srf
 */
@WebServlet(name = "controladorAd", urlPatterns = {"/controladorAd"})
public class controladorAd extends HttpServlet {

    
    DaoUsuarioImpl usuarioDAO;
    DaoEspecialidadImpl especialidadDAO;
        
    public controladorAd() {
        super();
        usuarioDAO = new DaoUsuarioImpl(); 
        especialidadDAO = new DaoEspecialidadImpl();
    }
        
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getParameter("action");
        String ruta = "";
        
         switch (action) {
             case "listarUsuarios":
               // ruta = "usuarioPanelDerecho.jsp";
                try {
                    request.setAttribute("usuarioList", usuarioDAO.listar());
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                                      
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                
             case "listarEspecialidades":
               // ruta = "usuarioPanelDerecho.jsp";
                try {
                    request.setAttribute("especialidadesList", especialidadDAO.listar());
                    request.getRequestDispatcher("especialidad.jsp").forward(request, response);
                                      
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                
                default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
         }
        
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

}
