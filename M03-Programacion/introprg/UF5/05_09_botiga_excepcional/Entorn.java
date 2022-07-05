/* Tercer exercici per acabar muntant una botiga, en aquesta classe está el main, que farem servir
 * per donar ordres a la botiga, afegir-hi vins, eliminar-los, reemplaçar-los...
 * Conté totes les comandes disponibles, i una de help per fer-te d'ajuda.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Entorn {

    private final Botiga laBonaEstrella = new Botiga();
    public static void main(String[] args) throws IOException {

        String cami = "botiga.csv";

        Entorn entorn = new Entorn();
        System.out.println("Celler La Bona Estrella. Escriviu ajuda per veure opcions.");
        System.out.println("Referències llegides: " + entorn.carregarReferencies(cami));
        //prompt que demana una comanda i switch que la gestiona.
        while (true) {
            mostraPrompt();
            String resposta = Entrada.readLine().strip();
            if (resposta.isEmpty()) continue;
            if (resposta.equals("surt")) {
                System.out.println("Referències guardades: " + entorn.guardarEstatBotigaCSV(cami));
                System.out.println("adéu");
                break;
            }
            switch (resposta) {
                case "ajuda": mostraAjuda();
                    break;
                case "afegeix": 
                try {
                    entorn.processaAfegeix();
                } catch (Exception e) {
                    System.out.println(e);
                }
                
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
    public void processaCerca() {
        //System.out.println("Enter deixa sense especificar. ! finalitza la plantilla.");
        String respostaRef, respostaNom, respostaTipus, respostaCollita, respostaOrigen, respostaLloc;
        int respostaPreuInt, respostaEstocInt;
        respostaRef = "";
        respostaNom = "";
        respostaTipus = "";
        respostaPreuInt = -1;
        respostaCollita = "";
        respostaEstocInt = -1;
        respostaOrigen = "";
        respostaLloc = "";
        while (true) {
            System.out.print("ref> ");
            respostaRef = Entrada.readLine();
            if (respostaRef.equals("!")) break;

            System.out.print("nom> ");
            respostaNom = Entrada.readLine();
            if (respostaNom.equals("!")) break;

            System.out.print("tipus> ");
            respostaTipus = Entrada.readLine();
            if (respostaTipus.equals("!")) break;

            System.out.print("preu max.> ");
            String respostaPreu = Entrada.readLine();
            if (respostaPreu.equals("!")) break;
            if (UtilString.esEnterPositiu(respostaPreu))
                respostaPreuInt = Integer.parseInt(respostaPreu);

            System.out.print("collita> ");
            respostaCollita = Entrada.readLine();
            if (respostaCollita.equals("!")) break;

            System.out.print("estoc min.> ");
            String respostaEstoc = Entrada.readLine();
            if (respostaEstoc.equals("!")) break;
            if (UtilString.esEnterPositiu(respostaEstoc))
                respostaEstocInt = Integer.parseInt(respostaEstoc);

            System.out.print("D.O.> ");
            respostaOrigen = Entrada.readLine();
            if (respostaOrigen.equals("!")) break;

            System.out.print("lloc> ");
            respostaLloc = Entrada.readLine();
            if (respostaLloc.equals("!")) break;
            break;
        }
        Vi viACercar = new Vi(respostaRef, respostaNom, respostaTipus, respostaPreuInt, respostaCollita, respostaEstocInt, respostaOrigen, respostaLloc);

        Vi viCercat = laBonaEstrella.cerca(viACercar);
        if (viCercat==null)
            System.out.println("No trobat");
        else
            System.out.println("Trobat:" + viCercat);
    }
    public int carregarReferencies(String cami) throws IOException {
        int referencies=0;
        File fitxer = new File(cami);
        if (fitxer.exists()) {
            FileReader fileReader = new FileReader(cami);
            BufferedReader input = new BufferedReader(fileReader);
            while (true) {
                String linia = input.readLine();
                if (null == linia) break;
                String[] elements = linia.split(";");
                if(elements.length==8) {
                    Vi vi = Vi.deArrayString(elements);
                    try {
                        if (vi!=null) {
                            laBonaEstrella.afegeix(vi);
                            referencies++;
                        }
                    } catch (BotigaPlenaException e) {
                        System.out.println(e);
                    }
                    
                }
            }
            input.close();
        }
        return referencies;
    }
    public int guardarEstatBotigaCSV(String cami) throws IOException {
        int referencies=0;
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami));
        laBonaEstrella.iniciaRecorregut();
        while (true) {
            Vi viAGuardar = laBonaEstrella.getSeguent();
            if (viAGuardar==null) break;
            referencies++;
            String[] arrayVi=viAGuardar.aArrayString();
            String viFormatat="";
            for (int i = 0; i < arrayVi.length; i++) {
                viFormatat+=arrayVi[i];
                if (i!=arrayVi.length-1) viFormatat+=(";");
            }
            sortida.write(viFormatat + "\n");
        }
        sortida.close();
        return referencies;
    }


    /*******************Opcional****************************/
    public void processaAfegeix() throws BotigaPlenaException {
        /*
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
        */
    }
    public void processaModifica() throws IllegalArgumentException {
        /*
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
        */
    }
    public void processaElimina() throws IllegalArgumentException {
        /*
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
        */
    }
}