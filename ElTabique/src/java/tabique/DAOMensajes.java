/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jorge y javi
 */
public class DAOMensajes {

    public DAOMensajes() {
        
    }


    public void nuevoMensaje(String usuario,String mensaje){
        Mensajes.getInstance().nuevoMensaje(usuario, mensaje);

    }


    public ArrayList<Mensaje> getMensajes(){
        return Mensajes.getInstance().getMensajes();
    }

}
