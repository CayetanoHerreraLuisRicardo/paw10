/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplo1.operaciones;

import ejemplo1.persistencia.Mensaje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author usuario_local
 */
@Stateless
public class MensajeFacade extends AbstractFacade<Mensaje> implements MensajeFacadeLocal, MensajeFacadeRemote {
    @PersistenceContext(unitName = "ejemplo1-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }

}
