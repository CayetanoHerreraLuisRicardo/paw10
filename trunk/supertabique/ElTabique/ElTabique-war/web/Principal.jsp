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

        <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.qtip-1.0.0-rc3.min.js"></script>
        <script type="text/javascript" src="js/notificaciones.js"></script>
    </head>
    <body>
        <%@ include file="Header.jsp"%>


        <div id ="container">

            <div id ="login">


                <FORM action="autenticacion" method="post" id="formLogin">
                    <p>
                        <LABEL for="nombre">Nombre: </LABEL>
                        <INPUT type="text" name="nombre"><BR>
                        <br>

                        <INPUT type="radio" name="rol" value="Invitado" checked="true"> Invitado<BR>
                        <INPUT type="radio" name="rol" value="Usuario"> Usuario Registrado<BR>
                        <INPUT type="radio" name="rol" value="Admin"> Administrador<BR>
                        <br>
                        <INPUT type="submit" value="Entrar">
                    </p>
                </FORM>
            </div>

        </div>

        <%

                    if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("errorLogin")) {
                        request.getSession().removeAttribute("result");

                        out.println(" <script type=\"text/javascript\">");
                        out.println("mensajeError($(\"#login\"), \"Usuario o rol inválidos.\");");
                        out.println("</script>");

                    }

        %>

        <%@ include file="Footer.jsp"%>

    </body>
</html>