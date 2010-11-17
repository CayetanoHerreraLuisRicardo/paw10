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
 * @author usuario_local
 */
@WebServlet(name="autenticacion", urlPatterns={"/autenticacion"})
public class autenticacion extends HttpServlet {

    Usuarios usuarios = Usuarios.getInstance();






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

            usuarios.introducirUsuario("Jorgito", "Admin");
            usuarios.introducirUsuario("Javi", "Usuario");
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet autenticacion</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Autenticando usuario " +request.getParameter("nombre") + " como " + request.getParameter("rol") + "</h1>");
            if (usuarios.autenticar(request.getParameter("nombre"), request.getParameter("rol")))
                out.println("<h3>Login correcto. ¡Bienvenido al Tabiqueeee " +request.getParameter("rol") + " "+request.getParameter("nombre") + " !</h3>");
            else
               out.println("<h3>Acceso denegado al Tabiqueeee</h3>");
            out.println("</body>");
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
