/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import persistencia.Usuario;

/**
 *
 * @author usuario_local
 */
public class AdminViewHelper {

    DAOUsuarios lista;

    public AdminViewHelper() {
        lista = new DAOUsuarios();
    }

    public List<Usuario> getUsers() {
        StringBuffer result = new StringBuffer();

        CommandFactory factoria = new CommandFactory();
        Command comando = factoria.dameComando("Admin", "GetUsers");
        List<Usuario> us = ((CommandGetUsers) comando).getListaUsuarios();

        
        


        return us;
    }

    public boolean nuevoUsuario(String usuario, String rol) {

        CommandFactory factoria = new CommandFactory();
        Command comando = factoria.dameComando("Usuario", "AddUser");
        return ((CommandAddUser) comando).ejecutar(usuario, rol);


    }


}
