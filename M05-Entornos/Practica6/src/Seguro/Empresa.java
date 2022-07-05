package Seguro;

public class Empresa extends Cliente {
	private String nombreComercial;

	public Empresa(String nif, String direccio, String telefono, String clienteDesde, String nombreComercial) {
		super(nif, direccio, telefono, clienteDesde);
		this.nombreComercial = nombreComercial;
	}
	public Empresa() {
		super();
	}
}
