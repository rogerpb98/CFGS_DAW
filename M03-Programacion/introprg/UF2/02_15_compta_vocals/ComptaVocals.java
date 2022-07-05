/* 
 * Programa que analitza la frase que introduim i ens diu quantes
 * vocals catalanes hi ha.
 */
public class ComptaVocals {
    public static void main(String[] args) {
        System.out.println("Introdueix un text");
        String entrada = Entrada.readLine();
        String lletres = "aàeèéiíïoóòuúü";
        for (int inici=0; inici<=lletres.length()-1; inici++) {
            int quantes = quantesOcurrencies(entrada, lletres.charAt(inici));
            mostraOcurrencies(lletres.charAt(inici), quantes);
        }
    }
    public static void mostraOcurrencies(char lletra, int quantes) {
        System.out.println("Nombre de '" + lletra + "'s: " + quantes);
    }
    public static int quantesOcurrencies(String text, char lletra) {
        int comptador = 0;
        for (int i=0; i < text.length(); i++) {
            if (text.charAt(i) == lletra) {
                comptador += 1;
            }
        }
        return comptador;
    }
}
