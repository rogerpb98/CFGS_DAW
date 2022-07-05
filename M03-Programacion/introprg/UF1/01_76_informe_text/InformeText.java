public class InformeText {
    public static void main(String[] args) {
        System.out.println("Text?");
        String frase = Entrada.readLine();
        if (frase.isEmpty()) {
            System.out.println("Cadena buida");
        }
        else {
            //inicialitzem tots els contadors que ens faràn falta.
            int majuscules = 0;
            int minuscules = 0;
            int totalLletres = 0;
            int vocalsMajuscules = 0;
            int vocalsMinuscules = 0;
            int totalVocals = 0;
            int totalDigits = 0;
            int altresCaracters = 0;
            int totalCaracters = 0;
            //bucle que recorre tots els caràcters de la frase i augmenta en 1 els contadors de las categoríes on correspongui
            for (int inici=0; inici<=(frase.length()-1); inici++) {
                //si el caracter es majuscula
                if (Character.isUpperCase(frase.charAt(inici))) {
                    majuscules++;
                }
                //si el caracter es minuscula
                if (Character.isLowerCase(frase.charAt(inici))) {
                    minuscules++;
                }
                //si el caracter es lletra
                if (Character.isLetter(frase.charAt(inici))) {
                    totalLletres++;
                }
                //si el caracter es vocal majuscula
                if ((Character.toLowerCase(frase.charAt(inici))=='e' || Character.toLowerCase(frase.charAt(inici))=='à' || Character.toLowerCase(frase.charAt(inici))=='ó' || 
                    Character.toLowerCase(frase.charAt(inici))=='ü' || Character.toLowerCase(frase.charAt(inici))=='i' || Character.toLowerCase(frase.charAt(inici))=='í' || 
                    Character.toLowerCase(frase.charAt(inici))=='ì' || Character.toLowerCase(frase.charAt(inici))=='ö' || Character.toLowerCase(frase.charAt(inici))=='o' || 
                    Character.toLowerCase(frase.charAt(inici))=='ï' || Character.toLowerCase(frase.charAt(inici))=='è' || Character.toLowerCase(frase.charAt(inici))=='ú' ||
                    Character.toLowerCase(frase.charAt(inici))=='u' || Character.toLowerCase(frase.charAt(inici))=='é' || Character.toLowerCase(frase.charAt(inici))=='ò' || 
                    Character.toLowerCase(frase.charAt(inici))=='ù' || Character.toLowerCase(frase.charAt(inici))=='a' )&&(Character.isUpperCase(frase.charAt(inici)))) {
                    vocalsMajuscules++;
                }
                //si el caracter es vocal minuscula
                if ((Character.toLowerCase(frase.charAt(inici))=='e' || Character.toLowerCase(frase.charAt(inici))=='à' || Character.toLowerCase(frase.charAt(inici))=='ó' || 
                    Character.toLowerCase(frase.charAt(inici))=='ü' || Character.toLowerCase(frase.charAt(inici))=='i' || Character.toLowerCase(frase.charAt(inici))=='í' || 
                    Character.toLowerCase(frase.charAt(inici))=='ì' || Character.toLowerCase(frase.charAt(inici))=='ö' || Character.toLowerCase(frase.charAt(inici))=='o' || 
                    Character.toLowerCase(frase.charAt(inici))=='ï' || Character.toLowerCase(frase.charAt(inici))=='è' || Character.toLowerCase(frase.charAt(inici))=='ú' ||
                    Character.toLowerCase(frase.charAt(inici))=='u' || Character.toLowerCase(frase.charAt(inici))=='é' || Character.toLowerCase(frase.charAt(inici))=='ò' || 
                    Character.toLowerCase(frase.charAt(inici))=='ù' || Character.toLowerCase(frase.charAt(inici))=='a' )&&(Character.isLowerCase(frase.charAt(inici)))) {
                    vocalsMinuscules++;
                }
                //si el caracter es vocal
                if (Character.toLowerCase(frase.charAt(inici))=='e' || Character.toLowerCase(frase.charAt(inici))=='à' || Character.toLowerCase(frase.charAt(inici))=='ó' || 
                    Character.toLowerCase(frase.charAt(inici))=='ü' || Character.toLowerCase(frase.charAt(inici))=='i' || Character.toLowerCase(frase.charAt(inici))=='í' || 
                    Character.toLowerCase(frase.charAt(inici))=='ì' || Character.toLowerCase(frase.charAt(inici))=='ö' || Character.toLowerCase(frase.charAt(inici))=='o' || 
                    Character.toLowerCase(frase.charAt(inici))=='ï' || Character.toLowerCase(frase.charAt(inici))=='è' || Character.toLowerCase(frase.charAt(inici))=='ú' ||
                    Character.toLowerCase(frase.charAt(inici))=='u' || Character.toLowerCase(frase.charAt(inici))=='é' || Character.toLowerCase(frase.charAt(inici))=='ò' || 
                    Character.toLowerCase(frase.charAt(inici))=='ù' || Character.toLowerCase(frase.charAt(inici))=='a' ){
                    totalVocals++;
                }
                //si el caracter es digit
                if (Character.isDigit(frase.charAt(inici))) {
                    totalDigits++;
                }
                //Si el caracter no es ni digit ni lletra, es un altre caracter
                if (!(Character.isLetter(frase.charAt(inici))) && !(Character.isDigit(frase.charAt(inici)))) {
                    altresCaracters++;
                }
                totalCaracters++;
            }
            System.out.println("Informe");
            System.out.println("=======");
            System.out.printf("lletres en majúscules: %d (%.2f%%)%n", majuscules, 100.0 * majuscules / totalCaracters);
            System.out.printf("lletres en minúscules: %d (%.2f%%)%n", minuscules, 100.0 * minuscules / totalCaracters);
            System.out.printf("total lletres: %d (%.2f%%)%n", totalLletres, 100.0 * totalLletres / totalCaracters);
            System.out.printf("vocals en majúscules: %d (%.2f%%)%n", vocalsMajuscules, 100.0 * vocalsMajuscules / totalCaracters);
            System.out.printf("vocals en minúscules: %d (%.2f%%)%n", vocalsMinuscules, 100.0 * vocalsMinuscules / totalCaracters);
            System.out.printf("total vocals: %d (%.2f%%)%n", totalVocals, 100.0 * totalVocals / totalCaracters);
            System.out.printf("digits: %d (%.2f%%)%n", totalDigits, 100.0 * totalDigits / totalCaracters);
            System.out.printf("altres caràcters: %d (%.2f%%)%n", altresCaracters, 100.0 * altresCaracters / totalCaracters);
            System.out.printf("total caràcters: %d%n", totalCaracters);
    
        }
    }
}