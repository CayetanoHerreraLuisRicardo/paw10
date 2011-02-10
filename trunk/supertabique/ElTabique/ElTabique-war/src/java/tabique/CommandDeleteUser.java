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
public class CommandDeleteUser extends Command {

    @Override
    public void ejecutar(HttpServletRequest request) throws CommandException {
        if (request.getSession().getAttribute("C_Usuario") == null) {
            throw new CommandException("Parametros no inicializados.");
        } else {
            DAOUsuarios usuarios = new DAOUsuarios();
            usuarios.borrarUsuario((String) request.getSession().getAttribute("C_Usuario"));
        }
        request.getSession().removeAttribute("C_Usuario");
    }

    @Override
    public boolean permisos(TipoUsuario tipo) {
        return (tipo == TipoUsuario.ADMIN);
    }
}
