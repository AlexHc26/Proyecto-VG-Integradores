<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Registro</title>
<link href="EstiloClienteInsertar.css" rel="stylesheet">
</head>
<body>
	<form name="form1" method="get"action="ControladorClientes">
	<h1>Registrar Cliente</h1>
	
	<input type="hidden" name="instruccion" value="insertarBBDD">
	<label for "cod_client">Código Cliente</label>
	<input type="text" name="cod_client" id="cod_client">
	
	<label for "nom_client">Nombre Cliente</label>
	<input type="text" name="nom_client" id="nom_client">
	
	<label for "ape_client">Apellido Cliente</label>
	</label><input type="text" name="ape_client" id="ape_client">
	
	<label for "direccion">Direccion</label>
	<input type="text" name="direccion" id="direccion">
	
	<label for "fech_nac">Fecha Nacimiento</label>
	<input type="text" name="fech_nac" id="fech_nac">
	
	<label for "telefono">Telefono</label>
	<input type="text" name="telefono" id="telefono">
	
	<label for "correo">Correo</label>
	<input type="text" name="correo" id="correo">
	
	<div class=btn-container>
		<input class="btn" type="submit" name="envio" id="envio" value="Enviar">
		<input class="btn" type="reset" name="borrar" id="borrar" value="Restablecer">
	</div>

	</form>
</body>
</html>