/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

/**
 *
 * @author jorge
 */
public class CommandDeleteUser extends Command {

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Boolean ejecutar(String nombre) {
        DAOUsuarios usuarios = new DAOUsuarios();
        return usuarios.borrarUsuario(nombre);
    }

    @Override
    public boolean permisos(TipoUsuario tipo) {
        return (tipo == TipoUsuario.ADMIN);
    }

}
