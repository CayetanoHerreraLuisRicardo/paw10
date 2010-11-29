/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

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
 * @author usuario_local
 */
@WebServlet(name = "Inicio", urlPatterns = {"/"})
public class Inicio extends HttpServlet {

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
        String atr = (String) request.getSession().getAttribute("autenticado");
        if (atr == null) {
            PrintWriter out = response.getWriter();
            try {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>El Tabique - Inicio de Sesión</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>El Tabiqueeee </h1>");
                out.println("<FORM action=\"/eltabique/autenticacion\" method=\"post\">");
                out.println("<p>");
                out.println("<LABEL for=\"nombre\">Nombre: </LABEL>");
                out.println("<INPUT type=\"text\" name=\"nombre\"><BR>");
                out.println("<br>");

                out.println("<INPUT type=\"radio\" name=\"rol\" value=\"Invitado\"> Invitado<BR>");
                out.println("<INPUT type=\"radio\" name=\"rol\" value=\"Usuario\"> Usuario Registrado<BR>");
                out.println("<INPUT type=\"radio\" name=\"rol\" value=\"Admin\"> Administrador<BR>");
                out.println("<br>");
                out.println("<INPUT type=\"submit\" value=\"Enviar\">");
                out.println("</P>");
                out.println("</FORM>");

                out.println("</body>");
                out.println("</html>");

            } finally {
                out.close();
            }
        } else {
            if (request.getSession().getAttribute("rol").equals("Admin")) {
                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pantallaAdmin.jsp");
                reqDispatcher.forward(request, response);
            } else if (request.getSession().getAttribute("rol").equals("Usuario")) {
                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pantallaUsuarioRegistrado.jsp");
                reqDispatcher.forward(request, response);
            } else {
                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pantallaInvitado.jsp");
                reqDispatcher.forward(request, response);
            }
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
