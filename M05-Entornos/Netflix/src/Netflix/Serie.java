package Netflix;

import java.util.ArrayList;
import java.util.List;

public class Serie {
	private String titulo;
	private List<Temporada> temporadas;
	
	public Serie(String titulo, List<Temporada> temporadas) {
		this.titulo = titulo;
		this.temporadas = temporadas;
	}
	public Serie(String titulo) {
		this.titulo = titulo;
		this.temporadas = new ArrayList<Temporada>();
	}
	public Serie() {
		this.temporadas = new ArrayList<Temporada>();
	}
	public void addTemporada(Temporada temporada) {
		temporadas.add(temporada);
		temporada.setSerie(this);
	}
	
	
}
