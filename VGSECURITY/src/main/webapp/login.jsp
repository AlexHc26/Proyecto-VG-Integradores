<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio </title>
<link href="EstilosLogin.css" rel="stylesheet">
</head>
<body>
    <main>
        <div class="title-container">
            <h1>Welcome to <br> VG Integradores Security</h1>
        </div>
        <div class="login-container">
            <form class="form" action="LoginUsuario">
            <h2 class ="title">VG Integradores Security</h2>
                <label class="label">Usuario :</label>
                <input class="input" id="txtUsuario" name="txtUsuario" type="text" required placeholder="Ingrese usuario" maxlength="5">
                
                <label class="label">Clave :</label>
                <input class="input" id="txtClave" name="txtClave" type="password" required placeholder="6 numeros" pattern="[0-9]{6}" maxlength="6">
                
                <input class="input button" type="submit" id="btnIngresar" value="Ingresar">
            </form>
        </div>        
    </main>
        
        <footer>
            <div class="social-content">
               <h2>Síguemos en:</h2> 
               <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley"><img class="rs" src="fb.png" alt="#" data-i="0"></a>
               <a href="#"><img class="rs" src="insta.png" alt="#" data-i="1"></a>
               <a href="#"><img class="rs"  src="twit.png" alt="#" data-i="2"></a>
            </div>
            <div>
                <h2>Nosotros:</h2>
                <ul>
                	<li><a href="#">Historia</a></li>
                	<li><a href="#">Socios</a></li>
                </ul>
            </div>
            <div class="social-content">
               <h2>Tienda Online:</h2> 
               <ul>
                	<li><a href="#">Mis pedidos</a></li>
                	<li><a href="#">Medios de pago</a></li>
                	<li><a href="#">Preguntas frecuentes</a></li>
                </ul>
            </div>
            <div>
                <h2>Contáctenos</h2>
                <ul>
                	<li><a href="#">Correos</a></li>
                	<li><a href="#">Números</a></li>
                	<li><a href="#">Consultas y sugerencias</a></li>
                </ul>
                <a href="#"><img class="libro" src="libro_recla.jpg" alt="#"></a>
            </div>
            <div class="copyright">
            	<hr>
            	<p>©Derechos Reservados VG Integradores</p>
            </div>
        </footer> 
        <center>
            ${msg}
            </center>
</body>
</html>