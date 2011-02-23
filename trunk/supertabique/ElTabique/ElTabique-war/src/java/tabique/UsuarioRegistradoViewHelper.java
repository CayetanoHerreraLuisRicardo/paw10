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
import javax.servlet.http.HttpServletRequest;
import persistencia.Mensaje;

/**
 *
 * @author jorge y javi
 */
public class UsuarioRegistradoViewHelper {

    DAOMensajes lista;
    HttpServletRequest request = null;

    public UsuarioRegistradoViewHelper(HttpServletRequest request) {
        lista = new DAOMensajes();
        this.request = request;
    }

    public List<Mensaje> getMensajes() {
  
        return lista.getMensajes();
    }

    public void nuevoMensaje(String usuario, String mensaje) {

        request.getSession().setAttribute("C_Usuario", usuario);
        request.getSession().setAttribute("C_Mensaje", mensaje);
        CommandManager.ejecutaComando("AddMensaje", request);

    }
}
