package mantenimiento;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.MySqlConexion;

public class ModeloClientes {

	public List<Cliente> getCliente() throws Exception{
		// TODO Auto-generated method stub
List<Cliente> cliente = new ArrayList<>();
		
		Connection miConexion = null;
		
		Statement miStatement = null;
		
		ResultSet miResultSet = null;
		
		//ESTABLECER LA CONEXIÓN
		miConexion = MySqlConexion.getConexion();
		
		//CREAR SENTENCIA SQL
		String instruccionSql = "SELECT * FROM CLIENTE";
		miStatement = miConexion.createStatement();
		
		//EJECUTAR SQL
		miResultSet = miStatement.executeQuery(instruccionSql);
		
		//RECORRER EL RESULTSET OBTENIDO
		while(miResultSet.next()) {
			String cod_client = miResultSet.getString("COD_CLIENT");
			String nom_client = miResultSet.getString("NOM_CLIENT");
			String ape_client = miResultSet.getString("APE_CLIENT");
			String direccion = miResultSet.getString("DIRECCION");
			String fech_nac= miResultSet.getString("FECH_NAC");
			String telefono = miResultSet.getString("TELEFONO");
			String correo = miResultSet.getString("CORREO");
			
			Cliente temClient = new Cliente(cod_client,nom_client,ape_client,direccion,fech_nac,telefono,correo);
			cliente.add(temClient);
		}
		return cliente;
		
	}

	public void agregarElNuevoCliente(Cliente nuevoCliente) {
		// TODO Auto-generated method stub
        Connection miConnection = null;
		
		PreparedStatement miStatement = null;
		
		try{
			miConnection = MySqlConexion.getConexion();
		
			String sql = "INSERT INTO cliente (cod_client, nom_client,ape_client,direccion,fech_nac,telefono,correo) VALUES (?,?,?,?,?,?,?)";
		
			miStatement = miConnection.prepareStatement(sql);
		
			miStatement.setString(1, nuevoCliente.getCod_client());
			miStatement.setString(2, nuevoCliente.getNom_client());
			miStatement.setString(3, nuevoCliente.getApe_client());
			miStatement.setString(4, nuevoCliente.getDireccion());
			miStatement.setString(5, nuevoCliente.getFech_nac());
			miStatement.setString(6, nuevoCliente.getTelefono());
			miStatement.setString(7, nuevoCliente.getCorreo());
			
			miStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Cliente getCliente(String cod_client) {
		// TODO Auto-generated method stub
		Cliente elCliente = null;
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		ResultSet miResultset = null;
	    String codigoCliente = cod_client;
	    try {
	    	// ESTABLECER CONEXIÓN A BD
	    	miConexion = MySqlConexion.getConexion();
	    	
	    	// CREAR SQL QUE BUSQUE EL PRODUCTO
	    	String sql = "SELECT * FROM CLIENTE WHERE COD_CLIENT=?";
	    	
	    	// CREAR EL PREPARED STATEMENT
	    	miStatement=miConexion.prepareStatement(sql);
	    	
	    	// ESTALECER PARÁMETROS
	    	miStatement.setString(1, codigoCliente);
	    	
	    	// EJECUTAR LA CONSULTA
	    	miResultset=miStatement.executeQuery();
	    	
	    	//OBTENER LOS DATOS DE RESPUESTA
	    	if(miResultset.next()) {
	    		String cod_clien = miResultset.getString("COD_CLIENT");
	    		String nom_client = miResultset.getString("NOM_CLIENT");
	    		String ape_client = miResultset.getString("APE_CLIENT");
	    		String direccion = miResultset.getString("DIRECCION");
	    		String fech_nac = miResultset.getString("FECH_NAC");
	    		String telefono = miResultset.getString("TELEFONO");
	    		String correo = miResultset.getString("CORREO");
	    		
	    		elCliente = new Cliente(cod_clien, nom_client, ape_client, direccion,fech_nac,telefono,correo);
	    		
	    	}else {
	    		throw new Exception("No encontramos el cliente con código " + codigoCliente);
	    	}
	    }catch(Exception e) {
	    	
	    }
	    return elCliente;
	}

	public void actualizarCliente(Cliente ClienteActualizar) throws Exception {
		// TODO Auto-generated method stub
		Connection miConexion = null;
		PreparedStatement miStatement = null;

		 
		 miConexion = MySqlConexion.getConexion();
		
		 String sql = "UPDATE CLIENTE SET NOM_CLIENT=?, APE_CLIENT=?, DIRECCION=?, FECH_NAC=?, TELEFONO=?, CORREO=? WHERE COD_CLIENT=?";
		
		 miStatement=miConexion.prepareStatement(sql);
		
		 miStatement.setString(1, ClienteActualizar.getNom_client());
		 miStatement.setString(2, ClienteActualizar.getApe_client());
		 miStatement.setString(3, ClienteActualizar.getDireccion());
		 miStatement.setString(4, ClienteActualizar.getFech_nac());
		 miStatement.setString(5, ClienteActualizar.getTelefono());
		 miStatement.setString(6, ClienteActualizar.getCorreo());
		 miStatement.setString(7, ClienteActualizar.getCod_client());
		 
		 miStatement.execute();
	}

	public void eliminarCliente(String cod_client) throws Exception{
		// TODO Auto-generated method stub
		 Connection miConexion = null;
		 PreparedStatement miStatement = null;
		 
		 miConexion = MySqlConexion.getConexion();
		 String sql = "DELETE FROM CLIENTE WHERE cod_client=?";
		 miStatement=miConexion.prepareStatement(sql);
		 miStatement.setString(1, cod_client);
		 miStatement.execute();
	}
}

	

