package uml;

public class Ortodoncia extends LineaTratamiento{
	//Atributos
	private int numDientesAfectados;
	
	public Ortodoncia(int numDientesAfectados, String concepto) {
		super(concepto);
		this.numDientesAfectados = numDientesAfectados;
	}
	public Ortodoncia() { //Constructor por defecto
		super();
		this.numDientesAfectados = 0;
	}
}
