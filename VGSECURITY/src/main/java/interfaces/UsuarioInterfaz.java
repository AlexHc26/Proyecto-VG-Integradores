package interfaces;

import model.Usuario;

public interface UsuarioInterfaz {
	public Usuario validarusuario(String usuario, String clave);
	
	public int registrarUsuario(Usuario u);
	
}
