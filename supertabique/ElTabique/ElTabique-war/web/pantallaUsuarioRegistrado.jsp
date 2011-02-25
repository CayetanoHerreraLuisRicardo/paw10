<%--
    Document   : pantallaUsuarioRegistrado
    Created on : 24-nov-2010, 13:35:18
    Author     : usuario_local
--%>

<%@page import="tabique.Rol"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ListIterator"%>
<%@page import="persistencia.Mensaje"%>
<%@page import="tabique.UsuarioRegistradoViewHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% if (((String)request.getSession().getAttribute("estilo")).equals("1")) {%>
        <link id="css1" rel="stylesheet" type="text/css" href="css/estilos.css">
        <%  } else {%>
        <link id="css1" rel="stylesheet" type="text/css" href="css/estilos2.css">
        <% }%>

    </head>
    <body>


        <%@ include file="Header.jsp"%>



        <div id="container">

            <h1>Pantalla de usuario registrado</h1>

            <form action="EnviarMensaje" method="post">
                <p>
                    <LABEL for="mensaje">Mensaje: </LABEL>
                    <BR>
                    <TEXTAREA name="mensaje" COLS="40" ROWS="2"></TEXTAREA>
                    <BR>
                    <INPUT type="submit" value="Enviar">
                </p>
            </form>

            <%
                        String rol = ((Rol) request.getSession().getAttribute("rol")).toString();
                        String nombre = (String) request.getSession().getAttribute("nombre");


                        UsuarioRegistradoViewHelper helper = new UsuarioRegistradoViewHelper(request);

                        List<Mensaje> mensajes = helper.getMensajes();
                        ListIterator<Mensaje> itr = mensajes.listIterator(mensajes.size());
            %>
            <p>


                <%

                            Mensaje mensaje;
                            while (itr.hasPrevious()) {
                                mensaje = itr.previous();
                %>
                <strong class="usuario"><%=mensaje.getEmisor()%>: </strong> <%=mensaje.getTexto()%> <strong class="fecha">[<%=mensaje.getFecha()%>]</strong><br>
                <%
                            }
                %>

            </p>



            <form action="Salir" method="post">
                <p>
                    <INPUT type="submit" value="Salir">
                </p>
            </form>


        </div>


        <%@ include file="Footer.jsp"%>
        <%@ include file="MenuEstilo.jsp"%>


    </body>
</html>
