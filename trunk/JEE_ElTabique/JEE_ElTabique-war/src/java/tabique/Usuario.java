/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

/**
 *
 * @author jorge y javi
 */
public class Usuario {

    String nombre;
    String rol;

    public Usuario(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
