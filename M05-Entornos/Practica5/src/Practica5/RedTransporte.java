package Practica5;

import java.util.ArrayList;

public class RedTransporte {
	private String nombre;
	private ArrayList<Lineas> lineas;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Lineas> getLineas() {
		return lineas;
	}
	public void setLineas(ArrayList<Lineas> lineas) {
		this.lineas = lineas;
	}
}
