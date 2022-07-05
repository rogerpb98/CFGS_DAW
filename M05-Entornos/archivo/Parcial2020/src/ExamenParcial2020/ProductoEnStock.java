package ExamenParcial2020;

public class ProductoEnStock extends Producto{
	private int unidadesEnStock;

	public ProductoEnStock(String id, String nombre, String fabricante, double precioUnidadEu, int unidadesEnStock) {
		super(id, nombre, fabricante, precioUnidadEu);
		this.unidadesEnStock = unidadesEnStock;
	}
	
}
