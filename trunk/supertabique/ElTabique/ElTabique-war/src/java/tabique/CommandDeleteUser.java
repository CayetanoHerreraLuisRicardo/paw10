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
        boolean result = false;
        if (request.getSession().getAttribute("C_Usuario") == null) {
            throw new CommandException("Parametros no inicializados.");
        } else {
            DAOUsuarios usuarios = new DAOUsuarios();
            result = usuarios.borrarUsuario((String) request.getSession().getAttribute("C_Usuario"));
        }
        request.getSession().removeAttribute("C_Usuario");
        if (!result) {
            throw new CommandException("Usuario no encontrado.");
        }
    }

    @Override
    public boolean permisos(TipoUsuario tipo) {
        return (tipo == TipoUsuario.ADMIN);
    }
}
