/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class CommandGetUsers extends Command {

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Usuario> getListaUsuarios() {
        DAOUsuarios usuarios = new DAOUsuarios();
        return usuarios.getListaUsuarios();
    }

    @Override
    public boolean permisos(TipoUsuario tipo) {
        return (tipo == TipoUsuario.ADMIN);
    }

}
