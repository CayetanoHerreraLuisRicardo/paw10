/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplo1.operaciones;

import ejemplo1.persistencia.Mensaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario_local
 */
@Local
public interface MensajeFacadeLocal {

    void create(Mensaje mensaje);

    void edit(Mensaje mensaje);

    void remove(Mensaje mensaje);

    Mensaje find(Object id);

    List<Mensaje> findAll();

    List<Mensaje> findRange(int[] range);

    int count();

}
