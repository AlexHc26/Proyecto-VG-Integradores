package model;

public class Usuario {
	private int codigo, tipo, estado;
	private String nombre, apellido, usuario, clave, facceso;
	
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", tipo=" + tipo + ", estado=" + estado + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", usuario=" + usuario + ", clave=" + clave + ", facceso=" + facceso + "]";
	}
	
	public Usuario() {
	}
	
	public Usuario(String nombre, String apellido, String usuario, String clave, String facceso) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.facceso = facceso;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getFacceso() {
		return facceso;
	}
	public void setFacceso(String facceso) {
		this.facceso = facceso;
	}
	
}