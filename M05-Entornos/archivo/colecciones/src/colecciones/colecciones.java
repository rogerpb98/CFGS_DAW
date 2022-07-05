package colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class colecciones {
	
	public static void main(String[] args) {
		/**********************************EJERCICIO 1***********************************
		String[] fruits = new String[] {"Pineapple", "Apple", "Orange", "Banana"};
		
		Arrays.sort(fruits);
		for (String temp: fruits) { //Recorre tots els elements de fruits
			System.out.println(temp);
		}
		
		for (int i=0; i<fruits.length; i++) { //recorrer fruits de manera tradicional
			System.out.println(fruits[i]);
		}
		
		
		String[] fruits = new String[5];
		fruits[0] = "Pineapple";
		fruits[1] = "Apple";
		fruits[2] = "Orange";
		fruits[3] = "Banana";
		fruits[4] = "";
		
		Arrays.sort(fruits);
		for (String temp: fruits) { //Recorre tots els elements de fruits
			System.out.println(temp);
		}
		********************************************************************************/
		
		/**********************************EJERCICIO 2***********************************
		int[] numeros = new int[] {40,20,50,70,10,};
		Arrays.sort(numeros);
		for (int temp: numeros) { //Recorre tots els elements de numeros
			System.out.println(temp);
		}
		
		int[] numeros = new int[6];
		numeros[0] = 40;
		numeros[1] = 20;
		numeros[2] = 50;
		numeros[3] = 70;
		numeros[4] = 10;
		
		Arrays.sort(numeros);
		for (int temp: numeros) { //Recorre tots els elements de numeros
			System.out.println(temp);
		}
		
		********************************************************************************/
		
		/**********************************EJERCICIO 3***********************************
		Object mio = new Object();
		//mio.equals(); --> Para comparar si se trata del mismo objeto
		//mio.toString(); --> Devuelve un string explicando los elementos de la clase
		//mio.hashCode(); --> Devuelve un numero hash para comparar el estado con otro objeto
		
		//mio.notify(); --> Para threads
		//mio.notifyAll(); --> Para threads
		//mio.getClass(); --> Devuelve la clase a la que pertenece el objeto
		//mio.wait(); --> Para threads
		********************************************************************************/
		
		/**********************************EJERCICIO 4***********************************
		Habitacion []habitacionesArray = {
				new Habitacion("James",20),
				new Habitacion("Mary",10),
				new Habitacion("John",80),
				new Habitacion("Amanda",40),
				new Habitacion("Charles",30) 
				};
		Arrays.sort(habitacionesArray);
		for (Habitacion temp: habitacionesArray) {
			System.out.println(temp);
		}
		
		Arrays.sort(habitacionesArray, new Comparator<Habitacion>() {
			@Override
			public int compare(Habitacion first, Habitacion second) {
				return first.getId() - second.getId();
			}
		});
		
		for (Habitacion temp: habitacionesArray) {
			System.out.println(temp);
		}
		********************************************************************************/
		
		
		// Ejercicio 5 - ArrayList
		
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		
		lista.add(new Habitacion("James",20));
		lista.add(new Habitacion("Mary",10));
		lista.add(new Habitacion("John",80));
		lista.add(new Habitacion("Charles",30));
		lista.add(new Habitacion("Amanda",40));
		lista.add(new Habitacion("Charles",30));
		Collections.sort(lista);
		for (Habitacion temp: lista) {
			System.out.println(temp);
		}
	}
}
