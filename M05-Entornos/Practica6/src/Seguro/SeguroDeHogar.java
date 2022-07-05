package Seguro;

public class SeguroDeHogar extends Seguro {
	private String tipoVivienda;

	public SeguroDeHogar(String fechaContrato, double cuotaAnualBase, double descuentoOPrecargo, Cliente cliente,
			Poliza poliza, String tipoVivienda) {
		super(fechaContrato, cuotaAnualBase, descuentoOPrecargo, cliente, poliza);
		this.tipoVivienda = tipoVivienda;
	}
	public SeguroDeHogar() {
		super();
	}

	@Override
	public int getN() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public double getTOTIND() {
		// TODO Auto-generated method stub
		return 700;
	}

	@Override
	public int getD1() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getD2() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	
}
