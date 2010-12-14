/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplo1.operaciones;

import javax.ejb.Stateless;

/**
 *
 * @author usuario_local
 */
@Stateless
public class NewSessionBean implements NewSessionBeanRemote, NewSessionBeanLocal {

    public String devolverMensaje() {
        return "Hola otra vez";
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
