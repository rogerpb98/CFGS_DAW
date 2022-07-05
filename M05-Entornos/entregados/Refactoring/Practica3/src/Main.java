import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) throws IOException  {
		int personas=(int)pedirFloat("quanta gent: ", 1, 50);
		//Llenado del array
		float v[] = llenadoArrayDeFloats(personas);
		//printar totes les notes
		mostraEstadistiques(v);
	}
	public static void mostraEstadistiques(float[] v) {
		//Suma de todos los valores del array
		float total=suma(v);
		//calcular maximo y minimo
		float max=max(v);
		float min=min(v);
				
		System.out.println();
		for(int i=0;i<v.length;i++){
			System.out.print(v[i]+", ");
		}
		System.out.println();
		//Imprimir 
		System.out.println("Mitja: "+total/v.length);
		System.out.println("Pitjor: "+min);
		System.out.println("Millor: "+max);
	}
	public static float max(float[] v) {
		float max=v[0];
		for(int i=0;i<v.length;i++){
			float v1 = v[i];
			if(v1>max){
				max=v[i];
			}
		}
		return max;
	}
	public static float min(float[] v) {
		float min=v[0];
		for(int i=0;i<v.length;i++){
			float v1 = v[i];
			if(v1<min){
				min=v[i];
			}
		}
		return min;
	}
	public static float suma(float[] v) {
		float total=0;
		for(int i=0;i<=v.length-1;i++){
			total += v[i];
		}
		return total;
	}
	public static float pedirFloat(String pregunta, int min, int max) {
		Scanner sc = new Scanner(System.in);
		System.out.print(pregunta);
		String text = sc.next(); //demana entrada
		float quantaGent = Float.parseFloat(text); //converteix a int
		while (quantaGent>max || quantaGent<min){
			System.out.println("ERROR");
			System.out.print(pregunta);
			text = sc.next();
			quantaGent = Float.parseFloat(text);
		}
		return quantaGent;
	}
	public static float[] llenadoArrayDeFloats(int personas) {
		float arrayNotes[] = new float[personas];
		for(int i=0;i<arrayNotes.length;i++){
			arrayNotes[i]=pedirFloat("Introdueix "+(i+1)+": ", 0, 10);
			System.out.println(arrayNotes[i]);
		}
		return arrayNotes;
	}
}

