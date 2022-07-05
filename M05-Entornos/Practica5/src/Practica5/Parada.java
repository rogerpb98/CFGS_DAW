package Practica5;

public class Parada {
	private String nombre;
	private Tramo tramo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tramo getTramo() {
		return tramo;
	}
	public void setTramo(Tramo tramo) {
		this.tramo = tramo;
	}
	@Override
	public String toString() {
		return nombre+" <-> "+tramo.getTiempo()+" segundos <->";
	}
	
}
