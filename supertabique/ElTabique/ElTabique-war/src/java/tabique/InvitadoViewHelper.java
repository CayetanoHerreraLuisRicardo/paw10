/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import persistencia.Mensaje;

/**
 *
 * @author jorge y javi
 */
public class InvitadoViewHelper {
    
    DAOMensajes lista;

    public InvitadoViewHelper() {

        lista = new DAOMensajes();
    }



    public List<Mensaje> getMensajes(){
        return lista.getMensajes();
    }

}
