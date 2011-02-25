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
@WebServlet(name = "autenticacion", urlPatterns = {"/autenticacion"})
public class autenticacion extends HttpServlet {

    
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

            DAOUsuarios usuarios = new DAOUsuarios();
            //usuarios.introducirUsuario("Jorgito", "Admin");
            //usuarios.introducirUsuario("Javi", "Usuario");

            /**
             * @TODO: deberiamos dejar los menos out.println posibles según el profe.
             */
            /*
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet autenticacion</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Autenticando usuario " +request.getParameter("nombre") + " como " + request.getParameter("rol") + "</h1>");
             */


            if (!(Rol.fromString(request.getParameter("rol")).equals(TipoUsuario.INVITADO)) && (usuarios.autenticar(request.getParameter("nombre"), new Rol(Rol.fromString(request.getParameter("rol")))))) {
                /**
                 * 1)Para cada petición entrante
                1)Verificar que está autenticada
                si no está autenticada, crear un atributo de sesión y asignarle un
                nombre arbitrario para esto. Si está a true, es que está autenticad
                2)Determinar la operación que nos piden y el tipo de usuario (parámetros de invocación)

                 */
                //out.println("<h3>Login correcto. ¡Bienvenido al Tabiqueeee " +request.getParameter("rol") + " "+request.getParameter("nombre") + " !</h3>");
                //reenvio al jsp que le corresponda según el tipo de usuario
                if (request.getParameter("rol").equals("Admin")) {//administrador
                    request.getSession().setAttribute("autenticado", "true");
                    request.getSession().setAttribute("rol", new Rol(Rol.fromString(request.getParameter("rol"))));
                    request.getSession().setAttribute("nombre", request.getParameter("nombre"));
                    RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/inicio");
                    reqDispatcher.forward(request, response);
                } else if (request.getParameter("rol").equals("Usuario")) {//usuario registrado
                    request.getSession().setAttribute("autenticado", "true");
                    request.getSession().setAttribute("rol", new Rol(Rol.fromString(request.getParameter("rol"))));
                    request.getSession().setAttribute("nombre", request.getParameter("nombre"));
                    //RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/pantallaUsuarioRegistrado.jsp");
                    //reqDispatcher.forward(request,response);
                    RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/inicio");
                    reqDispatcher.forward(request, response);
                }
            } else {//invitado
                if (request.getParameter("rol").equals("Invitado")) {
                    request.getSession().setAttribute("autenticado", "true");
                    request.getSession().setAttribute("rol", new Rol(Rol.fromString("Invitado")));
                    request.getSession().setAttribute("nombre", request.getParameter("nombre"));
                    RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/inicio");
                    reqDispatcher.forward(request, response);
                } else {
                    request.getSession().setAttribute("result", "errorLogin");
                    RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/inicio");
                    reqDispatcher.forward(request, response);
                }
            }


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
