// Programa de la UF1 que feia de semàfor pero ara restringint per edat.

public class Semafor {
    public static void main(String[] args) {

        System.out.println("Ets major d'edat?");
        String resposta = Entrada.readLine();
        if (UtilitatsConfirmacio.respostaABoolean(resposta)) {
            /*Declara la variable*/
            System.out.println("Color?");
            String color = Entrada.readLine();
            /*Entra a la opció que li haguem donat*/
            switch(color) {
                case "groc":
                    System.out.println("corre!");
                break;
                case "vermell":
                    System.out.println("espera");
                break;
                case "verd":
                    System.out.println("passa");
                break;
                /* resposta si no es cap de les anteriors*/
                default:
                    System.out.println("ves a l'oculista");
            }
        }
        else {
            System.out.println("No pots fer servir aquest programa sense supervisió");
        }
    }
}
