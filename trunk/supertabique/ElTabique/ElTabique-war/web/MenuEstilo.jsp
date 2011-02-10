

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <div id="menuEstilo">

            <script type="text/javascript">
                function cambiaEstilo() {

                    if (document.getElementById('css1').getAttribute('href') == "css/estilos.css") {
                        document.getElementById('css1').href = "css/estilos2.css";
                    }
                    else {
                        document.getElementById('css1').href = "css/estilos.css";
                    }
                }

            </script>


            <FORM name="cambiarEstilo">
                <p>
                    <input type="button" value="Cambiar CSS" onclick="cambiaEstilo()">
                </p>
            </FORM>

        </div>
    </body>
</html>
