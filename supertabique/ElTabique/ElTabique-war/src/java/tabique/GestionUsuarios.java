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

        if (request.getParameter("addUser") != null) {
            CommandFactory factoria = new CommandFactory();
            Command comando = factoria.dameComando("Admin", "AddUser");
            if (!((CommandAddUser) comando).existente(request.getParameter("nombre"))) {
                if (((CommandAddUser) comando).ejecutar(request.getParameter("nombre"), "Usuario")) {
                    request.getSession().setAttribute("result", "okAdd");
                }
            } else {
                request.getSession().setAttribute("result", "errorAdd");
            }



        } else if (request.getParameter("deleteUser") != null) {
            CommandFactory factoria = new CommandFactory();
            Command comando = factoria.dameComando("Admin", "DeleteUser");
            if (((CommandDeleteUser) comando).ejecutar(request.getParameter("nombre"))) {
                request.getSession().setAttribute("result", "okDelete");

            } else {
                request.getSession().setAttribute("result", "errorDelete");
            }
        } else if (request.getParameter("setInvitado") != null) {
            //Nota: entedemos que cambiar a invitado es igual a borrar su rol anterior
            CommandFactory factoria = new CommandFactory();
            Command comando = factoria.dameComando("Admin", "ModifyUser");
            if (((CommandModifyUser) comando).borrar(request.getParameter("user"))) {
                request.getSession().setAttribute("result", "okModif");
            } else {
                request.getSession().setAttribute("result", "errorModif");
            }
        } else if (request.getParameter("setUsuario") != null) {
            CommandFactory factoria = new CommandFactory();
            Command comando = factoria.dameComando("Admin", "ModifyUser");
            if (((CommandModifyUser) comando).ejecutar(request.getParameter("user"), "Usuario")) {
                request.getSession().setAttribute("result", "okModif");

            } else {
                request.getSession().setAttribute("result", "errorModif");
            }

        } else if (request.getParameter("setAdmin") != null) {
            CommandFactory factoria = new CommandFactory();
            Command comando = factoria.dameComando("Admin", "ModifyUser");
            if (((CommandModifyUser) comando).ejecutar(request.getParameter("user"), "Admin")) {
                request.getSession().setAttribute("result", "okModif");

            } else {
                request.getSession().setAttribute("result", "errorModif");
            }

        } else {
            request.getSession().setAttribute("result", "errorOpDesc");

        }

        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pantallaAdmin.jsp");
        reqDispatcher.forward(request, response);

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
