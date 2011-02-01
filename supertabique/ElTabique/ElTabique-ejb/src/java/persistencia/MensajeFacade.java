/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jorge
 */
@Stateless
public class MensajeFacade extends AbstractFacade<Mensaje> implements MensajeFacadeLocal, MensajeFacadeRemote {
    @PersistenceContext(unitName = "ElTabique-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }

}
