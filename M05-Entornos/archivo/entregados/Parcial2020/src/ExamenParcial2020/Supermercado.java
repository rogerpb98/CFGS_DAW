package ExamenParcial2020;

import java.util.ArrayList;

public class Supermercado {
	private Almacen almacen;
	private ArrayList<Seccion> secciones;
	private ArrayList<Cesta> cestas;
	
	public Supermercado(Almacen almacen) {
		this.almacen = almacen;
		this.secciones = new ArrayList<Seccion>();
		this.cestas = new ArrayList<Cesta>();
	}
	
}
