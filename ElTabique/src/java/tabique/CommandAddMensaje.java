/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

/**
 *
 * @author jorge
 */
public class CommandAddMensaje extends Command {

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ejecutar(String usuario, String mensaje) {
        DAOMensajes mensajes = new DAOMensajes();
        mensajes.nuevoMensaje(usuario, mensaje);
    }

    @Override
    public boolean permisos(TipoUsuario tipo) {
        return (tipo == TipoUsuario.USUARIO);
    }

}
