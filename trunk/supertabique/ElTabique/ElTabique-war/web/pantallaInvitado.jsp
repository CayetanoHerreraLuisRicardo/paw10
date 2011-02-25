<%-- 
    Document   : pantallaInvitado
    Created on : 24-nov-2010, 13:31:02
    Author     : usuario_local
--%>

<%@page import="java.util.ListIterator"%>
<%@page import="persistencia.Mensaje"%>
<%@page import="java.util.List"%>
<%@page import="tabique.InvitadoViewHelper"%>
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

            <h1>Pantalla de usuario invitado</h1>





            <%

                        InvitadoViewHelper helper = new InvitadoViewHelper(request);

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
