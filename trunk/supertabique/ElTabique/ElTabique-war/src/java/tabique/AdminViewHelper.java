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
    HttpServletRequest request = null;

    public AdminViewHelper(HttpServletRequest request) {
        lista = new DAOUsuarios();
        this.request = request;
    }

    public List<Usuario> getUsers() {

        DAOUsuarios usuarios = new DAOUsuarios();
        return usuarios.getListaUsuarios();

    }

    public boolean nuevoUsuario(String usuario, Rol rol) {

        request.getSession().setAttribute("C_Usuario", usuario);
        request.getSession().setAttribute("C_Rol", rol);
        return CommandManager.ejecutaComando("AddUser", request);


    }
}
