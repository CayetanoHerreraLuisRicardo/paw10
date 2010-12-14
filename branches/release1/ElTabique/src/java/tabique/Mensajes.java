/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

import java.util.ArrayList;
import java.util.Date;

public class Mensajes {

    private static Mensajes INSTANCE = null;
    private static String monitor = "Monitor";
    private ArrayList<Mensaje> listaMensajes;

    private Mensajes() {
        this.listaMensajes = new ArrayList<Mensaje>();
    }

    public static Mensajes getInstance() {
        synchronized (monitor) {
            if (INSTANCE == null) {
                INSTANCE = new Mensajes();
            }
        }
        return INSTANCE;
    }

    public void nuevoMensaje(String usuario, String mensaje) {
        Mensaje m = new Mensaje(usuario, mensaje);
        listaMensajes.add(m);

    }

    public ArrayList<Mensaje> getMensajes() {
        return listaMensajes;
    }
}
