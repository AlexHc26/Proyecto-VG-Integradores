package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mantenimiento.ModeloClientes;
import model.Cliente;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ControladorClientes
 */
public class ControladorClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
private ModeloClientes modeloClientes;
	
	public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	try {
    		modeloClientes = new ModeloClientes();   		
    	}catch(Exception e) {
    		throw new ServletException(e);
    	}
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LEER EL PARÁMETRO DEL PRODUCTO
		String elComando = request.getParameter("instruccion");
		
		//SI NO SE ENVÍA EL PARÁMETRO, LEER PRODUCTOS
		if(elComando==null) elComando = "listar";
		
		//REDIRIGIR EL FLUJO DE EJECUCIÓN AL MÉTODO ADECUANDO
		switch(elComando) {
		case "listar":
			obtenerClientes(request,response);
			break;
		case "insertarBBDD":
		    agregarClientes(request,response);
		    break;
		case "cargar":
			try {
				cargarClientes(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "actualizarBBDD":
		    try {
		    	actualizarClientes(request,response);
		    } catch (Exception e) {
		    	//TODO Auto-generated catch black
		    	e.printStackTrace();
		    }
		    break;
		case "eliminar":
			 try {
			 eliminarClientes(request,response);
			 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			 break;
		default:
			obtenerClientes(request,response);
		}
	}
private void eliminarClientes(HttpServletRequest request, HttpServletResponse response) throws Exception {
// TODO Auto-generated method stub
		 String cod_client=request.getParameter("cod_client");
		
		 modeloClientes.eliminarCliente(cod_client);
		 
		 obtenerClientes(request,response);	
}
private void actualizarClientes(HttpServletRequest request, HttpServletResponse response) throws Exception{
// TODO Auto-generated method stub

		String cod_client = request.getParameter("cod_client");
		String nom_client = request.getParameter("nom_client");
		String ape_client = request.getParameter("ape_client");
		String direccion = request.getParameter("direccion");
		String fech_nac = request.getParameter("fech_nac");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("correo");
					
	Cliente ClienteActualizar = new Cliente(cod_client, nom_client, ape_client, direccion,fech_nac,telefono,correo);
						
		modeloClientes.actualizarCliente(ClienteActualizar);
						
		obtenerClientes(request, response);
	}

private void cargarClientes(HttpServletRequest request, HttpServletResponse response) throws Exception {
// TODO Auto-generated method stub

		String cod_client=request.getParameter("cod_client");
					
		Cliente elCliente=modeloClientes.getCliente(cod_client);
	    		
		request.setAttribute("ClienteActualizar", elCliente);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/actualizarCliente.jsp");
		dispatcher.forward(request, response);
	}

private void agregarClientes(HttpServletRequest request, HttpServletResponse response) {
// TODO Auto-generated method stub

		String cod_client = request.getParameter("cod_client");
		String nom_client = request.getParameter("nom_client");
		String ape_client = request.getParameter("ape_client");
		String direccion = request.getParameter("direccion");
		String fech_nac = request.getParameter("fech_nac");
		String telefono = request.getParameter("telefono");
		String correo = request.getParameter("correo");
						
		Cliente NuevoCliente = new Cliente(cod_client, nom_client, ape_client, direccion,fech_nac,telefono,correo);
		
		modeloClientes.agregarElNuevoCliente(NuevoCliente);
		
		obtenerClientes(request, response);
	}

private void obtenerClientes(HttpServletRequest request, HttpServletResponse response) {
// TODO Auto-generated method stub
List<Cliente> clientes;
		try {
			clientes = modeloClientes.getCliente();
			
			//AGREGAR LA LISTA DE PRODUCTOS AL REQUEST
			request.setAttribute("LISTACLIENTES", clientes);
			
			//ENVIAR ESE REQUEST A LA PÁGINA JSP
			RequestDispatcher miDispatcher=request.getRequestDispatcher("/ListadoClientes.jsp");
			miDispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

