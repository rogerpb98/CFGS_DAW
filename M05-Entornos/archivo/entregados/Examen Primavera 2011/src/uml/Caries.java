package uml;

public class Caries extends LineaTratamiento{
	//Atributos
	private int numDientesAfectados;
	
	public Caries(String concepto, int numDientesAfectados) {
		super(concepto);
		this.numDientesAfectados = numDientesAfectados;
	}
	public Caries(String concepto) {
		super(concepto);
		this.numDientesAfectados = 0;
	}
	public Caries() { //Constructor por defecto
		super();
		this.numDientesAfectados = 0;
	}
	
}
