//Programa d'un lloro que repeteix el que li dius sempre que tingui vocal a l'inici
//o final, si no introduim res, sortim i ens despedeix.
public class LloroVocalIniciFi {
    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir) {
            System.out.println("El lloro demana paraula amb vocal a l'inici o/i final");
            String paraula = Entrada.readLine();

            if (paraula.isEmpty()) {
                System.out.println("El lloro demana confirmació per finalitzar");
                String resposta = Entrada.readLine();
                if (UtilitatsConfirmacio.respostaABoolean(resposta)) {
                    seguir = false;
                }
            }
            else if ( UtilString.esVocal(paraula.charAt(0)) || UtilString.esVocal(paraula.charAt(paraula.length()-1)) ) {
                System.out.println("El lloro diu: " + paraula);
            }
        }
        System.out.println("Adéu");
    }
}