<%-- 
    Document   : pantallaUsuarioRegistrado
    Created on : 24-nov-2010, 13:35:18
    Author     : usuario_local
--%>

<%@page import="tabique.UsuarioRegistradoViewHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pantalla de usuario registrado</h1>
        <%
                    String rol = (String) request.getSession().getAttribute("rol");
                    String nombre = (String) request.getSession().getAttribute("nombre");

                    out.println(nombre);
                    out.println(rol);


                    UsuarioRegistradoViewHelper helper = new UsuarioRegistradoViewHelper();

                    String codMensajes = helper.getCodigoHTML();

                    out.println("<p>");
                    out.println(codMensajes);
                    out.println("</p>");
        %>


        <form action="/eltabique/Salir" method="post">
            <p>
                <INPUT type="submit" value="Salir">
            </p>
        </form>

    </body>
</html>
