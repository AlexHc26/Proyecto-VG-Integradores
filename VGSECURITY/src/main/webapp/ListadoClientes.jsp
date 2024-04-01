<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,mantenimiento.*,servlet.*, model.*"  %>
<!DOCTYPE html>
<html>
<head>
<link href="EstilosCliente.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Listado de Clientes</title>
<%
		List<Cliente> losClientes=(List<Cliente>) request.getAttribute("LISTACLIENTES");
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
			<td class="cabecera">Código Cliente</td>
			<td class="cabecera">Nombre Cliente</</td>
			<td class="cabecera">Apellido</td>
			<td class="cabecera">Direccion</td>
			<td class="cabecera">Fecha Nacimiento</td>
			<td class="cabecera">Telefono</td>
			<td class="cabecera">Correo</td>
			<td colspan="2" class="btn-container"><div id="contenedorBoton">
				<input class="boton" type="button" value="Nuevo Cliente" onclick="window.location.href='InsertarClientes.jsp'"/>
			</div></td>
		</tr>
		
	<% for (Cliente tempClient: losClientes){%>
		<tr>
			<td><%= tempClient.getCod_client()%></td>
			<td><%= tempClient.getNom_client() %></td>
			<td><%= tempClient.getApe_client()%></td>
			<td><%= tempClient.getDireccion()%></td>
			<td><%= tempClient.getFech_nac() %></td>
			<td><%= tempClient.getTelefono() %></td>
			<td><%= tempClient.getCorreo() %></td>
			<td><a href="ControladorClientes?instruccion=cargar&cod_client=<%=tempClient.getCod_client()%>">Actualizar</a></td>
			<td><a href="ControladorClientes?instruccion=eliminar&cod_client=<%=tempClient.getCod_client()%>">Eliminar</a></td>
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