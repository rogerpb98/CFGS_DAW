package Practica5;

import java.util.ArrayList;

public class Ruta {
	private int tRecorrido;
	private ArrayList<Parada> paradas;
	public int gettRecorrido() {
		return tRecorrido;
	}
	public void settRecorrido(int tRecorrido) {
		this.tRecorrido = tRecorrido;
	}
	public ArrayList<Parada> getParadas() {
		return paradas;
	}
	public void setParadas(ArrayList<Parada> paradas) {
		this.paradas = paradas;
	}
}
