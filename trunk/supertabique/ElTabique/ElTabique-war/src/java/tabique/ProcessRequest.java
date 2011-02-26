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
@WebServlet(name = "ProcessRequest", urlPatterns = {"/ProcessRequest"})
public class ProcessRequest extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        if (request.getParameter("addUser") != null) {
            boolean result = false;

            boolean existente = (new DAOUsuarios()).existe(request.getParameter("nombre"));
            if (!existente) {
                request.getSession().setAttribute("C_Usuario", request.getParameter("nombre"));
                request.getSession().setAttribute("C_Rol", new Rol(TipoUsuario.USUARIO));
                result = CommandManager.ejecutaComando("AddUser", request);
            }
            if (result == true) {
                request.getSession().setAttribute("result", "okAdd");
            } else {
                request.getSession().setAttribute("result", "errorAdd");
            }


        } else if (request.getParameter("deleteUser") != null) {
            boolean result = false;

            request.getSession().setAttribute("C_Usuario", request.getParameter("nombre"));
            result = CommandManager.ejecutaComando("DeleteUser", request);
            if (result == true) {
                request.getSession().setAttribute("result", "okDelete");
            } else {
                request.getSession().setAttribute("result", "errorDelete");
            }


        } else if (request.getParameter("setInvitado") != null) {
            //Nota: entedemos que cambiar a invitado es igual a borrar su rol anterior

            boolean result = false;

            request.getSession().setAttribute("C_Usuario", request.getParameter("user"));
            result = CommandManager.ejecutaComando("DeleteUser", request);

            if (result == true) {
                request.getSession().setAttribute("result", "okModif");
            } else {
                request.getSession().setAttribute("result", "errorModif");
            }



        } else if (request.getParameter("setUsuario") != null) {

            boolean result = false;

            request.getSession().setAttribute("C_Usuario", request.getParameter("user"));
            request.getSession().setAttribute("C_Rol", new Rol(TipoUsuario.USUARIO));
            result = CommandManager.ejecutaComando("ModifyUser", request);

            if (result == true) {
                request.getSession().setAttribute("result", "okModif");
            } else {
                request.getSession().setAttribute("result", "errorModif");
            }



        } else if (request.getParameter("setAdmin") != null) {

            boolean result = false;

            request.getSession().setAttribute("C_Usuario", request.getParameter("user"));
            request.getSession().setAttribute("C_Rol", new Rol(TipoUsuario.ADMIN));
            result = CommandManager.ejecutaComando("ModifyUser", request);

            if (result == true) {
                request.getSession().setAttribute("result", "okModif");
            } else {
                request.getSession().setAttribute("result", "errorModif");
            }


        } else if (request.getParameter("salir") != null) {
            request.getSession().removeAttribute("autenticado");



        } else if (request.getParameter("salir") != null) {
            request.getSession().removeAttribute("autenticado");


        } else if (request.getParameter("enviarMensaje") != null) {

            String nombre = (String) request.getSession().getAttribute("nombre");

            UsuarioRegistradoViewHelper helper = new UsuarioRegistradoViewHelper(request);
            helper.nuevoMensaje(nombre, request.getParameter("mensaje"));


        } else if (request.getParameter("autenticar") != null) {
            DAOUsuarios usuarios = new DAOUsuarios();
            if (!(Rol.fromString(request.getParameter("rol")).equals(TipoUsuario.INVITADO)) && (usuarios.autenticar(request.getParameter("nombre"), new Rol(Rol.fromString(request.getParameter("rol")))))) {

                if (request.getParameter("rol").equals("Admin")) {//administrador
                    request.getSession().setAttribute("autenticado", "true");
                    request.getSession().setAttribute("rol", new Rol(Rol.fromString(request.getParameter("rol"))));
                    request.getSession().setAttribute("nombre", request.getParameter("nombre"));
                } else if (request.getParameter("rol").equals("Usuario")) {//usuario registrado
                    request.getSession().setAttribute("autenticado", "true");
                    request.getSession().setAttribute("rol", new Rol(Rol.fromString(request.getParameter("rol"))));
                    request.getSession().setAttribute("nombre", request.getParameter("nombre"));
                }
            } else {//invitado
                if (request.getParameter("rol").equals("Invitado")) {
                    request.getSession().setAttribute("autenticado", "true");
                    request.getSession().setAttribute("rol", new Rol(Rol.fromString("Invitado")));
                    request.getSession().setAttribute("nombre", request.getParameter("nombre"));
                } else {
                    request.getSession().setAttribute("result", "errorLogin");
                }
            }


        } else if (request.getParameter("cambiarEstilo") != null) {

            if (((String) request.getSession().getAttribute("estilo")).equals("1")) {
                request.getSession().setAttribute("estilo", "2");
            } else {
                request.getSession().setAttribute("estilo", "1");
            }



        } else {
            request.getSession().setAttribute("result", "errorOpDesc");

        }

        //RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/inicio");
        //reqDispatcher.forward(request, response);

        response.sendRedirect("inicio");






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
