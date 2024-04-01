<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control Registro</title>
</head>
<body>  
   <div id="contenido" style="margin-left: 20%; width: 60%;">
      <h1>Registro de usuario</h1> 
       <form action="LoginUsuario" method="post">
          <div class="form-group"> 
            <label for="exampleInputEmail1">Nombre :</label>
            <%-- letras mayus o min hasta 28 caracteres  --%> 
            <input
              type="text" class="form-control" id="nombre"
              placeholder="Ingrese su nombre"
              name="txtNombre">
           </div> 
            
            <div class="form-group">   
            <label for="exampleInputEmail1">Apellido :</label> 
            <input
              type="text" class="form-control" id="apellido"
              placeholder="Ingrese su apellido"
              name="txtApellido">
              </div> 
             
             <div class="form-group">
            <label for="exampleInputEmail1">Usuario :</label> 
            <input
              type="text" class="form-control" id="usuario"
              placeholder="Ingrese su usuario" 
              name="txtUsuario">
              </div> 
            
            <div class="form-group">
            <label for="exampleInputEmail1">Clave :</label>
            <input
              type="text" class="form-control" id="clave"
              placeholder="Ingrese su clave"
              name="txtClave">
             </div>
             
             <div class="form-group">
            <label for="exampleInputEmail1">Fecha Acceso :</label> 
            <input
              type="text" class="form-control" id="facceso"
              placeholder="Ingrese fecha acceso"
              name="txtFecha">
              </div>
                         
			<input type="submit" name="envio" id="envio" value="Enviar">
			<input type="reset" name="borrar" id="borrar" value="Restablecer">
	      </form>            
   </div>  
</body>
</html>