package ExamenParcial2020;

public class ProductoVendido extends Producto{
	private int unidadesVendidas;

	public ProductoVendido(String id, String nombre, String fabricante, double precioUnidadEu, int unidadesVendidas) {
		super(id, nombre, fabricante, precioUnidadEu);
		this.unidadesVendidas = unidadesVendidas;
	}
	
}
