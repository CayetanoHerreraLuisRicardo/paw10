/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;
import java.util.List;
import persistencia.Usuario;

/**
 *
 * @author jorge
 */
public class CommandGetUsers extends Command {

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Usuario> getListaUsuarios() {
        DAOUsuarios usuarios = new DAOUsuarios();
        return usuarios.getListaUsuarios();
    }

    @Override
    public boolean permisos(TipoUsuario tipo) {
        return (tipo == TipoUsuario.ADMIN);
    }

}
