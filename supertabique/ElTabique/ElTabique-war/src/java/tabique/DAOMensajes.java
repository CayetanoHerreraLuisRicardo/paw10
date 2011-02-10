/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import persistencia.Mensaje;

import persistencia.MensajeFacade;
import persistencia.MensajeFacadeRemote;
/**
 *
 * @author jorge y javi
 */
public class DAOMensajes {
    MensajeFacadeRemote mensajeFacade = lookupMensajeFacadeRemote();
    
    public DAOMensajes() {


    }


    public synchronized void nuevoMensaje(String usuario,String mensaje){
        //Mensajes.getInstance().nuevoMensaje(usuario, mensaje);
        mensajeFacade.create(new Mensaje(usuario,mensaje));
    }


    public synchronized List<Mensaje> getMensajes(){
        //return Mensajes.getInstance().getMensajes();

        return mensajeFacade.findAll();


    }

    private MensajeFacadeRemote lookupMensajeFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (MensajeFacadeRemote) c.lookup("java:global/ElTabique/ElTabique-ejb/MensajeFacade!persistencia.MensajeFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
