package Practica5;

import java.util.ArrayList;

public class Lineas {
	private int numero;
	private ArrayList<Parada> paradas;
	private ArrayList<Tramo> tramos;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public ArrayList<Parada> getParadas() {
		return paradas;
	}
	public void setParadas(ArrayList<Parada> paradas) {
		this.paradas = paradas;
	}
	public ArrayList<Tramo> getTramos() {
		return tramos;
	}
	public void setTramos(ArrayList<Tramo> tramos) {
		this.tramos = tramos;
	}
	public Parada getParada (String nombre) {
		for (Parada parada: paradas)
			if (parada.getNombre().equals(nombre))
				return parada;
		return null;
	}
	public Tramo getTramo(String nombreP1, String nombreP2) {
		for (Tramo tramo: tramos)
			//Si el tramo contiene las 2 paradas recibidas por argumento las retorna, sino null
			if (tramo.getParadas().contains(getParada(nombreP1)) && tramo.getParadas().contains(getParada(nombreP2)))
				return tramo;
		return null;
	}
	@Override
	public String toString() {
		return 	"Linea: " + numero + "\n"+
				"Recorrido: " + paradas;
	}
	
}
