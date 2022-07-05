package ExamenParcial2020;

import java.util.ArrayList;

public class Cesta {
	private String nCliente;
	private String direccion;
	private ArrayList<ProductoVendido> productosVendido;
	
	public Cesta(String nCliente, String direccion) {
		this.nCliente = nCliente;
		this.direccion = direccion;
		this.productosVendido = new ArrayList<ProductoVendido>();
	}
	
	public Cesta() {
		this.productosVendido = new ArrayList<ProductoVendido>();
	}
}
