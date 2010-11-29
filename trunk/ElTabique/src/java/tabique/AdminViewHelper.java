/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author usuario_local
 */
public class AdminViewHelper {

    DAOUsuarios lista;

    public AdminViewHelper() {
        lista = new DAOUsuarios();
    }

    public String getCodigoHTML() {
        StringBuffer result = new StringBuffer();

        CommandFactory factoria = new CommandFactory();
        Command comando = factoria.dameComando("Admin", "GetUsers");
        ArrayList<Usuario> us = ((CommandGetUsers) comando).getListaUsuarios();

        
        Iterator<Usuario> itr = us.iterator();

        Usuario usuario;
        while (itr.hasNext()) {
            usuario = itr.next();
            result.append("<p>");
            result.append(usuario.nombre + ". Es " + usuario.rol + ". Convertir en: <br>");
            result.append("<FORM action=\"/eltabique/GestionUsuarios\" method=\"post\">");
            result.append("<INPUT type=\"submit\" name=\"setUsuario\" value=\"Usuario\">");
            result.append("<INPUT type=\"submit\" name=\"setAdmin\" value=\"Admin\">");
            result.append("</FORM>");
            result.append("</p>");
        }


        return result.toString();
    }

    public boolean nuevoUsuario(String usuario, String rol) {

        CommandFactory factoria = new CommandFactory();
        Command comando = factoria.dameComando("Usuario", "AddUser");
        return ((CommandAddUser) comando).ejecutar(usuario, rol);


    }


}
