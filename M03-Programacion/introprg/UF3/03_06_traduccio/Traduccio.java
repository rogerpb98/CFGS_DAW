
/*
 * programa que tradueix certes paraules amb les traduccions que tenim a un fitxer
 */
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class Traduccio {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("ERROR: Cal especificar els fitxers origen, traduccio i destinació");
            return;
        }
        String pathOrigen = args[0];
        String pathTraduccio = args[1];
        String pathDesti = args[2];

        tradueix(pathOrigen, pathTraduccio, pathDesti);
    }

    public static void tradueix(String fitxerOrigen, String fitxerTraduccio, String fitxerDestinacio) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(fitxerOrigen)); //llegir origen
        BufferedWriter sortida = new BufferedWriter(new FileWriter(fitxerDestinacio)); //escriure destí

        while(true) {
            String linia = input.readLine(); //llegir linia
            if (null == linia) break;
            sortida.write(tradueixLinia(linia, fitxerTraduccio) + "\n");   //copiar linia al fitxer
        }
        input.close();
        sortida.close();
    }

    public static String tradueixLinia(String linia, String fitxerTraduccio) throws IOException {
        FileReader fileReader = new FileReader(fitxerTraduccio);
        BufferedReader input = new BufferedReader(fileReader);      // obrir
        while (true) {
            String liniaTraduccio = input.readLine();                        // llegir
            if (null == liniaTraduccio) break;
            String[] elements = liniaTraduccio.split(", ");
            //utilitzem el replace per buscar coincidencies i reemplaçarles amb la traduccio
            linia = linia.replace(elements[0], elements[1]);
        }
        input.close();
        
        return linia;
    }
}
