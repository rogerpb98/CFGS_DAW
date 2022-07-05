package ExamenParcial2020;

public class Producto {
	protected String id;
	protected String nombre;
	protected String fabricante;
	protected double precioUnidadEu;
	
	public Producto(String id, String nombre, String fabricante, double precioUnidadEu) {
		this.id = id;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.precioUnidadEu = precioUnidadEu;
	}
	public Producto() {
	}
	
}
