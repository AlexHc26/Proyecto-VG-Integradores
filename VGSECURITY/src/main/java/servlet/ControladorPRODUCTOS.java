package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mantenimiento.ModeloProductos;
import model.Producto;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ControladorPRODUCTOS
 */
public class ControladorPRODUCTOS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private ModeloProductos modeloProductos;
	
	public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	try {
    		modeloProductos = new ModeloProductos();   		
    	}catch(Exception e) {
    		throw new ServletException(e);
    	}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
String elComando = request.getParameter("instruccion");
		
		//SI NO SE ENVÍA EL PARÁMETRO, LEER PRODUCTOS
		if(elComando==null) elComando = "listar";
		
		//REDIRIGIR EL FLUJO DE EJECUCIÓN AL MÉTODO ADECUANDO
		switch(elComando) {
		case "listar":
			obtenerProductos(request,response);
			break;
		case "insertarBBDD":
		    agregarProductos(request,response);
		    break;
		case "cargar":
			try {
				cargarProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "actualizarBBDD":
		    try {
		    	actualizarProductos(request,response);
		    } catch (Exception e) {
		    	//TODO Auto-generated catch black
		    	e.printStackTrace();
		    }
		    break;
		case "eliminar":
			 try {
			 eliminarProductos(request,response);
			 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 break;
		default:
			obtenerProductos(request,response);
		}
	}

	private void eliminarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String cod_prod=request.getParameter("cod_prod");	
		 modeloProductos.eliminarProducto(cod_prod);	 
		 obtenerProductos(request,response);		
	}

	private void actualizarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int cod_prod = Integer.parseInt(request.getParameter("cod_prod"));
		String nom_prod = request.getParameter("nom_prod");
		int fknom_marc = Integer.parseInt(request.getParameter("fknom_marc"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));

					
		Producto ProductoActualizar = new Producto(cod_prod, nom_prod, fknom_marc, precio,stock);
						
		modeloProductos.actualizarCliente(ProductoActualizar);
						
		obtenerProductos(request, response);
	}

	private void cargarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int cod_prod= Integer.parseInt(request.getParameter("cod_prod"));
		
		Producto elProducto=modeloProductos.getProducto(cod_prod);
	    		
		request.setAttribute("ProductoActualizar", elProducto);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarProducto.jsp");
		dispatcher.forward(request, response);
		
	}

	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		
		String nom_prod = request.getParameter("nom_prod");
		int fknom_marc = Integer.parseInt(request.getParameter("fknom_marc"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		double precio = Double.parseDouble(request.getParameter("precio"));
						
		Producto NuevoProducto = new Producto(nom_prod, fknom_marc, precio,stock);
		
		modeloProductos.agregarNuevoProducto(NuevoProducto);
		
		obtenerProductos(request, response);
		
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		List<Producto> productos;
	    try {
			productos = modeloProductos.getProductos();
				
			request.setAttribute("LISTAPRODUCTOS", productos);
				
			RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListadoProducto.jsp");
			miDispatcher.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
		
}

