<%-- 
    Document   : pantallaAdmin
    Created on : 23-nov-2010, 13:37:26
    Author     : usuario_local
--%>

<%@page import="persistencia.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="tabique.AdminViewHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <LINK href="css/estilos.css" rel="stylesheet" type="text/css">

        <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.qtip-1.0.0-rc3.min.js"></script>
        <script type="text/javascript" src="js/notificaciones.js"></script>

    </head>
    <body>


        <%@ include file="Header.jsp"%>



        <div id="container">

            <h1>Pantalla de administrador</h1>



            <%
                        String rol = (String) request.getSession().getAttribute("rol");
                        String nombre = (String) request.getSession().getAttribute("nombre");


            %>

            <FORM action="GestionUsuarios" method="post" id="formAdd">
                <p>
                    <LABEL for="nombre">Nuevo Usuario: </LABEL>
                    <INPUT type="text" name="nombre">
                    <INPUT type="submit" name="addUser"value="Crear">
                </p>
            </FORM>


                        
            <%

                        if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("errorAdd")) {
                            request.getSession().removeAttribute("result");

                            out.println(" <script type=\"text/javascript\">");
                            out.println("mensajeError($(\"#formAdd\"), \"Usuario ya existente.\");");
                            out.println("</script>");

                        } else if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("okAdd")) {
                            request.getSession().removeAttribute("result");

                            out.println(" <script type=\"text/javascript\">");
                            out.println("mostrarNotificacion($(\"#formAdd\"), \"Usuario creado correctamente.\");");
                            out.println("</script>");

                        }

            %>


            <FORM action="GestionUsuarios" method="post">
                <p>
                    <LABEL for="nombre">Borrar Usuario: </LABEL>
                    <INPUT type="text" name="nombre">
                    <INPUT type="submit" name="deleteUser"value="Borrar">
                </p>
            </FORM>


            <%

                        if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("errorDelete")) {
                            request.getSession().removeAttribute("result");

                            out.println(" <script type=\"text/javascript\">");
                            out.println("mensajeError($(\"#formAdd\"), \"Usuario no existente.\");");
                            out.println("</script>");

                        } else if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("okDelete")) {
                            request.getSession().removeAttribute("result");

                            out.println(" <script type=\"text/javascript\">");
                            out.println("mostrarNotificacion($(\"#formAdd\"), \"Usuario borrado correctamente.\");");
                            out.println("</script>");

                        }

            %>



            <%

                        AdminViewHelper helper = new AdminViewHelper(request);

                        List<Usuario> us = helper.getUsers();

                        out.println("<p>");
                        Iterator<Usuario> itr = us.iterator();

                        Usuario usuario;
                        while (itr.hasNext()) {
                            usuario = itr.next();
                            out.println("<p>");
                            out.println("<strong class=\"usuario\">"+usuario.getId() +"</strong>"+ "<strong class=\"tipoUsuario\">  [" + usuario.getRol() + "] </strong> Convertir en: <br>");
                            out.println("<FORM action=\"GestionUsuarios?user=" + usuario.getId() + "\" method=\"post\">");
                            out.println("<INPUT type=\"submit\" name=\"setInvitado\" value=\"Invitado\">");
                            out.println("<INPUT type=\"submit\" name=\"setUsuario\" value=\"Usuario\">");
                            out.println("<INPUT type=\"submit\" name=\"setAdmin\" value=\"Admin\">");
                            out.println("</FORM>");
                            out.println("</p>");
                        }
                        out.println("</p>");

                     

            %>



            <%
                        if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("errorModif")) {
                            request.getSession().removeAttribute("result");

                            out.println(" <script type=\"text/javascript\">");
                            out.println("mensajeError($(\"#formAdd\"), \"Usuario no existente.\");");
                            out.println("</script>");

                        } else if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("okModif")) {
                            request.getSession().removeAttribute("result");

                            out.println(" <script type=\"text/javascript\">");
                            out.println("mostrarNotificacion($(\"#formAdd\"), \"Usuario modificado correctamente.\");");
                            out.println("</script>");

                        }

            %>

            <br>

            <form action="Salir" method="post">
                <p>
                    <INPUT type="submit" value="Salir">
                </p>
            </form>


        </div>


        <%@ include file="Footer.jsp"%>
        




    </body>
</html>
