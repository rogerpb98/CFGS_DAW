package colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class colecciones {
	
	public static void main(String[] args) {
		// Problema 1 --------------------------------
		/* Apartado a) ---
		String[] fruits = new String[] {"Pineapple", "Apple", "Orange", "Banana"};
		*/
		/* Apartado b) ---
		String[] fruits = new String[] {"Pineapple", "Apple", "Orange", "Banana"};
		Arrays.sort(fruits);
		for (String temp: fruits) { //Recorre tots els elements de fruits
			System.out.println(temp);
		}
		for (int i=0; i<fruits.length; i++) { //recorrer fruits de manera tradicional
			System.out.println(fruits[i]);
		}
		*/
		/* Apartado e) ---
		String[] fruits = new String[] {"Pineapple","Apple","Orange","Banana"};
		Arrays.sort(fruits);
		for (String temp: fruits) { //Recorre tots els elements de fruits
			System.out.println(temp);
		}
		*/
		/* Apartado f) ---
		String[] fruits = new String[5];
		fruits[0] = "Pineapple";
		fruits[1] = "Apple";
		fruits[2] = "Orange";
		fruits[3] = "Banana";
		*/
		/* Apartado f) ---
		String[] fruits = new String[5];
		fruits[0] = "Pineapple";
		fruits[1] = "Apple";
		fruits[2] = "Orange";
		fruits[3] = "Banana";
		
		Arrays.sort(fruits);
		for (String temp: fruits) { //Recorre tots els elements de fruits
			System.out.println(temp);
		}
		*/
		/* Apartado h) ---
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
		*/
		
		// Problema 2 --------------------------------
		/* Apartado a) ---
		int[] numeros = new int[] {40,20,50,70,10,};
		*/
		/* Apartado b) ---
		int[] numeros = new int[] {40,20,50,70,10,};
		Arrays.sort(numeros);
		for (int temp: numeros) { //Recorre tots els elements de numeros
			System.out.println(temp);
		}
		*/
		
		// Problema 3 --------------------------------
		/*
		Object mio = new Object();
		//mio.equals(); --> Para comparar si se trata del mismo objeto
		//mio.toString(); --> Devuelve un string explicando los elementos de la clase
		//mio.hashCode(); --> Devuelve un numero hash para comparar el estado con otro objeto
		
		//mio.notify(); --> Para threads
		//mio.notifyAll(); --> Para threads
		//mio.getClass(); --> Devuelve la clase a la que pertenece el objeto
		//mio.wait(); --> Para threads
		*/
		
		// Problema 4 --------------------------------
		/* Apartado b) ---
		Habitacion []habitacionesArray = {
				new Habitacion("James",20),
				new Habitacion("Mary",10),
				new Habitacion("John",80),
				new Habitacion("Amanda",40),
				new Habitacion("Charles",30) 
				};
		*/
		/* Apartado c) ---
		Habitacion []habitacionesArray = {
				new Habitacion("James",20),
				new Habitacion("Mary",10),
				new Habitacion("John",80),
				new Habitacion("Amanda",40),
				new Habitacion("Charles",30) 
				};
		for ( int i=0; i<habitacionesArray.length; i++) {
			System.out.println(habitacionesArray[i]);
		}
		for (Habitacion temp: habitacionesArray) {
			System.out.println(temp);
		}
		*/
		/* Apartado c) ---
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
		*/
		/* Apartado h) ---
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
		*/
		/* Apartado j) ---
		Habitacion []habitacionesArray = {
				new Habitacion("James",20),
				new Habitacion("Mary",10),
				new Habitacion("John",80),
				new Habitacion("Amanda",40),
				new Habitacion("Charles",30) 
				};
				
		Arrays.sort(habitacionesArray, new Comparator<Habitacion>() {
			@Override
			public int compare(Habitacion first, Habitacion second) {
				return first.getId() - second.getId();
			}
		});
		
		for (Habitacion temp: habitacionesArray) {
			System.out.println(temp);
		}
		*/
		
		// Problema 5 --------------------------------
		/* Apartado a) ---
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		*/
		
		/* Apartado b) ---
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		
		lista.add(new Habitacion("James",20));
		lista.add(new Habitacion("Mary",10));
		lista.add(new Habitacion("John",80));
		lista.add(new Habitacion("Charles",30));
		lista.add(new Habitacion("Amanda",40));
		*/
		/* Apartado c) ---
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		
		lista.add(new Habitacion("James",20));
		lista.add(new Habitacion("Mary",10));
		lista.add(new Habitacion("John",80));
		lista.add(new Habitacion("Charles",30));
		lista.add(new Habitacion("Amanda",40));
		
		for (int i=0; i<lista.size(); i++)
			System.out.println(lista.get(i));
		for (Habitacion temp: lista)
			System.out.println(temp);
			
		System.out.println(lista);
		*/
		/* Apartado d) ---
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		
		lista.add(new Habitacion("James",20));
		lista.add(new Habitacion("Mary",10));
		lista.add(new Habitacion("John",80));
		lista.add(new Habitacion("Charles",30));
		lista.add(new Habitacion("Amanda",40));
		
		lista.remove(3);
		
		for (Habitacion temp: lista)
			System.out.println(temp);
			
		System.out.println(lista);
		*/
		/* Apartado e) ---
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		
		lista.add(new Habitacion("James",20));
		lista.add(new Habitacion("Mary",10));
		lista.add(new Habitacion("John",80));
		lista.add(new Habitacion("Charles",30));
		lista.add(new Habitacion("Amanda",40));
		
		//lista.remove(3);
		lista.remove(new Habitacion("Charles",30));
		
		for (Habitacion temp: lista)
			System.out.println(temp);
			
		System.out.println(lista);
		*/
		/* Apartado g) ---
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		
		lista.add(new Habitacion("James",20));
		lista.add(new Habitacion("Mary",10));
		lista.add(new Habitacion("John",80));
		lista.add(new Habitacion("Charles",30));
		lista.add(new Habitacion("Amanda",40));
		
		lista.remove(new Habitacion("Charles",30));
		
		for (int i=0; i<lista.size(); i++)
			System.out.println(lista.get(i));
			
		System.out.println(lista);
		*/
		/* Apartado h) ---
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		
		lista.add(new Habitacion("James",20));
		lista.add(new Habitacion("Mary",10));
		lista.add(new Habitacion("John",80));
		lista.add(new Habitacion("Charles",30));
		lista.add(new Habitacion("Amanda",40));
		
		System.out.println(lista.contains(new Habitacion("Amanda",40)));
		*/
		/* Apartado i) ---
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		
		lista.add(new Habitacion("James",20));
		lista.add(new Habitacion("Mary",10));
		lista.add(new Habitacion("John",80));
		lista.add(new Habitacion("Charles",30));
		lista.add(new Habitacion("Amanda",40));
		
		Collections.sort(lista);
		for (Habitacion temp: lista) {
			System.out.println(temp);
		}
		*/
		/* Apartado j) ---
		ArrayList <Habitacion> lista = new ArrayList<Habitacion>();
		
		lista.add(new Habitacion("James",20));
		lista.add(new Habitacion("Mary",10));
		lista.add(new Habitacion("John",80));
		lista.add(new Habitacion("Charles",30));
		lista.add(new Habitacion("Amanda",40));
		
		Collections.sort(lista, new Comparator<Habitacion>()) {
			@Override
			public int compare(Habitacion first, Habitacion second) {
				//return first.getId() - second.getId();
				return first.getName().compareTo(second.getName());
			}
		});
		for (Habitacion temp: lista) {
			System.out.println(temp);
		}
		*/
		
		// Problema 6 --------------------------------
		/* Apartado b) ---
		List<Producto>productos = new ArrayList <Producto>();
		Producto p1 = new Producto(468, 20, "Leche");
		productos.add(p1);
		Producto p2 = new Producto(345, 35, "Patatas");
		productos.add(p2);
		productos.add(new Producto(239, 30, "Cereales"));
		productos.add(new Producto(293, 24, "Chocolate"));
		productos.add(new Producto(239, 43, "Pastel"));
		productos.add(p1);
		productos.add(p2);
		for(Producto temp: productos) {
			System.out.println(temp);
		}
		*/
		/* Apartado c) ---
		Set <Producto> productosh = new HashSet <Producto> ();
		Producto p1 = new Producto(468, 20, "Leche");
		productosh.add(p1);
		Producto p2 = new Producto(345, 35, "Patatas");
		productosh.add(p2);
		productosh.add(new Producto(239, 30, "Cereales"));
		productosh.add(new Producto(293, 24, "Chocolate"));
		productosh.add(new Producto(239, 43, "Pastel"));
		productosh.add(p1);
		productosh.add(p2);
		for(Producto temp: productosh) {
			System.out.println(temp);
		}
		*/
		/* Apartado d) ---
		Set <Producto> productosh = new HashSet <Producto> ();
		productosh.add(new Producto(468, 20, "Leche"));
		productosh.add(new Producto(345, 35, "Patatas"));
		productosh.add(new Producto(239, 30, "Cereales"));
		productosh.add(new Producto(293, 24, "Chocolate"));
		productosh.add(new Producto(239, 43, "Pastel"));
		productosh.add(new Producto(468, 20, "Leche"));
		productosh.add(new Producto(345, 35, "Patatas"));
		for(Producto temp: productosh) {
			System.out.println(temp);
		}
		*/
		/* Apartado e) ---
		Set <Producto> productosh = new HashSet <Producto> ();
		productosh.add(new Producto(468, 20, "Leche"));
		productosh.add(new Producto(345, 35, "Patatas"));
		productosh.add(new Producto(239, 30, "Cereales"));
		productosh.add(new Producto(293, 24, "Chocolate"));
		productosh.add(new Producto(239, 43, "Pastel"));
		productosh.add(new Producto(468, 20, "Leche"));
		productosh.add(new Producto(345, 35, "Patatas"));
		for(Producto temp: productosh) {
			System.out.println(temp);
		}
		*/
		
		// Problema 7 --------------------------------
		/* Apartado a) ---
		HashMap<String, Habitacion> habitacionesHash = new HashMap<String, Habitacion>();
		habitacionesHash.put("80", new Habitacion("James",20));
		habitacionesHash.put("10", new Habitacion("Mary",10));
		habitacionesHash.put("40", new Habitacion("John",80));
		habitacionesHash.put("20", new Habitacion("Amanda",40));
		habitacionesHash.put("30", new Habitacion("Charles",30));

		for (Map.Entry<String,Habitacion> entry: habitacionesHash.entrySet()) {
			String key = entry.getKey();
			Habitacion value = entry.getValue();
			System.out.println(key +" - "+value);
		}
		*/
		/* Apartado b) ---
		HashMap<Integer, Habitacion> habitacionesHash = new HashMap<Integer, Habitacion>();
		habitacionesHash.put(80, new Habitacion("James",20));
		habitacionesHash.put(10, new Habitacion("Mary",10));
		habitacionesHash.put(40, new Habitacion("John",80));
		habitacionesHash.put(20, new Habitacion("Amanda",40));
		habitacionesHash.put(30, new Habitacion("Charles",30));

		for (Map.Entry<Integer,Habitacion> entry: habitacionesHash.entrySet()) {
			Integer key = entry.getKey();
			Habitacion value = entry.getValue();
			System.out.println(key +" - "+value);
		}
		*/
		/* Apartado c) ---
		HashMap<String, Habitacion> habitacionesHash = new HashMap<String, Habitacion>();
		habitacionesHash.put("80", new Habitacion("James",20));
		habitacionesHash.put("10", new Habitacion("Mary",10));
		habitacionesHash.put("40", new Habitacion("John",80));
		habitacionesHash.put("20", new Habitacion("Amanda",40));
		habitacionesHash.put("30", new Habitacion("Charles",30));
		
		SortedSet<String> keys = new TreeSet<>(habitacionesHash.keySet());
		for (String key : keys) {
			Habitacion value = habitacionesHash.get(key);
			System.out.println(key +" - "+value);
		}
		*/
		/* Apartado d) ---
		HashMap<String, Habitacion> habitacionesHash = new HashMap<String, Habitacion>();
		habitacionesHash.put("80", new Habitacion("James",20));
		habitacionesHash.put("10", new Habitacion("Mary",10));
		habitacionesHash.put("40", new Habitacion("John",80));
		habitacionesHash.put("20", new Habitacion("Amanda",40));
		habitacionesHash.put("30", new Habitacion("Charles",30));
		
		TreeMap treeMap = new TreeMap<String, Habitacion>(habitacionesHash);
		Iterator it = treeMap.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next(); 
			String key = (String) entry.getKey();
			Habitacion value = (Habitacion) entry.getValue();
			System.out.println(key +" - "+value);
		}
		*/
		/* Apartado e) ---
		HashMap<String, Habitacion> habitacionesHash = new HashMap<String, Habitacion>();
		habitacionesHash.put("80", new Habitacion("James",20));
		habitacionesHash.put("10", new Habitacion("Mary",10));
		habitacionesHash.put("40", new Habitacion("John",80));
		habitacionesHash.put("20", new Habitacion("Amanda",40));
		habitacionesHash.put("30", new Habitacion("Charles",30));
		
		habitacionesHash=sortedMapByInteger(habitacionesHash);
		
		for (Map.Entry<String, Habitacion> entry : habitacionesHash.entrySet()) {
			String key = entry.getKey();
			Habitacion value = entry.getValue();
			System.out.println(key +" - "+value);
		}
		*/
		/* Apartado f) ---
		HashMap<String, Habitacion> habitacionesHash = new HashMap<String, Habitacion>();
		habitacionesHash.put("80", new Habitacion("James",20));
		habitacionesHash.put("10", new Habitacion("Mary",10));
		habitacionesHash.put("40", new Habitacion("John",80));
		habitacionesHash.put("20", new Habitacion("Amanda",40));
		habitacionesHash.put("30", new Habitacion("Charles",30));
		
		habitacionesHash=sortedMapByString(habitacionesHash);
		
		for (Map.Entry<String, Habitacion> entry : habitacionesHash.entrySet()) {
			String key = entry.getKey();
			Habitacion value = entry.getValue();
			System.out.println(key +" - "+value);
		}
		*/
	}
	//7.e
	private static HashMap<String, Habitacion> sortedMapByInteger( HashMap<String, Habitacion> unsorted){ 
		List<Entry<String, Habitacion>> list = new LinkedList<Entry<String, Habitacion>>(unsorted.entrySet()); 
		Collections.sort(list, new Comparator<Entry<String, Habitacion>>() {
		    @Override
		    public int compare(Entry<String, Habitacion> t, Entry<String, Habitacion> t1) {
				return t.getValue().getId()-t1.getValue().getId();
			}
		});
		HashMap<String, Habitacion> sorted = new LinkedHashMap<String, Habitacion>(); 
		for (Entry<String, Habitacion> item:list) {
		    sorted.put(item.getKey(), item.getValue());
		}
		return sorted;
	}
	//7.f
	private static HashMap<String, Habitacion> sortedMapByString( HashMap<String, Habitacion> unsorted){ 
		List<Entry<String, Habitacion>> list = new LinkedList<Entry<String, Habitacion>>(unsorted.entrySet()); 
		Collections.sort(list, new Comparator<Entry<String, Habitacion>>() {
		    @Override
		    public int compare(Entry<String, Habitacion> t, Entry<String, Habitacion> t1) {
				return t.getValue().getId()-t1.getValue().getId();
			}
		});
		HashMap<String, Habitacion> sorted = new LinkedHashMap<String, Habitacion>(); 
		for (Entry<String, Habitacion> item:list) {
		    sorted.put(item.getKey(), item.getValue());
		}
		return sorted;
	}
}
