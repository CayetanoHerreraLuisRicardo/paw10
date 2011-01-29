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
        <LINK href="css/estilos.css" rel="stylesheet" type="text/css">

    </head>
    <body>


        <%@ include file="Header.jsp"%>



        <div id="container">

            <h1>Pantalla de usuario registrado</h1>

            <form action="/eltabique/EnviarMensaje" method="post">
                <p>
                    <LABEL for="mensaje">Mensaje: </LABEL>
                    <BR>
                    <TEXTAREA name="mensaje" COLS="40" ROWS="2"></TEXTAREA>
                    <BR>
                    <INPUT type="submit" value="Enviar">
                </p>
            </form>

            <%
                        String rol = (String) request.getSession().getAttribute("rol");
                        String nombre = (String) request.getSession().getAttribute("nombre");

                        //out.println(nombre);
                        //out.println(rol);


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


        </div>


        <%@ include file="Footer.jsp"%>

    </body>
</html>
