/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.Hashtable;

/**
 *
 * @author jorge y javi
 */
public class CommandFactory {
    Hashtable<String,Command> comandos;

    public CommandFactory() {
        comandos = new Hashtable<String,Command>();
        comandos.put("muestrapantalla-Admin", new CommandMuestrapantallaAdmin());
        comandos.put("muestrapantalla-Usuario", new CommandMuestrapantallaUsuarioRegistrado());
        comandos.put("muestrapantalla-Invitado", new CommandMuestrapantallaInvitado());

    }

    public Command dameComando(String tipoUsuario, String operacion) {
        String clave = tipoUsuario + "-" + operacion;
        return comandos.get(clave);
    }



}
