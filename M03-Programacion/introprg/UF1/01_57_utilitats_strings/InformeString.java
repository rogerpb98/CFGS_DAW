/*
 * rograma que demana dos texts i un enter positiu i 
 * composa un petit informe amb el resultat de les funcions anteriors.
 */

public class InformeString {
    public static void main(String[] args) {
        System.out.println("Text principal?");
        String principal = Entrada.readLine();
        System.out.println("Text secundari ?");
        String secundari = Entrada.readLine();
        System.out.println("Número positiu?");
        int numPositiu = Integer.parseInt(Entrada.readLine());

        /* Sortida */
        System.out.println("\"" + principal + "\".length(): " + principal.length());
        System.out.println("\"" + principal + "\".startsWith(\"" + secundari + "\"): " + principal.startsWith(secundari));
        System.out.println("\"" + principal + "\".endsWith(\"" + secundari + "\"): " + principal.endsWith(secundari));
        System.out.println("\"" + principal + "\".equals(\"" + secundari + "\"): " + principal.equals(secundari));
        System.out.println("\"" + principal + "\".equalsIgnoreCase(\"" + secundari + "\"): " + principal.equalsIgnoreCase(secundari));
        System.out.println("\"" + principal + "\".isBlank(): " + principal.isBlank());
        System.out.println("\"" + principal + "\".isEmpty(): " + principal.isEmpty());
        System.out.println("\"" + principal + "\".charAt(" + numPositiu + "): " + principal.charAt(numPositiu));
        System.out.println("\"" + principal + "\".concat(\"" + secundari + "\"): " + principal.concat(secundari));
        System.out.println("\"" + principal + "\".repeat(" + numPositiu + "): " + principal.repeat(numPositiu));
        System.out.println("\"" + principal + "\".toUpperCase(): " + principal.toUpperCase());
        System.out.println("\"" + principal + "\".toLowerCase(): " + principal.toLowerCase());
    }
}
