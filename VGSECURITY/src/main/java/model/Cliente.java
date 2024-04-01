package model;

public class Cliente {
	
      private String cod_client,nom_client,ape_client,direccion,fech_nac,telefono,correo;

	public Cliente(String cod_client, String nom_client, String ape_client, String direccion, String fech_nac,
			String telefono, String correo) {
		super();
		this.cod_client = cod_client;
		this.nom_client = nom_client;
		this.ape_client = ape_client;
		this.direccion = direccion;
		this.fech_nac = fech_nac;
		this.telefono = telefono;
		this.correo = correo;
	}

	public Cliente(String nom_client, String ape_client, String direccion, String fech_nac, String telefono,
			String correo) {
		super();
		this.nom_client = nom_client;
		this.ape_client = ape_client;
		this.direccion = direccion;
		this.fech_nac = fech_nac;
		this.telefono = telefono;
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Cliente [cod_client=" + cod_client + ", nom_client=" + nom_client + ", ape_client=" + ape_client
				+ ", direccion=" + direccion + ", fech_nac=" + fech_nac + ", telefono=" + telefono + ", correo="
				+ correo + "]";
	}

	public String getCod_client() {
		return cod_client;
	}

	public void setCod_client(String cod_client) {
		this.cod_client = cod_client;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getApe_client() {
		return ape_client;
	}

	public void setApe_client(String ape_client) {
		this.ape_client = ape_client;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFech_nac() {
		return fech_nac;
	}

	public void setFech_nac(String fech_nac) {
		this.fech_nac = fech_nac;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
      
      

}
