/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

import java.util.ArrayList;

/**
 *
 * @author jorge y javi
 */
public class DAOUsuarios {

    public DAOUsuarios() {
    }

    public boolean autenticar(String nombre, String rol) {
        return Usuarios.getInstance().autenticar(nombre, rol);
    }

    public boolean introducirUsuario(String nombre, String rol) {
        return Usuarios.getInstance().introducirUsuario(nombre, rol);
    }

    public boolean borrarUsuario(String nombre) {
        return Usuarios.getInstance().borrarUsuario(nombre);
    }

    public String getRolUsuario(String nombre) {
        return Usuarios.getInstance().getRolUsuario(nombre);
    }

    public boolean modificarUsuario(String nombre, String rol) {
        boolean result = false;
        if (Usuarios.getInstance().existeUsuario(nombre)) {
            Usuarios.getInstance().introducirUsuario(nombre, rol);
            result = true;
        }
        return result;

    }

    public ArrayList<Usuario> getListaUsuarios() {
        return Usuarios.getInstance().getListaUsuarios();
    }

}
