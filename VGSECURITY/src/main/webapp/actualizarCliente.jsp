<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="EstiloClienteActualizar.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Actualizar Cliente</title>
</head>
<body>
	<form name="form1" method="get" action="ControladorClientes">
	<h1>Actualizar Cliente</h1>
	<input type="hidden" name="instruccion" value="actualizarBBDD">
	<input type="hidden" name="cod_client" value="${ClienteActualizar.cod_client}">
	
	<label for "nom_client">Nombre Cliente</label>
	<input type="text" name="nom_client" id="nom_client" value="${ClienteActualizar.nom_client}">
	
	<label for "ape_client">Apellido Cliente</label>
	<input type="text" name="ape_client" id="ape_client" value="${ClienteActualizar.ape_client}">
	
	<label for "direccion">Direccion</label>
	<input type="text" name="direccion" id="direccion" value="${ClienteActualizar.direccion}">
	
	<label for "fech_nac">Fecha Nacimiento</label>
	<input type="text" name="fech_nac" id="fech_nac" value="${ClienteActualizar.fech_nac}">
	
	<label for "telefono">Telefono</label>
	<input type="text" name="telefono" id="telefono" value="${ClienteActualizar.telefono}">
	
	<label for "correo">Correo</label>
	<input type="text" name="correo" id="correo" value="${ClienteActualizar.correo}">
	<div class="btn-container">
		<input class="btn" type="submit" name="envio" id="envio" value="Guardar Cambios">
		<input class="btn" type="reset" name="borrar" id="borrar" value="Reestablecer">
	</div>

	</form>
</body>
</html>