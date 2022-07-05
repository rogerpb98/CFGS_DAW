// Programa que mostra per pantalla les paraules d'un fitxer que
// comencin o acabin en vocal

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FitxerVocalIniciFi {

    public static void main(String[] args) throws IOException {
        String cami = "frases.txt";
        FileReader fileReader = new FileReader(cami);
        BufferedReader input = new BufferedReader(fileReader);
        while (true) {
            String linia = input.readLine();
            if (null == linia) break;
            else if ( UtilString.esVocal(linia.charAt(0)) || UtilString.esVocal(linia.charAt(linia.length()-1)) ) { 
                System.out.println(linia);
            }
        }
        input.close();
    }
    
}
