
/*
 * programa que simula un lloro que recorda les frases que li han dit
 */
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class Recordat {
    public static void main(String[] args) throws IOException {
        String cami = "records.txt";
        processaEntrada(cami);
        System.out.println("D'acord");
        if(!esFitxerBuit(cami)) {
            mostraRecords(cami);
        }
        else {
            System.out.println("El lloro no recorda res");
        }
        System.out.println("Adéu");
    }
    //Verifica que el fitxer no sigui buit per evitar que peti al llistarlo
    public static boolean esFitxerBuit(final String nomFitxer) throws IOException {
        FileReader fileReader = new FileReader(nomFitxer);
        BufferedReader input = new BufferedReader(fileReader);
        String linia = input.readLine();
        input.close();
        if (null == linia) {
            return true;
        }
        else return false;
    }
    /**
     * Demana frases per entrada estàndard i les guarda a un fitxer
     * @param nomFitxer: nom del fitxer
     */
    public static void processaEntrada(final String nomFitxer) throws IOException {
        while(true) {
            System.out.println("El lloro pregunta paraula:");
            String paraula = Entrada.readLine();
            BufferedWriter sortida = new BufferedWriter(new FileWriter(nomFitxer, true));

            if (paraula.isEmpty() || paraula.isBlank()) {
                return;
            }
            else {
                System.out.println("El lloro registra: " + paraula);
                
                sortida.write(paraula.trim() + "\n");
                sortida.close();
            }
        }
    }

    /**
     * Mostra el contingut del fitxer amb nom nomFitxer
     * @param nomFitxer: el nom del fitxer del que es mostrarà el contingut
     */
    public static void mostraRecords(final String nomFitxer) throws IOException {
        FileReader fileReader = new FileReader(nomFitxer);
        BufferedReader input = new BufferedReader(fileReader);
        while (true) {
            String linia = input.readLine();
            if (null == linia) {
                break;
            }
            System.out.println("El lloro recorda: " + linia);
        }
        input.close();
    }

}
