package intro00;

public class Coche extends Vehiculo implements Producto {
	//Atributos propios de coche
	
	public final int numPuertas;
	public static int capacidadMaletero;
	public Radio radio;
		
	@Override
	public String toString() {
		return "Coche [numPuertas=" + numPuertas + ", radio=" + radio + "]";
	}

	public float getPrecio() {
		return 0;
	}
	
	public String getDescripcion() {
		return "";
	}
	
	public class Radio {
		boolean encendido;
		int frecuencia=100;
		public void encender() {}
		public void apagar() {}
	}
	
	/*
	private int numPuertas;
	private int capacidadMaletero;
	*/
	
	//Constructores
	
	public Coche() {
		super();
		this.numPuertas = 4;
		this.capacidadMaletero = 200;
		this.radio = new Radio();
	}
	
	public void setRadio(Radio radio) {
		this.radio = radio;
	}
	
	public Coche(String color, int caballos, String marca, String modelo, int numPuertas, int capacidadMaletero) {
		super(color, caballos, marca, modelo);
		this.numPuertas = numPuertas;
		this.capacidadMaletero = capacidadMaletero;
	}
	
	/*
	public Coche() {
		this.color = "";
		this.caballos = 0;
		this.marca = "";
		this.modelo = "";
		this.numPuertas = 0;
		this.capacidadMaletero = 0;
	}
	*/

	//Getters and Setters
	public int getNumPuertas() {
		return numPuertas;
	}
	/*
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	*/
	public int getCapacidadMaletero() {
		return capacidadMaletero;
	}
	public void setCapacidadMaletero(int capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
