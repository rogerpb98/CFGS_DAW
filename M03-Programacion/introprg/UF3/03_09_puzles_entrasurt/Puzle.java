/* Cos principal "main" del puzle */

public class Puzle {
    public static void main(String[] args) {
        mostraBenvinguda();
        while (true) {
            mostraPrompt();
            String comanda = Entrada.readLine().strip();
            if (comanda.isEmpty()) continue;
            if (comanda.equals("quit")) break;
            if (comanda.equals("help")) {
                mostraAjuda();
                continue;
            }
            mostraErrorComandaDesconeguda();
        }
        System.out.println("adèu");
    }
    //moduls
    public static void mostraBenvinguda() {
        System.out.println("Gestor de puzles d'escacs. Escriviu help per ajuda.");
    }

    public static void mostraPrompt() {
        System.out.print("puzle> ");
    }

    public static void mostraAjuda() {
        System.out.println("Comandes disponibles:");
        System.out.println("help");
        System.out.println("cp «nom1» «nom2»");
        System.out.println("add «nom» «figura» «fila» «columna»");
        System.out.println("del «nom» «fila» «columna»");
        System.out.println("mv »nom» «fila0» «columna0» «fila1» «columna1»");
        System.out.println("new «nom»");
        System.out.println("quit");
    }

    public static void mostraErrorComandaDesconeguda() {
        System.out.println("ERROR: comanda no reconeguda. Escriviu help per ajuda.");
    }
}