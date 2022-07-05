package Netflix;

import java.util.List;

public class Temporada {
	private int numero;
	private List<Capitulo> capitulos;
	private Serie serie;
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	public boolean addCapitulo(Capitulo capitulo) {
		capitulos.add(capitulo);
		capitulo.setTemporada(this);
		return true;
	}
	public String listaCapitulos() {
		String pepe="";
		for (Capitulo cap: capitulos) {
			pepe += cap+"\n";
		}
		return pepe;
	}
}
