public class UtilString {

    public static boolean esEnter(String frase) {
        
        for (int inici=0; inici <= frase.length()-1; inici++) {
            switch (frase.charAt(inici)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '+':
                case '-':
                case ' ':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
