/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author usuario_local
 */
public class AdminViewHelper {

    DAOUsuarios lista;

    public AdminViewHelper() {
        lista = new DAOUsuarios();
    }

    public ArrayList<Usuario> getUsers() {
        StringBuffer result = new StringBuffer();

        CommandFactory factoria = new CommandFactory();
        Command comando = factoria.dameComando("Admin", "GetUsers");
        ArrayList<Usuario> us = ((CommandGetUsers) comando).getListaUsuarios();

        
        


        return us;
    }

    public boolean nuevoUsuario(String usuario, String rol) {

        CommandFactory factoria = new CommandFactory();
        Command comando = factoria.dameComando("Usuario", "AddUser");
        return ((CommandAddUser) comando).ejecutar(usuario, rol);


    }


}
