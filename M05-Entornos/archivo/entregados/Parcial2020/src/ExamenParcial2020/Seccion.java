package ExamenParcial2020;

import java.util.ArrayList;

public class Seccion {
	private String id;
	private ArrayList<ProductoEnStock> productoEnStock;
	
	public Seccion(String id) {
		this.id = id;
		this.productoEnStock = new ArrayList<ProductoEnStock>();
	}
	
	public Seccion() {
		this.productoEnStock = new ArrayList<ProductoEnStock>();
	}
}
