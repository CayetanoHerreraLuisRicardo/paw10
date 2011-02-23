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

            if (request.getSession().getAttribute("rol").equals("Admin")) {
                comando = factoria.dameComando("Admin", nombreComando);

            } else if (request.getSession().getAttribute("rol").equals("Usuario")) {
                comando = factoria.dameComando("Usuario", nombreComando);
            } else {
                comando = factoria.dameComando("Invitado", nombreComando);
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
