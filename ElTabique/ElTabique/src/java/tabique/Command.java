/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

/**
 *
 * @author jorge y javi
 */
public abstract class Command {
    public abstract void ejecutar();
    public abstract boolean permisos(TipoUsuario tipo);

}
