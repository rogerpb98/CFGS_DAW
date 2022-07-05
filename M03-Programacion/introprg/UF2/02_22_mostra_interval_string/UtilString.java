public class UtilString {
    public static String intervalString(String frase, int inici, int ultima) {
        String text = "";
        

        if (inici < ultima) {
            if (ultima > frase.length()) {
                ultima = frase.length()-1;
            }
            for (int inicibucle=(inici); inicibucle<=ultima; inicibucle++) {
                text = text + frase.charAt(inicibucle);
            }
        }
        else {
            
            if (inici > frase.length()) {
                inici = frase.length()-1;
            }
            for (int inicibucle=(inici); inicibucle>=ultima; inicibucle--) {
                text = text + frase.charAt(inicibucle);                    
            }
        }

        return text;
    }
}