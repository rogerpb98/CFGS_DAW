package intro00;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Problema 1 -------------------------
		/* Apartado b) ---
		Vehiculo v1 = new Vehiculo();
		//Llama al constructor por defecto implicito
		v1.setColor("amarillo");
		v1.setCaballos(180);
		v1.setMarca("Nissan");
		v1.setModelo("Primera");
		*/
		
		//Problema 2 -------------------------
		/* Apartado a) ---
		Vehiculo v1 = new Vehiculo();
		//Llama al constructor por defecto implicito
		v1.setColor("amarillo");
		v1.setCaballos(180);
		v1.setMarca("Nissan");
		v1.setModelo("Primera");
		*/
		/* Apartado c) ---
		Vehiculo v1 = new Vehiculo();
		//Llama al constructor por defecto implicito
		v1.setColor("amarillo");
		v1.setCaballos(180);
		v1.setMarca("Nissan");
		v1.setModelo("Primera");
		*/
		
		//Problema 3 -------------------------
		/* Apartado b) ---
		Vehiculo v1 = new Vehiculo();
		//Llama al constructor por defecto implicito
		v1.setColor("amarillo");
		v1.setCaballos(180);
		v1.setMarca("Nissan");
		v1.setModelo("Primera");
		*/
		
		//Problema 4 -------------------------
		/* Apartado f) ---
		Coche c1 = new Coche();
		//Llama al constructor por defecto implicito
		c1.setColor("amarillo");
		c1.setCaballos(180);
		c1.setMarca("Nissan");
		c1.setModelo("Primera");
		c1.setNumPuertas(5);
		c1.setCapacidadMaletero(200);
		
		Coche c2 = new Coche("amarillo", 180, "Nissan", "Primera", 5, 200);
		*/
		
		//Problema 5 -------------------------
		/* Apartado b) ---
		Vehiculo v1 = new Vehiculo();
		Vehiculo v2 = new Vehiculo();
		*/
		/* Apartado c) ---
		//Vehiculo v1 = new Vehiculo();
		//Vehiculo v2 = new Vehiculo();
		*/
		
		//Problema 6 -------------------------
		/* Apartado c) ---
		Coche c1 = new Coche();
		c1.numPuertas=6;
		c1.capacidadMaletero=40;
		*/
		/* Apartado d) ---
		Coche c1 = new Coche();
		System.out.print(c1.numPuertas);
		*/
		/* Apartado e) ---
		Coche c1 = new Coche();
		c1.capacidadMaletero=30;
		Coche c2 = new Coche();
		c2.capacidadMaletero=21;
		Coche c3 = new Coche();
		c3.capacidadMaletero=54;
		System.out.println(c1.capacidadMaletero);
		System.out.println(c2.capacidadMaletero);
		System.out.println(c3.capacidadMaletero);
		*/
		
		//Problema 7 -------------------------
		/* Apartado c) ---
		Coche micoche = new Coche();
		Coche.Radio laradio = micoche.new Radio();
		micoche.setRadio(laradio);;
		laradio.encender();
		*/
		
		//Problema 9 -------------------------
		/* Apartado b) ---
		Vehiculo v1 = new Coche();
		Vehiculo v2 = new Moto();
		Coche c3 = new Coche();
		Vehiculo v3 = c3;
		*/
		/* Apartado c) ---
		Producto p1 = new Coche();
		Producto p2 = new Moto();
		Coche c3 = new Coche();
		Producto p3 = c3;
		*/
		/* Apartado d) ---
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		Scanner sc = new Scanner(System.in);
		for ( int i=0; i<5; i++) {
			System.out.print("1.Moto o 2.Coche: ");
			int opcion = sc.nextInt();
			if (opcion==1) {
				Moto mimoto = new Moto();
				lista.add(mimoto);
			}
			else {
				Coche micoche = new Coche();
				lista.add(micoche);
			}
		}
		for (Vehiculo v:lista) {
			if (v instanceof Moto)
				System.out.println("Se trata de una moto");
			else
				System.out.println("Se trata de un coche");
		}
		*/
		/* Apartado e) ---
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		Scanner sc = new Scanner(System.in);
		for ( int i=0; i<5; i++) {
			System.out.print("1.Moto o 2.Coche: ");
			int opcion = sc.nextInt();
			if (opcion==1) {
				Moto mimoto = new Moto();
				lista.add(mimoto);
			}
			else {
				Coche micoche = new Coche();
				lista.add(micoche);
			}
		}
		for (Vehiculo v:lista) {
			System.out.println(v);
		}
		*/
	}
}
