// Programa que printa nombres enters que li pasem per linea 
// de comandes entre comes utilitzant un array
// La longitud de l'array la decideix l'usuari
// Si indroduim un nombre negatiu a longitud para
import java.util.Scanner;
public class EntersEntreComes {

    public static String entreComes(int[] numeros, char separador) {
        return "";
    }

    public static void main(String[] args) {
        System.out.println("Quants?");
        String longitudS = Entrada.readLine();
        while (!(UtilString.esEnter(longitudS))) {
            System.out.println("Per favor, un valor enter");
            longitudS = Entrada.readLine();
        }
        System.out.println("Separador?");
        /*Scanner sc = new Scanner(System.in);
        char separador = sc.next().charAt(0);*/
        String separadorS = Entrada.readLine();
        char separador;
        if (separadorS.isEmpty()) {
            separador=',';
        }
        else {
            separador=separadorS.charAt(0);
        }
        System.out.println(separador);


        int longitud = Integer.parseInt(longitudS); //convertim la quantitat a int
        
        if (longitud < 0) {
            System.out.println("Res a fer");
        }
        else{
            int[] numeros;
            numeros = new int[longitud];
            entreComes(numeros, separador);
            
        }
    }
}