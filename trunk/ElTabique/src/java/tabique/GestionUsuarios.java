/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "GestionUsuarios", urlPatterns = {"/GestionUsuarios"})
public class GestionUsuarios extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionUsuarios</title>");

            if (request.getParameter("addUser") != null) {
                CommandFactory factoria = new CommandFactory();
                Command comando = factoria.dameComando("Admin", "AddUser");
                if (((CommandAddUser) comando).ejecutar(request.getParameter("nombre"), "Usuario")) {
                    out.println("<meta HTTP-EQUIV=\"REFRESH\" content=\"3; url=http://localhost:8080/eltabique/\">");
                    out.println("<font color=#00FF00>Usuario creado</font>");

                } else {
                    out.println("<font color=#E42217>Usuario ya existente</font>");
                }
                out.println("</head>");



            } else if (request.getParameter("deleteUser") != null) {
                CommandFactory factoria = new CommandFactory();
                Command comando = factoria.dameComando("Admin", "DeleteUser");
                if (((CommandDeleteUser) comando).ejecutar(request.getParameter("nombre"))) {

                    out.println("<meta HTTP-EQUIV=\"REFRESH\" content=\"3; url=http://localhost:8080/eltabique/\">");
                    out.println("<font color=#00FF00>Usuario borrado</font>");

                } else {
                    out.println("<font color=#E42217>Usuario no existente</font>");
                }
                out.println("</head>");
            } else if (request.getParameter("setUsuario") != null) {
                CommandFactory factoria = new CommandFactory();
                Command comando = factoria.dameComando("Admin", "ModifyUser");
                if (((CommandModifyUser) comando).ejecutar(request.getParameter("user"), "Usuario")) {
                    out.println("<meta HTTP-EQUIV=\"REFRESH\" content=\"3; url=http://localhost:8080/eltabique/\">");
                    out.println("<font color=#00FF00>Usuario modificado</font>");

                } else {
                    out.println("<font color=#E42217>Usuario no existente</font>");
                }
                out.println("</head>");

            } else if (request.getParameter("setAdmin") != null) {
                CommandFactory factoria = new CommandFactory();
                Command comando = factoria.dameComando("Admin", "ModifyUser");
                if (((CommandModifyUser) comando).ejecutar(request.getParameter("user"), "Admin")) {
                    out.println("<meta HTTP-EQUIV=\"REFRESH\" content=\"3; url=http://localhost:8080/eltabique/\">");
                    out.println("<font color=#00FF00>Usuario modificado</font>");

                } else {
                    out.println("<font color=#E42217>Usuario ya existente</font>");
                }
                out.println("</head>");

            } else {
                out.println("</head>");
                out.println("<font color=#E42217>Error: Operación desconocida.</font>");

            }


            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
