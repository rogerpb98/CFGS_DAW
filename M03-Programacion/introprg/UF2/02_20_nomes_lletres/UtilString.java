public class UtilString {
    public static String nomesLletres(String frase) {
        String text = "";
        

        for (int inici=0; inici<=(frase.length()-1); inici++) {
            char lletra = frase.charAt(inici);
            if (Character.isLetter(lletra)) {
                text = text + lletra;
            }
        }

        return text;
    }

    public static String lletresSeparades(String frase) {
        String text = "";
        

        for (int inici=0; inici<=(frase.length()-1); inici++) {
            char lletra = frase.charAt(inici);
            if (Character.isLetter(lletra)) {
                text = text + lletra;
                if (inici != frase.length()-1){
                    text = text +", ";
                }
            }
        }

        return text;
    }
}