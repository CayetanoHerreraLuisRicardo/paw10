/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import persistencia.Mensaje;

/**
 *
 * @author jorge y javi
 */
public class UsuarioRegistradoViewHelper {

    DAOMensajes lista;

    public UsuarioRegistradoViewHelper() {
        lista = new DAOMensajes();
    }

    public String getCodigoHTML() {
        StringBuffer result = new StringBuffer();
        //TODO:implementar con un comando
        List<Mensaje> men = lista.getMensajes();
        Iterator<Mensaje> itr = men.iterator();

        Mensaje mensaje;
        while (itr.hasNext()) {
            mensaje = itr.next();
            result.append("Usuario " + mensaje.getEmisor() + ": " + mensaje.getTexto() + " [" + mensaje.getFecha() + "] <br>");
        }


        return result.toString();
    }

    public void nuevoMensaje(String usuario, String rol, String mensaje) {

        CommandFactory factoria = new CommandFactory();
        Command comando = factoria.dameComando("Usuario", "AddMensaje");
        ((CommandAddMensaje) comando).ejecutar(usuario, mensaje);


    }
}