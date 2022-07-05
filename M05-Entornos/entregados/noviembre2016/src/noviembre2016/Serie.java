package noviembre2016;

import java.util.List;
import java.util.ArrayList;

public class Serie {
	private String titulo;
	private List<Temporada> temporadas;
	/*----NO Refactoring minutos serie----*/
	public void duracionTotalSerie() {
		int duracion=0;
		for(Temporada temporada: temporadas) {
			ArrayList<Capitulo> capitulos=temporada.getCapitulos();
			for (Capitulo capitulo: capitulos) {
				duracion+=capitulo.getDuration();
			}
		}
		System.out.println("La duracion de la serie es " + duracion);
	}
	/*----SI Refactoring minutos serie----*/
	public void duracionTotalSerieRefactored() {
		int duracion=0;
		for(Temporada temporada: temporadas) {
			duracion+=temporada.getMinutosTemporada();
		}
		System.out.println("La duracion de la serie es " + duracion);
	}
	
	/*-------------------------------------*/
	public Serie(String titulo, List<Temporada> temporadas) {
		super();
		this.titulo = titulo;
		this.temporadas = temporadas;
	}
	/*public boolean addTemporada() {
		
	}*/
	public String getTitulo() {
		return titulo;
	}
	
}
