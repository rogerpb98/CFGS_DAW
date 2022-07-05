package uml;

import java.util.ArrayList;

public class RegistroPacientes {
	//Atributos
	private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	
	public RegistroPacientes() {
		this.pacientes=new ArrayList<Paciente>();
	}
	
	//Metodos
	public float importeFacturas(String nif) { // Sin refactoring
		float coste=0;
		for (Paciente p: pacientes) { // Recorro todos los pacientes
			if (p.getNif().contentEquals(nif)) { //Para el cliente con el nif
				ArrayList<Factura> facturas = p.getFacturas(); 
				for (Factura f: facturas) { 
					coste = coste + f.calculaImporteFactura(); 
				}
				break;
			}
		}
		return coste;
	}
}
