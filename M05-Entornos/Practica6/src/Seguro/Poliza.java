package Seguro;

public class Poliza {
	private String fechaDeFormalizacion;
	private Seguro seguro;
	
	public Poliza(String fechaDeFormalizacion, Seguro seguro) {
		this.fechaDeFormalizacion = fechaDeFormalizacion;
		this.seguro = seguro;
	}
	public Poliza() {}
}
