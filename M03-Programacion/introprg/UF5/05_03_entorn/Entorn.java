/* Tercer exercici per acabar muntant una botiga, en aquesta classe está el main, que farem servir
 * per donar ordres a la botiga, afegir-hi vins, eliminar-los, reemplaçar-los...
 * Conté totes les comandes disponibles, i una de help per fer-te d'ajuda.
 */
public class Entorn {

    private final Botiga laBonaEstrella = new Botiga();
    public static void main(String[] args) {
        Entorn entorn = new Entorn();
        System.out.println("Celler La Bona Estrella. Escriviu ajuda per veure opcions.");
        //prompt que demana una comanda i switch que la gestiona.
        while (true) {
            mostraPrompt();
            String resposta = Entrada.readLine().strip();
            if (resposta.isEmpty()) continue;
            if (resposta.equals("surt")) {
                System.out.println("adéu");
                break;
            }
            switch (resposta) {
                case "ajuda": mostraAjuda();
                    break;
                case "afegeix": entorn.processaAfegeix();
                    break;
                case "cerca": entorn.processaCerca();
                    break;
                case "modifica": entorn.processaModifica();
                    break;
                case "elimina": entorn.processaElimina();
                    break;
                default: mostraErrorComandaDesconeguda();
                    break;
            }
        }
    }
    //Funcions que mostren coses al prompt
    public static void mostraPrompt() {
        System.out.print("botiga> ");
    }
    public static void mostraAjuda() {
        System.out.println("Comandes disponibles:");
        System.out.println("ajuda");
        System.out.println("cerca");
        System.out.println("afegeix");
        System.out.println("modifica");
        System.out.println("elimina");
        System.out.println("surt");
    }
    public static void mostraErrorComandaDesconeguda() {
        System.out.println("ERROR: comanda no reconeguda. Escriviu help per ajuda");
    }

    //Metodes per processar comandes
    public void processaAfegeix() {
        //Nom
        System.out.print("nom (enter cancel·la)> ");
        String respostaNom = Entrada.readLine();
        if (respostaNom.isEmpty()) 
            return;
        //Preu
        int respostaPreuInt;
        System.out.print("preu (en cèntims)> ");
        String respostaPreu = Entrada.readLine();
        if (respostaPreu.isEmpty()) 
            respostaPreuInt=0;
        else if (!(UtilString.esEnterPositiu(respostaPreu))) {
            System.out.println("ERROR: el valor ha de ser un enter positiu");
            return;
        }
        else respostaPreuInt = Integer.parseInt(respostaPreu);
        //Estoc
        int respostaEstocInt;
        System.out.print("estoc (enter sense estoc)> ");
        String respostaEstoc = Entrada.readLine();
        if (respostaEstoc.isEmpty()) 
            respostaEstocInt=0;
        else if (!(UtilString.esEnterPositiu(respostaEstoc))) {
            System.out.println("ERROR: el valor ha de ser un enter positiu");
            return;
        }
        else respostaEstocInt = Integer.parseInt(respostaEstoc);
        
        
        Vi vi = new Vi(respostaNom, respostaPreuInt, respostaEstocInt);
        //Si no s'ha pogut afegir ho diu per pantalla
        Vi viAfegit = laBonaEstrella.afegeix(vi);
        if (viAfegit==null)
            System.out.println("ERROR: no s'ha pogut afegir");
        else
            System.out.println("Introduït:" + viAfegit);
    }
    public void processaCerca() {
        System.out.print("nom (enter cancel·la)> ");
        String respostaNom = Entrada.readLine();
        if (respostaNom.isEmpty()) 
            return;

        Vi viCercat = laBonaEstrella.cerca(respostaNom);
        if (viCercat==null)
            System.out.println("No trobat");
        else
            System.out.println("Trobat:" + viCercat);
    }
    public void processaModifica() {
        //Nom
        System.out.print("nom (enter cancel·la)> ");
        String respostaNom = Entrada.readLine();
        if (respostaNom.isEmpty()) 
            return;
        //Busca el vi que correspongui al que volem modificar
        Vi viCercat = laBonaEstrella.cerca(respostaNom);
        if (viCercat==null) {
            System.out.println("No trobat");
            return;
        }
        
        //Preu
        int respostaPreuInt;
        System.out.print("preu (enter " + viCercat.getPreu() + ")> ");
        String respostaPreu = Entrada.readLine();
        if (respostaPreu.isEmpty()) 
            //Si no especifiquem cap preu es queda com estava
            respostaPreuInt=viCercat.getPreu();
        else if (!(UtilString.esEnterPositiu(respostaPreu))) {
            System.out.println("ERROR: el valor ha de ser un enter positiu");
            return;
        }
        else respostaPreuInt = Integer.parseInt(respostaPreu);

        //Estoc
        int respostaEstocInt;
        System.out.print("estoc (enter " + viCercat.getEstoc() + ")> ");
        String respostaEstoc = Entrada.readLine();
        if (respostaEstoc.isEmpty()) 
            //Si no especifiquem cap estoc es queda com estava
            respostaEstocInt=viCercat.getEstoc();
        else if (!(UtilString.esEnterPositiu(respostaEstoc))) {
            System.out.println("ERROR: el valor ha de ser un enter positiu");
            return;
        }
        else respostaEstocInt = Integer.parseInt(respostaEstoc);

        viCercat.setPreu(respostaPreuInt);
        viCercat.setEstoc(respostaEstocInt);
        System.out.println("Modificat:" + viCercat);
    }
    public void processaElimina() {
        System.out.print("nom (enter cancel·la)> ");
        String respostaNom = Entrada.readLine();
        if (respostaNom.isEmpty()) 
            return;

        Vi viCercat = laBonaEstrella.cerca(respostaNom);
        if (viCercat==null)
            System.out.println("No trobat");
        else {
            System.out.println("A eliminar: " + viCercat);
            System.out.print("Segur?> ");
            String respostaConfirmació = Entrada.readLine();
            if (UtilitatsConfirmacio.respostaABoolean(respostaConfirmació)) {
                Vi viEliminat = laBonaEstrella.elimina(viCercat);
                if (viEliminat==null)
                    System.out.println("ERROR: no s'ha pogut eliminar");
                else
                    System.out.println("Eliminat");
            }
            else System.out.println("No eliminat");
        }
    }
}