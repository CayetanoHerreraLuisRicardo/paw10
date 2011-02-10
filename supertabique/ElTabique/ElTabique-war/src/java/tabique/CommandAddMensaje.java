/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
public class CommandAddMensaje extends Command {

    @Override
    public void ejecutar(HttpServletRequest request) throws CommandException {

        if ((request.getSession().getAttribute("C_Usuario") == null) || (request.getSession().getAttribute("C_Mensaje") == null)) {
            throw new CommandException("Parametros no inicializados.");
        } else {
            DAOMensajes mensajes = new DAOMensajes();
            mensajes.nuevoMensaje((String) request.getSession().getAttribute("C_Usuario"), (String) request.getSession().getAttribute("C_Mensaje"));

        }
        request.getSession().removeAttribute("C_Usuario");
        request.getSession().removeAttribute("C_Mensaje");



    }

    @Override
    public boolean permisos(TipoUsuario tipo) {
        return (tipo == TipoUsuario.USUARIO);
    }
}
