
/*
 * programa que demana el nom d’una persona, la seva edat i l’any actual, i escriu l’edat que 
 * tenia aquella persona cada any des del seu naixement.
 */
public class HistoricEdats {
    public static void main(String[] args) {
        System.out.println("nom?");
        String nom = Entrada.readLine();
        System.out.println("edat?");
        int edat = Integer.parseInt(Entrada.readLine());
        System.out.println("any actual?");
        int anyActual = Integer.parseInt(Entrada.readLine());
        if (edat < 0 || nom.isEmpty() || anyActual < 1971) {
            System.out.println("Entrada errònia");
        }
        else {
            for (int numero = (edat - edat); numero < edat; numero = numero + 1) {
                if (numero == 0) {
                    System.out.println("El " + (anyActual - edat + numero) + " va néixer");
                }
                else if (numero == 1) {
                    System.out.println("El " + (anyActual - edat + numero) + " tenia " + numero + " any");
                }
                else{
                    System.out.println("El " + (anyActual - edat + numero) + " tenia " + numero + " anys");
                }
            }
            System.out.println("Adéu " + nom);
        }
    }
}
