/* Programa que fà la funció del joc del penjat "El Ahorcado" */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Penjat {
    public static void main(String[] args) throws IOException {
        //comptadors (provisional)
        int jugades = 0;
        int encertades = 0;
        int fallades = 0;
        int cancelades = 0;
        System.out.println ("Comencem a jugar");
        String[] paraules = UtilString.obtenParaules(); //Guardem totes les paraules del fitxer a un Array
        
        for (int linia = 0; linia < paraules.length; linia++) {
            //Inici de partida
            String paraulaActual = paraules[linia]; // fico la paraula actual a una variable readibilitat
            String utilitzades = "";                // String que guarda les lletres utilitzades
            int intents = 10;                       // 10 intents base per cada paraula
            String paraulaAsteriscs = UtilString.ocultaParaula(paraulaActual); // String a omplir amb tants asteriscs com caracters tingui la paraula
            
            jugades++; // Cada iteració del bucle les paraules jugades augmenta en 1
            
            while (intents > 0) {

                mostrarProgres(paraulaAsteriscs, utilitzades, intents);

                //Entrada
                System.out.println("Introdueix una lletra");
                String intent = Entrada.readLine();
                if (intent.equalsIgnoreCase("prou")) { // Força el final de la partida
                    linia=paraules.length;
                    cancelades++;
                    break;
                }
                else if (intent.equalsIgnoreCase("glups")) { // Passa a la següent paraula
                    cancelades++;
                    break;
                }
                else if (intent.length() == 1 && UtilString.esLletra(intent.toLowerCase())) { // Entrada valida (1 unica lletra)                  
                    String preFuncio = paraulaAsteriscs;

                    paraulaAsteriscs = UtilString.descubrirLletres(paraulaActual, paraulaAsteriscs, intent.toLowerCase());
                    
                    //Si repeteixes entrada
                    if (UtilString.repetida(utilitzades, intent)) {
                        System.out.println("La lletra ja ha estat utilitzada");
                    }
                    
                    //Entra en este if si has adivinado la palabra
                    else if (paraulaAsteriscs.equals(paraulaActual)) {
                        System.out.println("Has encertat! La paraula era " + paraulaActual);
                        encertades++;
                        break;
                    }

                    //Si fallas la entrada
                    else if (paraulaAsteriscs.equals(preFuncio)) {
                        intents--;
                        mostraFigura(intents);
                        //utilitzades += intent;
                        utilitzades = UtilString.formataUtilitzades(utilitzades, intent.charAt(0));
                    }
                    //Si acertes lletra nomes te la afegeix a la llista de lletres utilitzades
                    else {
                        //utilitzades += intent;
                        utilitzades = UtilString.formataUtilitzades(utilitzades, intent.charAt(0));
                    }

                    
                }
                else {
                    System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");
                }
                if (intents == 0) {
                    fallades++;
                    System.out.println("Has mort");
                }
            }
        }
        if (jugades==paraules.length) {
            System.out.println("No queden més paraules");
        }
        // Fi del programa, mostrarà els resultats
        System.out.println("Paraules jugades: " + jugades);
        System.out.println("Paraules encertades: " + encertades);
        System.out.println("Paraules fallades: " + fallades);
        System.out.println("Paraules cancel·lades: " + cancelades);
        System.out.println("Espero que t'hagis divertit");
    }

    // Funció que mostra el progres de la partida
    public static void mostrarProgres(String paraulaAsteriscs, String utilitzades, int intents) {
        // Mostrar la paraula actual amb asteriscs
        System.out.println("Paraula: " + paraulaAsteriscs);
                
        // Lletres utilitzades
        if (utilitzades.isEmpty()) {
            System.out.println("Utilitzades: cap");
        }
        else {
            System.out.println("Utilitzades: " + utilitzades);
        }

        // Intents disponibles
        System.out.println("Intents disponibles: " + intents);
    }

    // Funció que mostra la figura cada cop que fallem dependent dels intents disponibles
    public static void mostraFigura(int intentsDisponibles) throws IOException {
        String path = "recursos/figura" + Math.abs(intentsDisponibles - 9) + ".txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader input = new BufferedReader(fileReader);
        while (true) { 
            String linia = input.readLine(); // Conté la paraula
            if (null == linia) break;
            System.out.println(linia);
        }
        input.close();
    }
}
