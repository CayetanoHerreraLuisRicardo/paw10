/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

import java.util.Hashtable;

/**
 *
 * @author usuario_local
 */
public class Usuarios {

    Hashtable<String, String> tablaUsu = new Hashtable<String, String>();
    private static Usuarios INSTANCE = null;
    private static String monitor = "Monitor";

    // El constructor privado no permite que se genere un constructor por defecto
    // (con mismo modificador de acceso que la definicion de la clase)
    private Usuarios() {
    }

    public static Usuarios getInstance() {
        synchronized (monitor) {
            if (INSTANCE == null) {
                INSTANCE = new Usuarios();
            }
        }
        return INSTANCE;
    }

    public boolean autenticar(String nombre, String rol) {
        boolean result = false;

        if (tablaUsu.containsKey(nombre)) {
            if (tablaUsu.get(nombre).equals(rol) || tablaUsu.get(nombre).equals("Admin")) {
                result = true;
                System.out.println("Autenticación correcta.");
            }

        } else {
            System.out.println("El usuario no se encuentra en la base de datos.");
        }

        return result;
    }

    public boolean introducirUsuario(String nombre, String rol) {
        boolean result = false;

        if (!tablaUsu.containsKey(nombre)) {
            tablaUsu.put(nombre, rol);
            System.out.println("Usuario introducido en la base de datos.");
            result = true;
        } else {
            tablaUsu.put(nombre, rol);
            System.out.println("Cambiado el rol del usuario.");
            result = true;
        }
        return result;
    }

    public boolean borrarUsuario(String nombre) {
        boolean result = false;

        if (tablaUsu.containsKey(nombre)) {
            tablaUsu.remove(nombre);
            System.out.println("Usuario borrado.");
            result = true;
        } else {
            System.out.println("El usuario no existe.");
        }

        return result;
    }

    public String getRolUsuario(String nombre) {
        if (tablaUsu.containsKey(nombre)) {
            return tablaUsu.get(nombre);
        } else {
            return "";
        }
    }

    public boolean existeUsuario(String nombre) {
        return tablaUsu.containsKey(nombre);
    }
}
