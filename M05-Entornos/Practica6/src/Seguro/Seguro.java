package Seguro;

import java.util.ArrayList;

public abstract class Seguro {
	protected String fechaContrato;
	protected double cuotaAnualBase;
	protected double descuentoORecargo;
	protected Cliente cliente;
	protected Poliza poliza;
	protected ArrayList<Parte> partes= new ArrayList<Parte>();
	public Seguro(String fechaContrato, double cuotaAnualBase, double descuentoORecargo, Cliente cliente,
			Poliza poliza) {
		this.fechaContrato = fechaContrato;
		this.cuotaAnualBase = cuotaAnualBase;
		this.descuentoORecargo = descuentoORecargo;
		this.cliente = cliente;
		this.poliza = poliza;
		//this.partes = new ArrayList<Parte>();
	}
	public Seguro() {
		//this.partes = new ArrayList<Parte>();
	}
	public abstract int getN();
	public abstract double getTOTIND();
	public abstract int getD1();
	public abstract int getD2();
	
	//Ej2
	public String listaPartesEntreFechas(String fechaInicio, String fechaFinal) {
		String res="";
		for (Parte parte: partes) {
			// if fechaInicio < fechaConcreta < fechaFinal;
			if (Fecha.compareTo(fechaInicio,parte.getFecha())==-1 && Fecha.compareTo(fechaFinal, parte.getFecha())==1)
				res+=parte; //--> declarar tostring de parte
		}
		return res;
	}
	//Ej3
	public int numPartesEnAnyo (int anyo) {
		int res=0;
		for (Parte parte: partes) {
			// if fechaInicio < fechaConcreta < fechaFinal;
			if (Fecha.getAnyoDeFecha(parte.getFecha())==anyo)
				res++; //--> declarar tostring de parte
		}
		return res;
	}
	public double costeIncidenciasEnAnyo (int anyo) {
		double res=0;
		for (Parte parte: partes) {
			// if fechaInicio < fechaConcreta < fechaFinal;
			if (Fecha.getAnyoDeFecha(parte.getFecha())==anyo)
				res+=parte.getCoste(); //--> declarar tostring de parte
		}
		return res;
	}
	//Ej4
	public void actualizarDescuentoRecargo() {
		int anyo=Fecha.getAnyoDeFecha(Fecha.getFechaDeHoy())-1;
		if (numPartesEnAnyo(anyo)==getN()
				|| costeIncidenciasEnAnyo(anyo)>getTOTIND()) {
			descuentoORecargo += getD1();
		}
		else if (numPartesEnAnyo(anyo)==0 ) {
			descuentoORecargo -= getD2();
		}
		if (descuentoORecargo > 25)
			descuentoORecargo = 25;
		if (descuentoORecargo < -15)
			descuentoORecargo = -15;
	}
}
