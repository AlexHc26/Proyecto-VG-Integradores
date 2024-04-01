<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Registro</title>
<link href="EstiloProductoInsertar.css" rel="stylesheet">
</head>
<body>
	<form name="form1" method="get"action="ControladorPRODUCTOS">
	<input type="hidden" name="instruccion" value="insertarBBDD">
			<h1>Registrar Productos</h1>
			<label for "nom_prod">Nombre Producto</label>
			<input type="text" name="nom_prod" id="nom_prod">
		
			<label for "fknom_marc">ID Marca</label>
			<input type="text" name="fknom_marc" id="fknom_marc">
		
			<label for "precio">Precio</label><input type="text" name="precio" id="precio">
		
			<label for "stock">Stock</label>
			<input type="text" name="stock" id="stock">
		
		<div class="btn-container">
			<input type="submit" name="envio" id="envio" value="Enviar">
			<input type="reset" name="borrar" id="borrar" value="Restablecer">
		</div>	
	</form>
</body>
</html>