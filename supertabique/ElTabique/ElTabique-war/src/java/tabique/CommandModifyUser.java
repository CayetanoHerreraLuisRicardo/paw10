/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jorge
 */
public class CommandModifyUser extends Command {

    @Override
    public void ejecutar(HttpServletRequest request) throws CommandException {
        if ((request.getSession().getAttribute("C_Usuario") == null) || (request.getSession().getAttribute("C_Rol") == null)) {
            throw new CommandException("Parametros no inicializados.");
        } else {
            DAOUsuarios usuarios = new DAOUsuarios();
            usuarios.modificarUsuario(((String) request.getSession().getAttribute("C_Usuario")).toLowerCase(), (String) request.getSession().getAttribute("C_Rol"));
        }
        request.getSession().removeAttribute("C_Usuario");
        request.getSession().removeAttribute("C_Rol");
    }

    @Override
    public boolean permisos(TipoUsuario tipo) {
        return (tipo == TipoUsuario.ADMIN);
    }
}
