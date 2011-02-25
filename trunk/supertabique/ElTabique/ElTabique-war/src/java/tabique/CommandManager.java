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
public class CommandManager {

    public static boolean ejecutaComando(String nombreComando, HttpServletRequest request) {
        boolean result = false;
        if (request.getSession().getAttribute("autenticado") != null) {

            CommandFactory factoria = new CommandFactory();
            Command comando = null;

            if (((Rol)request.getSession().getAttribute("rol")).pertenece(TipoUsuario.ADMIN)) {
                comando = factoria.dameComando(TipoUsuario.ADMIN, nombreComando);

            } else if (((Rol)request.getSession().getAttribute("rol")).pertenece(TipoUsuario.USUARIO)) {
                comando = factoria.dameComando(TipoUsuario.USUARIO, nombreComando);
            } else {
                comando = factoria.dameComando(TipoUsuario.INVITADO, nombreComando);
            }
            if (comando != null) {
                result = true;

                try {
                    comando.ejecutar(request);
                } catch (CommandException e) {
                    e.printStackTrace();
                    result = false; 
                }
            }

        }

        return result;

    }
}
