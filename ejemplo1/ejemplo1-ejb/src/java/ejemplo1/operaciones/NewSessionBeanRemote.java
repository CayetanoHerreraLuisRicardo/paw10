/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplo1.operaciones;

import javax.ejb.Remote;

/**
 *
 * @author usuario_local
 */
@Remote
public interface NewSessionBeanRemote {

    String devolverMensaje();
    
}
