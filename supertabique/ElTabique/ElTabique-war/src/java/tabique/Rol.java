/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Rol {

    public TipoUsuario tipo = TipoUsuario.INVITADO;

    public Rol(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        String result = "";
        switch (tipo) {
            case INVITADO:
                result = "Invitado";
                break;
            case USUARIO:
                result = "Usuario";
                break;
            case ADMIN:
                result = "Admin";
                break;
        }
        return result;
    }


    public static String toString(TipoUsuario tipo) {
        String result = "";
        switch (tipo) {
            case INVITADO:
                result = "Invitado";
                break;
            case USUARIO:
                result = "Usuario";
                break;
            case ADMIN:
                result = "Admin";
                break;
        }
        return result;
    }

    public static TipoUsuario fromString(String tipo) {
        TipoUsuario result = TipoUsuario.INVITADO;

        if (tipo.equals("Invitado")) {
            result = TipoUsuario.INVITADO;
        } else if (tipo.equals("Usuario")) {
            result = TipoUsuario.USUARIO;
        } else if (tipo.equals("Admin")) {
            result = TipoUsuario.ADMIN;
        }
        else {
            try {
                throw new Exception("No se puede convertir al tipo de usuario");
            } catch (Exception ex) {
                Logger.getLogger(Rol.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }

        return result;

    }

    public boolean pertenece (TipoUsuario tipo) {
        return (this.tipo == tipo);
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
