/*
* Ens mostra un informe del caràcter que introduim per consola.
*/
public class InformeCaracter {
    public static void main(String[] args) {
        System.out.println("Caràcter?");
        String paraula = Entrada.readLine();
        if (paraula.isEmpty()) {
            System.out.println("Caràcter buit");
        }
        else{
            /* Extraure la primera lletra */
            char primeraLletra = paraula.charAt(0);
            /* Processarla */
            System.out.println("Character.getName('" + primeraLletra + "'): " + Character.getName(primeraLletra));
            System.out.println("Character.isDigit('" + primeraLletra + "'): " + Character.isDigit(primeraLletra));
            System.out.println("Character.isJavaIdentifierStart('" + primeraLletra + "'): " + Character.isJavaIdentifierStart(primeraLletra));
            System.out.println("Character.isJavaIdentifierPart('" + primeraLletra + "'): " + Character.isJavaIdentifierPart(primeraLletra));
            System.out.println("Character.isLetter('" + primeraLletra + "'): " + Character.isLetter(primeraLletra));
            System.out.println("Character.isLowerCase('" + primeraLletra + "'): " + Character.isLowerCase(primeraLletra));
            System.out.println("Character.isUpperCase('" + primeraLletra + "'): " + Character.isUpperCase(primeraLletra));
            System.out.println("Character.isWhitespace('" + primeraLletra + "'): " + Character.isWhitespace(primeraLletra));
            System.out.println("Character.toLowerCase('" + primeraLletra + "'): " + Character.toLowerCase(primeraLletra));
            System.out.println("Character.toUpperCase('" + primeraLletra + "'): " + Character.toUpperCase(primeraLletra));
        }
    }
}