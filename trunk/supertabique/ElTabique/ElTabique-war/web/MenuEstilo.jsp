
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


    <FORM name="cambiarEstilo" action="#">
        <p>
            <input type="button" value="Cambiar CSS" onclick="cambiaEstilo()">
        </p>
    </FORM>

</div>
