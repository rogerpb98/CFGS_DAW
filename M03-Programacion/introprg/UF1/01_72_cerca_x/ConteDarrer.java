/*
 * programa que va demanant texts fins que un no contingui el darrer caràcter 
 * del text anterior. El primer text és acceptat sempre a menys que estigui buit.
 */
public class ConteDarrer {
    public static void main(String[] args) {
        System.out.println("Introdueix texts (enter sol per finalitzar)");
        String frase = Entrada.readLine();
        if (!(frase.isBlank())) {
            System.out.println("bé");
        }
        while (!(frase.isBlank())) { //si possem un string buit ens mata el programa
            char ultimaLletra = Character.toLowerCase(frase.charAt(frase.length()-1));
            frase = Entrada.readLine();
            if (!(frase.isEmpty())) {
                int contador = 0;
                for (int inici=0; inici <= frase.length()-1; inici++) {
                    //Si una lletra del string coincideix amb l'ultim caracter de l'anterior, printa bé i para de ocmparar.
                    if (ultimaLletra == Character.toLowerCase(frase.charAt(inici))) {
                        System.out.println("bé");
                        break;
                    }
                    else {
                        //Aquest contador augmenta cada cop que una lletra no coincideix
                        contador++; 
                        //Si el contador es tant gran com la llargada del string, s'acaba el programa.
                        if (contador==frase.length()) { 
                            frase = "";
                        }
                    }
                }
            }
        }
        System.out.println("Adéu");
    }
}