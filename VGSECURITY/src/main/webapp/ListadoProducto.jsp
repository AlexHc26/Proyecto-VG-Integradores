<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,mantenimiento.*,servlet.*, model.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="EstilosProducto.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Listado de Producto</title>
	<%
		List<Producto> losProductos=(List<Producto>) request.getAttribute("LISTAPRODUCTOS");
	%>
</head>
<body>
<nav>
        <div class="logo"><p>VG INTEGRADORES</p></div>
        
            <ul class="menu-container">

                <li>
                    <a href="#">Ventas</a>
                    <ul class="option-container">
                        <li><a href="#">Generar Cotización</a></li>
                        <li><a href="#">Generar Comprobante de Pago</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Órdenes</a>
                    <ul class="option-container">
                        <li><a href="#">Orden de compra</a></li>
                        <li><a href="#">Orden de despacho</a></li>
                        <li><a href="#">Orden reito domicilio</a></li>
                    </ul>
                </li>
                <li><a href="#">Stock</a></li>
                <li><a href="#">Clientes</a></li>
            </ul>
    </nav>
    <main>
        <table>
		<tr>
			<td class="cabecera">Codigo Producto</td>
			<td class="cabecera">Nombre Producto</td>
			<td class="cabecera">IdMarca</td>
			<td class="cabecera">Precio</td>
			<td class="cabecera">Stock</td>
			<td colspan="2" class="btn-container"><div id="contenedorBoton">
				<input class="boton" type="button" value="Nuevo Producto" onclick="window.location.href='InsertarProducto.jsp'"/>
			</div></td>
		</tr>
		
	<% for (Producto tempProducto: losProductos){ %>
		<tr>
			<td><%= tempProducto.getCod_prod()%></td>
			<td><%= tempProducto.getNom_prod() %></td>
			<td><%= tempProducto.getFknom_marc()%></td>
			<td><%= tempProducto.getPrecio()%></td>
			<td><%= tempProducto.getStock()%></td>
			<td><a href="ControladorPRODUCTOS?instruccion=cargar&cod_prod=<%=tempProducto.getCod_prod()%>">Actualizar</a></td>
			<td><a href="ControladorPRODUCTOS?instruccion=eliminar&cod_prod=<%=tempProducto.getCod_prod()%>">Eliminar</a></td>
		</tr>
	<% } %>
	
		<tr>
			<td colspan="9" class="pie"></td>
		</tr>
	</table>            
    </main>
       <footer>
            <div class="social-content">
                <h2>Síguemos en:</h2> 
                <div class="logo-footer"><p>VG INTEGRADORES</p></div>
                <a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley"><img class="rs" src="fb.png" alt="#" data-i="0"></a>
                <a href="#"><img class="rs" src="insta.png"></a>
                <a href="#"><img class="rs"  src="twit.png"></a>
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
</body>
</html>