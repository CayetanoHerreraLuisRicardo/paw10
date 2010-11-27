/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabique;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author usuario_local
 */
public class AdminViewHelper {
    private static Usuarios usuarios;

    public static Usuarios dameUsuarios(HttpServletRequest request){
        //usuarios = getInstance();
        return usuarios;
    }


}
