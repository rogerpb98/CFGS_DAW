package intro00;

public abstract class Vehiculo {
	//Atributos de la clase
	/*
	public String color;
	public int caballos;
	public String marca;
	public String modelo;
	*/
	
	/*
	String color;
	int caballos;
	String marca;
	String modelo;
	*/
	
	
	protected String color;
	protected int caballos;
	protected String marca;
	protected String modelo;
	
	/*
	private String color;
	private int caballos;
	private String marca;
	private String modelo;
	*/
	
	abstract public void arrancar();
	
	/*
	public Vehiculo() {
		this.marca="";
		this.modelo="";
	}
	*/

	public Vehiculo(String color, int caballos, String marca, String modelo) {
		this.color = color;
		this.caballos = caballos;
		this.marca = marca;
		this.modelo = modelo;
	}
	public Vehiculo() {
		this.color = "";
		this.caballos = 0;
		this.marca = "";
		this.modelo = "";
	}
	public Vehiculo(String color, String marca,  int caballos, String modelo) {
		this.color = color;
		this.caballos = caballos;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}
	///////////////////
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	////////////////////
}
