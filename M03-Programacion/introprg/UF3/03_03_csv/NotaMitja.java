/*Programa que llegeix un arxiu csv i et calcula la nota mitja
 *de cada alumne
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NotaMitja {
    public static void main(String[] args) throws IOException {

        String cami = "notes.csv";
        FileReader fileReader = new FileReader(cami);
        BufferedReader input = new BufferedReader(fileReader);      // obrir
        input.readLine();
        while (true) {
            String linia = input.readLine();                        // llegir
            if (null == linia) break;
            String[] elements = linia.split(",");
            double valorTotal=0;
            for (int i=1; i<elements.length; i++) {
                if (!(elements[i].equals("NP"))) {
                    valorTotal += Integer.parseInt(elements[i]);
                }
            }
            double notaMitja = valorTotal/(elements.length-1);
            System.out.printf("%s (%.2f)\n",elements[0], notaMitja);
        }
        input.close();
    }
}
