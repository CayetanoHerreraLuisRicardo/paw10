/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author jorge
 */
@Remote
public interface MensajeFacadeRemote {

    void create(Mensaje mensajes);

    void edit(Mensaje mensajes);

    void remove(Mensaje mensajes);

    Mensaje find(Object id);

    List<Mensaje> findAll();

    List<Mensaje> findRange(int[] range);

    int count();

}
