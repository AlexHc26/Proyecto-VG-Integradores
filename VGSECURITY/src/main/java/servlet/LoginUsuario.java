package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mantenimiento.GestionUsuario;
import model.Usuario;

import java.io.IOException;

/**
 * Servlet implementation class LoginUsuario
 */
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		//Validar Usuario
		String usuario, clave;
		
		usuario = request.getParameter("txtUsuario");
		clave = request.getParameter("txtClave");
		
		GestionUsuario gu = new GestionUsuario();
		Usuario u = gu.validarusuario(usuario, clave);
		
		if(u!=null) {
			response.sendRedirect("principal.jsp");
		}else {			
			request.setAttribute("msg", "Usuario o clave incorrecto");		
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
