<%-- 
    Document   : pantallaAdmin
    Created on : 23-nov-2010, 13:37:26
    Author     : usuario_local
--%>

<%@page import="java.util.Iterator"%>
<%@page import="tabique.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="tabique.Usuarios"%>
<%@page import="tabique.AdminViewHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <LINK href="css/estilos.css" rel="stylesheet" type="text/css">

    </head>
    <body>


        <%@ include file="Header.jsp"%>



        <div id="container">

            <h1>Pantalla de administrador</h1>


            <%
                        String rol = (String) request.getSession().getAttribute("rol");
                        String nombre = (String) request.getSession().getAttribute("nombre");


            %>

            <FORM action="GestionUsuarios" method="post">
                <p>
                    <LABEL for="nombre">Nuevo Usuario: </LABEL>
                    <INPUT type="text" name="nombre">
                    <INPUT type="submit" name="addUser"value="Crear">
                </p>
            </FORM>


            <FORM action="GestionUsuarios" method="post">
                <p>
                    <LABEL for="nombre">Borrar Usuario: </LABEL>
                    <INPUT type="text" name="nombre">
                    <INPUT type="submit" name="deleteUser"value="Borrar">
                </p>
            </FORM>


            <%

                        AdminViewHelper helper = new AdminViewHelper();

                        ArrayList<Usuario> us = helper.getUsers();

                        out.println("<p>");
                        Iterator<Usuario> itr = us.iterator();

                        Usuario usuario;
                        while (itr.hasNext()) {
                            usuario = itr.next();
                            out.println("<p>");
                            out.println(usuario.getNombre() + ". Es " + usuario.getRol() + ". Convertir en: <br>");
                            out.println("<FORM action=\"GestionUsuarios?user=" + usuario.getNombre() + "\" method=\"post\">");
                            out.println("<INPUT type=\"submit\" name=\"setInvitado\" value=\"Invitado\">");
                            out.println("<INPUT type=\"submit\" name=\"setUsuario\" value=\"Usuario\">");
                            out.println("<INPUT type=\"submit\" name=\"setAdmin\" value=\"Admin\">");
                            out.println("</FORM>");
                            out.println("</p>");
                        }
                        out.println("</p>");

                        //out.println(nombre);
                        //out.println(rol);
                        //String info = AdminViewHelper.dameInfo(nom);

                        //Usuarios usuarios=AdminViewHelper.dameUsuarios(request);
                        //out.println("Bienvenido a su Tabique:"+usuarios.getRolUsuario("Jorgito"));

            %>

            <form action="Salir" method="post">
                <p>
                    <INPUT type="submit" value="Salir">
                </p>
            </form>


        </div>


        <%@ include file="Footer.jsp"%>

    </body>
</html>
