package pelota;

public class Main {

	public static void main(String[] args) {
		//Caso de uso 1
		/*
		Pelota p1, p2;
		p1 = new Pelota("Maradona");
		p2 = new Pelota("Romario");
		p1.inflar(10);
		p1.inflar(10);
		p1.inflar(5);
		p1.inflar(5);
		System.out.println(p1.botar());
		System.out.println(p2.botar());
		p1.desinflar(5);
		p2.desinflar(16);
		System.out.println();
		System.out.println("Un rato más tarde...");
		System.out.println(p1.botar());
		System.out.println(p2.botar());
		*/
		
		//Caso de uso 2
		Pelota p1, p2, p3;
		p1 = new Pelota("Maradona");
		p2 = new Pelota("Romario");
		p3 = p1;
		p1.inflar(10);
		p2.inflar(10);
		p3.inflar(10);
		System.out.println(p1.botar());
		System.out.println(p2.botar());
		System.out.println(p3.botar());
	}

}
