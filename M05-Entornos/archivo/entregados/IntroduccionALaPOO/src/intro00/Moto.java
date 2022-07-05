package intro00;

public class Moto extends Vehiculo implements Producto {
	private int xx;
	private int yy;
	
	@Override
	public String toString() {
		return "Moto [xx=" + xx + ", yy=" + yy + "]";
	}

	public float getPrecio() {
		return 0;
	}
	
	public String getDescripcion() {
		return null;
	}
	
	public void arrancar() {
		
	}
}
