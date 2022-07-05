package Refactoring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String args[]) throws ParseException {
		// demostració de construcció d'un vehicle de categoria BASIC
		Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);

		// demostració de construccuó d'un lloguer amb una data
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date = dateFormat.parse("2/8/2013");
		Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);

		// demostració de formatat d'una data
		System.out.println(dateFormat.format(lloguerBasic.getData()));
	}
	public static String GestorLloguersLite (Client client) {
		return client.informe();
				
		/*
		Client: «nom del client»
        «nif»
        «telèfon»
Lloguers: «num de lloguers del client»
        1. vehicle: «marca del vehícle del primer lloguer» «model»
           data d'inici: «data d'inici del lloguer»
           dies llogats: «nombre de dies llogats»
        2. «... dades de la resta de lloguers del client»
		 * */
	}
}
