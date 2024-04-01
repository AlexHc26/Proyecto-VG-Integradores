package model;

public class Producto {
	private int cod_prod, stock, fknom_marc;
	private double precio;
	private String nom_prod;
	
	public Producto(int cod_prod,String nom_prod, int fknom_marc, double precio,int stock) {
		super();
		this.cod_prod = cod_prod;
		this.nom_prod = nom_prod;
		this.fknom_marc = fknom_marc;
		this.precio = precio;
		this.stock = stock;
	}
	public Producto(String nom_prod, int fknom_marc, double precio, int stock) {
		super();
		this.nom_prod = nom_prod;
		this.stock = stock;
		this.fknom_marc = fknom_marc;
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Producto [cod_prod=" + cod_prod + ", stock=" + stock + ", fknom_marc=" + fknom_marc + ", precio="
				+ precio + ", nom_prod=" + nom_prod + "]";
	}
	public int getCod_prod() {
		return cod_prod;
	}
	public void setCod_prod(int cod_prod) {
		this.cod_prod = cod_prod;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getFknom_marc() {
		return fknom_marc;
	}
	public void setFknom_marc(int fknom_marc) {
		this.fknom_marc = fknom_marc;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNom_prod() {
		return nom_prod;
	}
	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}	
}