/* Utilitats per al main, només utilitzaré la funcio esEnter en aquesta clase. */

public class UtilString {
    //Retorna si el paràmetre que reb es un nombre enter
    public static boolean esEnter(String arg) {
        if(arg.isEmpty()) return false;
        for (int i=0; i<arg.length(); i++){
            if (!(Character.isDigit(arg.charAt(i)))) return false;
        }
        return true;
    }
}