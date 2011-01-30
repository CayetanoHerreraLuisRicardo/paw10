<%-- 
    Document   : pantallaInvitado
    Created on : 24-nov-2010, 13:31:02
    Author     : usuario_local
--%>

<%@page import="tabique.InvitadoViewHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <LINK href="css/estilos.css" rel="stylesheet" type="text/css">
        <LINK href="css/estilos2.css" rel="stylesheet" type="text/css">

    </head>
    <body>

        <%@ include file="Header.jsp"%>



        <div id="container">

            <h1>Pantalla de usuario invitado</h1>
            <%
                        String nombre = (String) request.getSession().getAttribute("nombre");

                        out.println(nombre);
                        out.println("Invitado");

                        InvitadoViewHelper helper = new InvitadoViewHelper();

                        String codMensajes = helper.getCodigoHTML();

                        out.println("<p>");
                        out.println(codMensajes);
                        out.println("</p>");
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
