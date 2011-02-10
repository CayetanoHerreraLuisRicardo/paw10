/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge y javi
 */
public abstract class Command {
    public abstract void ejecutar(HttpServletRequest request) throws CommandException;
    public abstract boolean permisos(TipoUsuario tipo);

}
