/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

/**
 *
 * @author jorge
 */
public class CommandModifyUser extends Command {

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean ejecutar(String nombre, String rol) {
        DAOUsuarios usuarios = new DAOUsuarios();
        return usuarios.modificarUsuario(nombre, rol);
    }

    public boolean borrar(String nombre){
        DAOUsuarios usuarios = new DAOUsuarios();
        return usuarios.borrarUsuario(nombre);
    }

    @Override
    public boolean permisos(TipoUsuario tipo) {
        return (tipo == TipoUsuario.ADMIN);
    }

}
