package noviembre2016;

import java.util.ArrayList;

public class Capitulo {
	protected int duration;
	public final int DURATION=45;
	protected int num;
	protected Temporada temporada;
	protected ArrayList<Personaje> personajes;
	
	public Capitulo() {}
	
	public Capitulo(int num, Temporada temporada) {
		this.num = num;
		this.temporada = temporada;
	}
	public String listaPersonajes() {
		String cadena = "";
		for (Personaje per: personajes) {
			cadena+=per;
		}
		return cadena;
	}

	@Override
	public String toString() {
		return "Capitulo [duration=" + duration + ", DURATION=" + DURATION + ", num=" + num + ", temporada=" + temporada
				+ ", personajes=" + personajes + "]\n";
	}

	public int getNum() {
		return num;
	}

	public int getDuration() {
		return duration;
	}

	public int getDURATION() {
		return DURATION;
	}
	
}
