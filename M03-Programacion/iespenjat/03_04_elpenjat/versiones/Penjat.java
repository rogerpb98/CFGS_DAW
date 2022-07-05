import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Penjat{
    public static void main(String[] args) throws IOException {
        //comptadors (provisional)
        int jugades = 0;
        int encertades = 0;
        int fallades = 0;
        int cancelades = 0;

        System.out.println ("Comencem a jugar");

        String[] paraules = UtilString.obtenParaules();

        for (int i = 0; i <= paraules.length; i++){
            String paraula = paraules[i]; 
            if(jugada(paraula)){
                encertades++;
            }
            jugades++;
        }

        System.out.println("Paraules jugades: " + jugades);
        System.out.println("Paraules encertades: " + encertades);
        System.out.println("Paraules fallades: " + fallades);
        System.out.println("Paraules cancel·lades: " + cancelades);
        System.out.println("Espero que t'hagis divertit");
    }

    //Se encarga de la lógica de cada jugada
    public static boolean jugada(String paraula){
        String paraulaOculta = UtilString.ocultaParaula(paraula, '*');
        String utilitzades = "";
        int intents = 10;
        while (intents > 0){
            mostrarProgres(paraulaOculta, utilitzades, intents);
            System.out.println("Introdueix una lletra");
            String intent = Entrada.readLine();
            if (intent.equals("glups")){ 
                return "siguiente";
            }else if (intent.equals("prou")) return "finalizada";    
            while (!UtilString.esEntradaValida(intent)){
                System.out.println("Error: cal una lletra entre 'a' i 'z', 'prou' o 'glups'");
                intent = Entrada.readLine();
            }
            if (UtilString.repetida(utilitzades, intent)){
                System.out.println("repetida");
                continue;
            }
            if (UtilString.intentAcertat(paraula, intent.charAt(0))){
                paraulaOculta = UtilString.descubrirLletras(paraula, paraulaOculta, intent.charAt(0));
                if (paraulaCompletada(paraulaOculta, '*')) return "acertada";
                utilitzades = formataUtilitzades(utilitzades);
            }

        }
        return true;
    }

    //Muestra el progreso de la jugada
    public static void mostrarProgres(String paraulaOculta, String utilitzades, int intents) {

        System.out.println("Paraula: " + paraulaOculta);

        if (utilitzades.isEmpty()) {
            System.out.println("Utilitzades: cap");
        }
        else {
            System.out.println("Utilitzades: " + utilitzades);
        }

        System.out.println("Intents disponibles: " + intents);
    }

    //Imprime por pantalla la figura correspondiente al número de intentos restantes
    public static void mostrarFigura(int intentsDisponibles) throws IOException {
        String path = "figuras/figura" + Math.abs(intentsDisponibles - 9) + ".txt";
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
