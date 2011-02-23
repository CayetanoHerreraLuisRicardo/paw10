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
        <link id="css1" rel="stylesheet" type="text/css" href="css/estilos.css">

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
                        <LABEL id="nombreLabel">Nombre: </LABEL>
                        <INPUT type="text" name="nombre" id="nombreText"><BR>
                        <br>

                        <INPUT type="radio" name="rol" value="Invitado" id="inv"> Invitado  <BR>
                        <INPUT type="radio" name="rol" value="Usuario" checked id="usr"> Usuario Registrado<BR>
                        <INPUT type="radio" name="rol" value="Admin" id="adm"> Administrador<BR>
                        <br>
                        <INPUT type="submit" value="Entrar">
                    </p>
                </FORM>
            </div>

        </div>




        <script type="text/javascript">
            jQuery("#inv").click(function () {
                jQuery("#nombreText").replaceWith("<INPUT type=\"hidden\" name=\"nombre\" id=\"nombreText\" value=\"Invitado\">");
            });

            jQuery("#adm, #usr").click(function () {
                jQuery("#nombreText").replaceWith("<INPUT type=\"text\" name=\"nombre\" id=\"nombreText\">");
            });

        </script>


        <%

                    String error = "0";

                    if ((request.getSession().getAttribute("result") != null) && request.getSession().getAttribute("result").equals("errorLogin")) {
                        request.getSession().removeAttribute("result");
                        error = "1";
                    }


        %>

        <script type="text/javascript">
            var error = "<%=error%>"; 
            if (error == "1") {
                mensajeError($("#login"), "Usuario o rol inválidos.");
            }
        </script>

        <%@ include file="Footer.jsp"%>
        <%@ include file="MenuEstilo.jsp"%>


    </body>
</html>
