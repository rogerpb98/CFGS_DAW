/* Utilitats per el penjat */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UtilString {
    
    // Funcio que retorna si un caràcter es una lletra
    public static boolean esLletra(String paraula) {
        char lletra = paraula.charAt(0);
        if (Character.isLetter(lletra)) {
            return true;
        }
        else {
            return false;
        }
    }

    // Funció que reb la paraula actual, la paraula censurada amb asteriscs 
    // i el caràcter introduit
    public static String descubrirLletres(String linia, String paraulaAsteriscs, String entrada) {
        char lletra = entrada.charAt(0);
        char[] arrayAsteriscs = paraulaAsteriscs.toCharArray();
        for (int i=0; i<linia.length(); i++) {
            if (linia.charAt(i) == lletra) {
                arrayAsteriscs[i] = lletra;
            }
        }
        paraulaAsteriscs = String.valueOf(arrayAsteriscs);
        return paraulaAsteriscs;
    }

    // Comprueba si la entrada introducida es un valor repetido
    public static boolean repetida(String utilitzades, String entrada) {
        char lletra = Character.toUpperCase(entrada.charAt(0));
        for (int i=0; i<utilitzades.length(); i++) {
            if (utilitzades.charAt(i) == lletra) {
                return true;
            }
        }
        return false;
    }

    // Llegeix el fitxer i ens retorna un array amb les paraules que conté
    public static String[] obtenParaules() throws IOException {
        String path = "recursos/paraules.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader input = new BufferedReader(fileReader);
        String paraules = "";
        while (true) {
            String linea = input.readLine();
            if (null == linea) break;
            paraules += linea+ ",";
        }
        input.close();
        return paraules.split(",");
    }

    //Funció que reb la paraula en joc actualment i retorna la mateixa longitud en asteriscs
    public static String ocultaParaula(String paraulaActual) {
        String paraulaOculta = "";
        for (int i = 0; i < paraulaActual.length(); i++) {
            paraulaOculta += '*';
        }
        return paraulaOculta;
    }

    // Funció que recull els caràcters utilitzats i les retorna entre comes, 
    // en majúscules i amb una i entre el penúltim i l'ultim caràcter
    public static String formataUtilitzades (String utilitzades, char intent){
        String paraulaNeta = "";
        String paraulaFormatada = "";

        if (utilitzades.isEmpty()){
            return String.valueOf(intent).toUpperCase(); 
        }

        for (int i = 0; i < utilitzades.length(); i++){
            if (Character.isLetter(utilitzades.charAt(i)) && i != (utilitzades.length() - 3)){
                paraulaNeta += utilitzades.charAt(i); 
            }
        }
        
        paraulaNeta += intent;

        for (int i = 0; i < paraulaNeta.length(); i++){
            paraulaFormatada += Character.toUpperCase(paraulaNeta.charAt(i));
            if (i < (paraulaNeta.length() - 2)) {
                paraulaFormatada += ", ";
            }
            if (i == (paraulaNeta.length() - 2)){
                paraulaFormatada += " i ";
            }
        }
        
        return paraulaFormatada;
    }
}
