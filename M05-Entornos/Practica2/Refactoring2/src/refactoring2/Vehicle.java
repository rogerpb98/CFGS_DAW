package refactoring2;

public class Vehicle {
	public static final String BASIC = "BASIC";
	public static final String GENERAL = "GENERAL";
	public static final String LUXE = "LUXE";
	private String marca;
	private String model;
	private String categoria;
	
	public Vehicle(String marca, String model, String categoria) {
		this.marca=marca;
		this.model=model;
		this.categoria=categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getMarca() {
		return marca;
	}

	public String getModel() {
		return model;
	}
	
}
