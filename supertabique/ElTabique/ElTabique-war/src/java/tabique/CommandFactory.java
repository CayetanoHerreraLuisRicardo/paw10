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

    Hashtable<String, Command> comandos;

    public CommandFactory() {
        comandos = new Hashtable<String, Command>();
        comandos.put("CommandAddMensaje-Usuario", new CommandAddMensaje());
        comandos.put("CommandAddUser-Admin", new CommandAddUser());
        comandos.put("CommandDeleteUser-Admin", new CommandDeleteUser());
        comandos.put("CommandModifyUser-Admin", new CommandModifyUser());


    }

    public Command dameComando(TipoUsuario tipoUsuario, String operacion) {
        String clave = "Command"+operacion + "-" + Rol.toString(tipoUsuario);
        return comandos.get(clave);
    }
}
