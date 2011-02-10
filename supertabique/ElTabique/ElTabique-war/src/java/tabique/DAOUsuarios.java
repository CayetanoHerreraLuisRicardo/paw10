/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabique;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import persistencia.Usuario;
import persistencia.UsuarioFacadeRemote;

/**
 *
 * @author jorge y javi
 */
public class DAOUsuarios {
    UsuarioFacadeRemote usuarioFacade = lookupUsuarioFacadeRemote();

    public DAOUsuarios() {
    }

    public synchronized boolean autenticar(String nombre, String rol) {
        //return Usuarios.getInstance().autenticar(nombre, rol);

        boolean result = false;
        Usuario usu = usuarioFacade.find(nombre);

        if (usu != null) {
            if (usu.getRol().equals(rol) || usu.getRol().equals("Admin")) {
                result = true;
                System.out.println("Autenticación correcta.");
            }

        } else {
            System.out.println("El usuario no se encuentra en la base de datos.");
        }

        return result;


    }

    public synchronized boolean introducirUsuario(String nombre, String rol) {
        //return Usuarios.getInstance().introducirUsuario(nombre, rol);
        boolean existe = true;
        Usuario usu = usuarioFacade.find(nombre);
        if(usu == null){
            existe = false;
            usuarioFacade.create(new Usuario(nombre,rol));
        }
        return !existe;
    }

    public synchronized boolean borrarUsuario(String nombre) {
        //return Usuarios.getInstance().borrarUsuario(nombre);
        boolean existe = false;
        Usuario usu = usuarioFacade.find(nombre);
        if(usu != null){
            existe = true;
            usuarioFacade.remove(usu);
        }
        return existe;
    }

    public synchronized String getRolUsuario(String nombre) {
        //return Usuarios.getInstance().getRolUsuario(nombre);
        Usuario usu = usuarioFacade.find(nombre);
        return usu.getRol();
    }

    public synchronized boolean modificarUsuario(String nombre, String rol) {
        

        boolean existe = false;
        Usuario usu = usuarioFacade.find(nombre);
        if(usu != null){
            existe = true;
            usu.setRol(rol);
            usuarioFacade.edit(usu);
        }
        return existe;

    }

    public synchronized List<Usuario> getListaUsuarios() {
        //return Usuarios.getInstance().getListaUsuarios();
        return usuarioFacade.findAll();
    }

    public synchronized boolean existe(String nombre){
        //return Usuarios.getInstance().existeUsuario(nombre);
        boolean existe = false;
        Usuario usu = usuarioFacade.find(nombre);
        if(usu != null){
            existe = true;
        }
        return existe;
    }

    private UsuarioFacadeRemote lookupUsuarioFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (UsuarioFacadeRemote) c.lookup("java:global/ElTabique/ElTabique-ejb/UsuarioFacade!persistencia.UsuarioFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }



}
