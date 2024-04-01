package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.UsuarioInterfaz;
import model.Usuario;
import util.MySqlConexion;

public class GestionUsuario implements UsuarioInterfaz{

	@Override
	public Usuario validarusuario(String usuario, String clave) {
		Usuario u = null;
		//Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySqlConexion.getConexion();
			String sql = "{CALL usp_validarAcceso(?,?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, clave);
			rs = pst.executeQuery();
			if(rs.next()) {
				u = new Usuario();
				//seteamos los campos
				u.setApellido(rs.getString(3));
				u.setCodigo(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setUsuario(usuario);
				u.setClave(clave);
				u.setFacceso(rs.getString(6));
				u.setTipo(rs.getInt(7));
				u.setEstado(rs.getInt(8));
			}
		}catch(Exception e){
			System.out.println("Error al validar: " + e.getMessage());
		}finally {
			MySqlConexion.closeConexion(con);
		}
		return u;
	}

	@Override
	public int registrarUsuario(Usuario u) {
		int rs = 0; 
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySqlConexion.getConexion();
			String sql = "insert into tb_usuarios (cod_user,nom_user,apellido,username,clave,fec_acceso,tipo,estado) values (null,?,?,?,?,?,default,default)";
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getUsuario());
			pst.setString(4, u.getClave());
			pst.setString(5, u.getFacceso());
		}catch (Exception e) {
			System.out.println("Error al registrar usuario: " + e.getMessage());
		}finally {
			MySqlConexion.closeConexion(con);
		}
		return rs;
	}
	
}
