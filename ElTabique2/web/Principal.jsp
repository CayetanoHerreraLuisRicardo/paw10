<%-- 
    Document   : Principal
    Created on : 27-ene-2011, 17:16:02
    Author     : usuario_local
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>El Tabique - Inicio de Sesión</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
    </head>
    <body>
        <%@ include file="Header.jsp"%>
        <div id ="container">

            <FORM action="/eltabique/autenticacion" method="post">
                <p>
                <LABEL for="nombre">Nombre: </LABEL>
                <INPUT type="text" name="nombre"><BR>
                <br>

                <INPUT type="radio" name="rol" value="Invitado" checked="true"> Invitado<BR>
                <INPUT type="radio" name="rol" value="Usuario"> Usuario Registrado<BR>
                <INPUT type="radio" name="rol" value="Admin"> Administrador<BR>
                <br>
                <INPUT type="submit" value="Enviar">
                </p>
                </FORM>
        </div>
    </body>
</html>
