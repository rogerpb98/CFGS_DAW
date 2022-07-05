/*
 * programa que demana un text i mostra totes les lletres en minúscules excepte les vocals, 
 * que hauran d’estar en majúscules.
 */
public class VocalsMajuscules {
    public static void main(String[] args) {

        System.out.println("Text?");
        String nombre = Entrada.readLine();


        for (int inici=0; inici<=nombre.length()-1; inici ++) {
            if (nombre.charAt(inici)==' ') {
                System.out.print(nombre.charAt(inici));
            }
            else if (Character.isLetter(nombre.charAt(inici)) && nombre.charAt(inici)=='a' || nombre.charAt(inici)=='e' || nombre.charAt(inici)=='i' || nombre.charAt(inici)=='o' || nombre.charAt(inici)=='u' || nombre.charAt(inici)=='A' || nombre.charAt(inici)=='E' || nombre.charAt(inici)=='I' || nombre.charAt(inici)=='O' || nombre.charAt(inici)=='U') {
                System.out.print(Character.toUpperCase(nombre.charAt(inici)));
            }
            else {
                System.out.print(Character.toLowerCase(nombre.charAt(inici)));
            }
        }

    }
}