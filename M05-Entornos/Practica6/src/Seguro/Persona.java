package Seguro;

public class Persona extends Cliente {
	private String nombre;
	private String apellidos;
	public Persona(String nif, String direccio, String telefono, String clienteDesde, String nombre, String apellidos) {
		super(nif, direccio, telefono, clienteDesde);
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public Persona() {
		super();
	}
}
