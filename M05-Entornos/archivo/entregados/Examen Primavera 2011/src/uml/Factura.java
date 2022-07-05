package uml;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	//Atributos
	private int numero;
	private String descripcion;
	private Date fecha; //Hay que importar desde java.util
	private Paciente paciente;
	private ArrayList<LineaTratamiento> lineas; //Hay que importar desde java.util
	
	public Factura(int numero, String descripcion, Date fecha, Paciente paciente) {
		this.numero = numero;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.paciente = paciente;
		this.lineas = new ArrayList<LineaTratamiento>();
	}
	
	public Factura() {
		this.numero = 0;
		this.descripcion = "";
		this.fecha = null;
		this.paciente = null;
		this.lineas = new ArrayList<LineaTratamiento>();
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", descripcion=" + descripcion + ", fecha=" + fecha + ", paciente=" + paciente + "]";
	}
	
	//Metodos
	public float calculaImporteFactura() {
		float coste = 0;
		for (LineaTratamiento lineat:lineas) {
			coste=coste + lineat.calculaImporte();
		}
		return coste;
	}
}
