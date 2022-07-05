package uml;

public class LineaTratamiento {
	//Atributos
	protected String concepto; //Protected permite que los hijos puedan acceder
	
	//Metodos
	public float calculaImporte() {
		return 0;
	}

	//Constructores
	public LineaTratamiento(String concepto) {
		this.concepto=concepto;
	}
	public LineaTratamiento() { //Por Defecto
		this.concepto="";
	}
}
