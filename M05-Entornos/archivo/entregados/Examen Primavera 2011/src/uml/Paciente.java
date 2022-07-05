package uml;

import java.util.ArrayList;

public class Paciente {
	//Atributos
	private String nif;
	private String nombre;
	private String direccion;
	private ArrayList<Factura> facturas;
	
	public Paciente(String nif, String nombre, String direccion) {
		this.nif = nif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.facturas = new ArrayList<Factura>();
	}
	
	//Getters and Setters
	public Paciente() {
		this.facturas = new ArrayList<Factura>();
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
	
}
