package Practica5;

import java.util.ArrayList;

public class Tramo {
	private int tiempo;
	private ArrayList<Parada> paradas;
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public ArrayList<Parada> getParadas() {
		return paradas;
	}
	public void setParadas(ArrayList<Parada> paradas) {
		this.paradas = paradas;
	}
}
