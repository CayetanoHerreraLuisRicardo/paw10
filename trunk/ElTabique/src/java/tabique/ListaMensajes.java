/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jorge
 */
public class ListaMensajes {
    private ArrayList<Mensaje> listaMensajes;

    public ListaMensajes() {
        this.listaMensajes = new ArrayList<Mensaje>();
    }


    public void nuevoMensaje(String usuario,String mensaje){
        Mensaje m = new Mensaje(usuario,mensaje);
        listaMensajes.add(m);

    }


    public ArrayList<Mensaje> getMensajes(){
        return listaMensajes;
    }

}
