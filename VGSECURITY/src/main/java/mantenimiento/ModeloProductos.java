package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Producto;
import util.MySqlConexion;

public class ModeloProductos {

	public void actualizarCliente(Producto productoActualizar) throws Exception{
		Connection miConexion = null;
		PreparedStatement miStatement = null;

		 miConexion = MySqlConexion.getConexion();
		
		 String sql = "UPDATE PRODUCTOS SET NOM_PROD=?, FKNOM_MARC=?, PRECIO=?, STOCK=? WHERE COD_PROD=?";
		
		 miStatement=miConexion.prepareStatement(sql);
		
		 
		 miStatement.setString(1, productoActualizar.getNom_prod());
		 miStatement.setInt(2, productoActualizar.getFknom_marc());
		 miStatement.setDouble(3, productoActualizar.getPrecio());
		 miStatement.setInt(4, productoActualizar.getStock());
		 miStatement.setInt(5, productoActualizar.getCod_prod());
		 
		 miStatement.execute();
	}

	public Producto getProducto(int cod_prod) {
		// TODO Auto-generated method stub
				Producto elProducto = null;
				Connection miConexion = null;
				PreparedStatement miStatement = null;
				ResultSet miResultset = null;
			    int codigoProducto = cod_prod;
			    try {
			    	miConexion = MySqlConexion.getConexion();
			    	
			    	String sql = "SELECT * FROM PRODUCTOS WHERE COD_PROD=?";
			    	
			    	miStatement = miConexion.prepareStatement(sql);
			    	
			    	miStatement.setInt(1, codigoProducto);
			    	
			    	miResultset=miStatement.executeQuery();
			    	
			    	if(miResultset.next()) {
			    		int cod_produ = miResultset.getInt("cod_prod");
			    		String nom_prod = miResultset.getString("nom_prod");
			    		int fknom_prod = miResultset.getInt("fknom_marc");
			    		double precio = miResultset.getDouble("precio");
			    		int stock = miResultset.getInt("stock");
			    		
			    		elProducto = new Producto(cod_produ, nom_prod, fknom_prod, precio,stock);
			    		
			    	}else {
			    		throw new Exception("No encontramos el producto con código " + codigoProducto);
			    	}
			    }catch(Exception e) {
			    	
			    }
			    return elProducto;
	}

	public List<Producto> getProductos() throws Exception{
		List<Producto> producto = new ArrayList<>();
		 
		 Connection miConexion = null;
		 Statement miStatement = null;
		 ResultSet miResultSet = null;
		
		 //ESTABLECER LA CONEXIÓN
		 miConexion = MySqlConexion.getConexion();
		 
		 //CREAR SENTENCIA SQL
		 String instruccionSql = "SELECT * FROM PRODUCTOS";
		 miStatement = miConexion.createStatement();
		 
		 //EJECUTAR SQL
		 miResultSet = miStatement.executeQuery(instruccionSql);
		 
		 //RECORRER EL RESULTSET OBTENIDO
		 while(miResultSet.next()) {
			 int cod_prod = miResultSet.getInt("Cod_prod");
			 int stock = miResultSet.getInt("Stock");
			 int fknom_marc = miResultSet.getInt("FKnom_marc");
			 double precio = miResultSet.getDouble("Precio");
			 String nom_prod = miResultSet.getString("Nom_prod");
			 
			 Producto temProd = new Producto(cod_prod,nom_prod,fknom_marc,precio,stock);
			 producto.add(temProd);
		 }
		 return producto;
	}

	public void eliminarProducto(String cod_prod) throws Exception{
		Connection miConexion = null;
		 PreparedStatement miStatement = null;
		 
		 miConexion = MySqlConexion.getConexion();
		 String sql = "DELETE FROM PRODUCTOS WHERE cod_prod=?";
		 miStatement=miConexion.prepareStatement(sql);
		 miStatement.setString(1, cod_prod);
		 miStatement.execute();
	}

	public void agregarNuevoProducto(Producto nuevoProducto) {
		Connection miConnection = null;
		
		PreparedStatement miStatement = null;
		
		try{
			miConnection = MySqlConexion.getConexion();
		
			String sql = "insert into productos (cod_prod,nom_prod, fknom_marc,precio,stock)values (null,?,?,?,?)";
		
			miStatement = miConnection.prepareStatement(sql);

			miStatement.setString(1, nuevoProducto.getNom_prod());
			miStatement.setInt(2, nuevoProducto.getFknom_marc());
			miStatement.setDouble(3, nuevoProducto.getPrecio());
			miStatement.setInt(4, nuevoProducto.getStock());
			
			miStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	

}
