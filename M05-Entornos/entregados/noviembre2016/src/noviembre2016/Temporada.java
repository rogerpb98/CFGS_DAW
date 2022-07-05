package noviembre2016;

import java.util.ArrayList;

public class Temporada {
	private int numero;
	private Serie serie;
	private ArrayList<Capitulo> capitulos;
	//6
	public String listaCapitulos() {
		String cadena="";
		String titulo = serie.getTitulo();
		for (Capitulo cap: capitulos) {
			cadena+=(titulo + "T"  + numero + "C" + cap.getNum());
		}
		return cadena;
	}
	public Temporada() {
	}
	public Temporada(int numero, Serie serie, ArrayList<Capitulo> capitulos) {
		super();
		this.numero = numero;
		this.serie = serie;
		this.capitulos = new ArrayList<Capitulo>();
	}
	public boolean addCapitulo(Capitulo capitulo) {
		if (!capitulos.contains(capitulo)) {
			capitulos.add(capitulo);
			return true;
		}
		return false;
		
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public ArrayList<Capitulo> getCapitulos() {
		return capitulos;
	}
	public int getMinutosTemporada () {
		int duracion=0;
		for (Capitulo capitulo: capitulos) {
			duracion+=capitulo.getDuration();
		}
		return duracion;
	}
}
