package colecciones;

public class Producto {
	private int code;
	private double precioEuros;
	private String nombre;
	
	//constructor por defecto
	public Producto () {
	}

	//Constructor full 3 parametros
	public Producto(int code, double precioEuros, String nombre) {
		super();
		this.code = code;
		this.precioEuros = precioEuros;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Producto [code=" + code + ", precioEuros=" + precioEuros + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precioEuros);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (code != other.code)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precioEuros) != Double.doubleToLongBits(other.precioEuros))
			return false;
		return true;
	}
	
	
}
