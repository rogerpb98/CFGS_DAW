import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UtilString {
    
    // Funcio que retorna si un caràcter es una lletra
    public static boolean esEntradaValida(String paraula) {
        if (paraula.length() == 1 && Character.isLetter(paraula.charAt(0))) {
            return true;
        }
        else {
            return false;
        }
    }

    // Funció que reb la paraula actual, la paraula censurada amb asteriscs 
    // i el caràcter introduit
    public static String descubrirLletres(String paraula, String paraulaOculta, char intent) {
        char[] arrayParaulaOculta = paraulaOculta.toCharArray();
        for (int i = 0; i < paraula.length(); i++) {
            if (paraula.charAt(i) == intent) {
                arrayParaulaOculta[i] = intent;
            }
        }
        paraulaOculta = String.valueOf(arrayParaulaOculta);
        return paraulaOculta;
    }
    
    //Comprueba si la entrada introducida es un valor repetido
    public static boolean repetida(String utilitzades, String entrada) {
        char lletra = entrada.charAt(0);
        for (int i = 0; i < utilitzades.length(); i++) {
            if (utilitzades.charAt(i) == lletra) {
                return true;
            }
        }
        return false;
    }

    //Obtiene las palabras de un archivo de texto y las devuelve en forma de array
    public static String[] obtenParaules() throws IOException{
        String path =  "paraules.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader input = new BufferedReader(fileReader);
        String paraules = ""; 
        while(true){
            String linea = input.readLine();
            if(null == linea) break;
            paraules += linea + ",";
        }
        input.close();
        return paraules.split(",");
    }

    //Oculta la palabra con el símbolo introducido
    public static String ocultaParaula (String paraula, char simbol){
        String paraulaOculta = "";
        for (int i = 0; i < paraula.length(); i++){
            paraulaOculta += simbol;
        }
        return paraulaOculta;
    }

    //Verifica que el caracter introducido forma parte del String introducido
    public static boolean intentAcertat (String paraula, char intent){
        for (int i = 0; i < paraula.length(); i++){
            if (paraula.charAt(i) == intent) return true;
        } 
        return false;
    }

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









