/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author jorge y javi
 */
public class InvitadoViewHelper {
    
    DAOMensajes lista;

    public InvitadoViewHelper() {

        lista = new DAOMensajes();
    }



    public String getCodigoHTML(){
        StringBuffer result = new StringBuffer();
        ArrayList<Mensaje> men = lista.getMensajes();
        Iterator<Mensaje> itr = men.iterator();

        Mensaje mensaje;
        while (itr.hasNext()) {
            mensaje = itr.next();
            result.append("Usuario "+mensaje.getEmisor()+": "+ mensaje.getTexto()+ " [" + mensaje.getFecha()+"] <br>");
        }
    

        return result.toString();
    }

}
