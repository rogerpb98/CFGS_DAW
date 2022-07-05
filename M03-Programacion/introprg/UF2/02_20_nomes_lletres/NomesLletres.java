/*
 * Programa que mostra nomes les lletres d'un string separades per coma
 */

public class NomesLletres{
    public static void main(String[] args) {
        System.out.println("Text?");
        String text = Entrada.readLine();
        String nomesLletres = UtilString.nomesLletres(text);
        String separades = UtilString.lletresSeparades(nomesLletres);
        System.out.println(separades);
    }
}