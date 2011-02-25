<%-- 
    Document   : pantallaAdmin
    Created on : 23-nov-2010, 13:37:26
    Author     : usuario_local
--%>

<%@page import="tabique.Rol"%>
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
        <% if (((String)request.getSession().getAttribute("estilo")).equals("1")) {%>
        <link id="css1" rel="stylesheet" type="text/css" href="css/estilos.css">
        <%  } else {%>
        <link id="css1" rel="stylesheet" type="text/css" href="css/estilos2.css">
        <% }%>

        <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.qtip-1.0.0-rc3.min.js"></script>
        <script type="text/javascript" src="js/notificaciones.js"></script>

    </head>
    <body>


        <%@ include file="Header.jsp"%>



        <div id="container">

            <h1>Pantalla de administrador</h1>



            <%
                        String rol = ((Rol) request.getSession().getAttribute("rol")).toString();
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
            %>

            <script type="text/javascript">
                mensajeError($("#formAdd"), "Usuario ya existente.");
            </script>

            <%

                                    } else if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("okAdd")) {
                                        request.getSession().removeAttribute("result");

            %>
            <script type="text/javascript">
                mostrarNotificacion($("#formAdd"), "Usuario creado correctamente.");
            </script>

            <%
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
            %>

            <script type="text/javascript">
                mensajeError($("#formAdd"), "Usuario no existente."); 
            </script>

            <%

                                    } else if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("okDelete")) {
                                        request.getSession().removeAttribute("result");
            %>

            <script type="text/javascript">
                mostrarNotificacion($("#formAdd"), "Usuario borrado correctamente."); 
            </script>
            <%
                        }

            %>



            <%

                        AdminViewHelper helper = new AdminViewHelper(request);

                        List<Usuario> us = helper.getUsers();
            %>

            <p>

                <%
                            Iterator<Usuario> itr = us.iterator();

                            Usuario usuario;
                            while (itr.hasNext()) {
                                usuario = itr.next();

                %>

            <p>
                <strong class="usuario"><%=usuario.getId()%></strong><strong class="tipoUsuario">  [<%=usuario.getRol()%>] </strong> Convertir en: <br>
            <FORM action="GestionUsuarios?user=<%=usuario.getId()%>" method="post">
                <INPUT type="submit" name="setInvitado" value="Invitado">
                <INPUT type="submit" name="setUsuario" value="Usuario">
                <INPUT type="submit" name="setAdmin" value="Admin">
            </FORM>
        </p>

        <%
                    }
        %>

    </p>







    <%
                if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("errorModif")) {
                    request.getSession().removeAttribute("result");
    %>

    <script type="text/javascript">
        mensajeError($("#formAdd"), "Usuario no existente.");
    </script>

    <%

                    } else if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("okModif")) {
                        request.getSession().removeAttribute("result");

    %>

    <script type="text/javascript">
        mostrarNotificacion($("#formAdd"), "Usuario modificado correctamente.");
    </script>

    <%
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
<%@ include file="MenuEstilo.jsp"%>





</body>
</html>
