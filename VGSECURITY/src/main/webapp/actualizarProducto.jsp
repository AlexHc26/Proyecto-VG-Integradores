<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Producto</title>
<link href="EstiloProductoActualizar.css" rel="stylesheet">
</head>
<body>
		<form name="form1" method="get" action="ControladorPRODUCTOS">
		<input type="hidden" name="instruccion" value="actualizarBBDD">
		<input type="hidden" name="cod_prod" value="${ProductoActualizar.cod_prod}">
			<h1>Actualizar Producto</h1>
			<label for "nom_prod">Nombre Producto</label>
			<input type="text" name="nom_prod" id="nom_prod" value="${ProductoActualizar.nom_prod}">
		
			<label for "fknom_marc">ID Marca</label>
			<input type="text" name="fknom_marc" id="fknom_marc" value="${ProductoActualizar.fknom_marc}">
		
			<label for "precio">Precio</label>
			<input type="text" name="precio" id="precio" value="${ProductoActualizar.precio}">
		
			<label for "stock">Stock</label>
			<input type="text" name="stock" id="stock" value="${ProductoActualizar.stock}">
		
		<div class="btn-container">
			<input class="btn" type="submit" name="envio" id="envio" value="Enviar">
			<input class="btn" type="reset" name="borrar" id="borrar" value="Restablecer">
		</div>	
	</form>
</body>
</html>