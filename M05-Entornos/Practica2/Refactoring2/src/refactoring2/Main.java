package refactoring2;

	import java.io.IOException;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	public class Main {
		public static void main(String args[]) throws ParseException, IOException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			
			Vehicle vehicle1 = new Vehicle("Tata", "Vista", Vehicle.BASIC);
			Date date = dateFormat.parse("2/8/2013");
			Lloguer lloguer1 = new Lloguer(date, 2, vehicle1);
			
			Vehicle vehicle2 = new Vehicle("Citroen", "Saxo", Vehicle.GENERAL);
			date = dateFormat.parse("2/8/2015");
			Lloguer lloguer2 = new Lloguer(date, 5, vehicle2);
			
			Vehicle vehicle3 = new Vehicle("Tesla", "Roaster", Vehicle.LUXE);
			date = dateFormat.parse("2/8/2018");
			Lloguer lloguer3 = new Lloguer(date, 5, vehicle3);
			
			Client micliente = new Client("83748375I","Antonio","647263819");
			micliente.afegeix(lloguer1);
			micliente.afegeix(lloguer2);
			micliente.afegeix(lloguer3);
			
			System.out.println(GestorLloguersLite(micliente));
		}
		public static String GestorLloguersLite (Client client) throws IOException {
			client.informeHTML();
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