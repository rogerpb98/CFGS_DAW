/* Utilitats per al main */

public class UtilString {
    public static boolean esEnter(String arg) {
        if(arg.isEmpty()) return false;
        for (int i=0; i<arg.length(); i++){
            if (!(Character.isDigit(arg.charAt(i)))) return false;
        }
        return true;
    }
}
