/* Cos principal "main" del puzle, contindrá el menú, tant com les funcions per processar cada
 * comanda
 */

import java.io.File;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Puzle {
    public static void main(String[] args) throws IOException {
        mostraBenvinguda();
        while (true) {
            mostraPrompt();
            String resposta = Entrada.readLine().strip();
            if (resposta.isEmpty()) continue;
            // "\\s+"" elimina els excessos de espais en blanc
            String[] elementsComanda = resposta.split("\\s+");
            String comanda = elementsComanda[0];
            //menú
            if (comanda.equals("quit")) break;
            switch (comanda) {
                case "help": mostraAjuda();
                    break;
                case "ls": mostraLlista();
                    break;
                case "show": processaShow(elementsComanda);
                    break;
                case "new": processaNew(elementsComanda);
                    break;
                case "cp": processaCp(elementsComanda);
                    break;
                case "add": processaAdd(elementsComanda);
                    break;
                case "mv": processaMv(elementsComanda);
                    break;
                case "del": processaDel(elementsComanda);
                    break;
                default: mostraErrorComandaDesconeguda();
            }
        }
        System.out.println("adèu");
    }
    /************  Moduls per mostrar l'estat i diversos errors  ************/
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
    public static void mostraErrorComandaShow() {
        System.out.println("ERROR: show «nom»");
    }
    public static void mostraErrorNomPuzleNoValid() {
        System.out.println("ERROR: nom no vàlid");
    }
    public static void mostraErrorPuzleDesconegut() {
        System.out.println("ERROR: puzle desconegut");
    }
    // Mostra llista de puzles del directori actual
    public static void mostraLlista() {
        File carpeta = new File(".");
        String[] continguts = carpeta.list();
        Arrays.sort(continguts);
        for (int i = 0; i < continguts.length; i++) {
            String item = continguts[i];
            if (esNomFitxerDePuzleValid(item)) {
                System.out.println(extreuNomPuzleDeNomFitxer(item));
            }
        }
    }

    /************  Moduls que processen les comandes  ************/
    // Processa la comanda show @param args: arguments de la comanda
    public static void processaShow(String[] args) throws IOException {
        if (args.length != 2) {
            mostraErrorComandaShow();
            return;
        }
        String nomPuzle = args[1];
        if (! esNomPuzleValid(nomPuzle)) {
            mostraErrorNomPuzleNoValid();
            return;
        }
        if (! existeixPuzle(nomPuzle)) {
            mostraErrorPuzleDesconegut();
            return;
        }
        Escacs taulell = llegeixPuzle(nomPuzle);
        taulell.mostraTaulell();
    }
    // Processa la comanda new
    public static void processaNew(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("ERROR: new «nom»");
            return;
        }
        String nomPuzle = args[1];
        if (existeixPuzle(nomPuzle)) {
            System.out.println("Ja existeix. El sobreescrivim?");
            if (UtilitatsConfirmacio.respostaABoolean(Entrada.readLine())) {
                Escacs taulell = new Escacs();
                escriuPuzle(nomPuzle, taulell);
            }
            else {
                return;
            }
        }
        else {
            Escacs taulell = new Escacs();
            escriuPuzle(nomPuzle, taulell);
        }
        System.out.println("fet");
    }
    // Processa la comanda cp
    public static void processaCp(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("ERROR: cp «nom1» «nom2»");
            return;
        }
        String nomPuzleACopiar = args[1];
        if (existeixPuzle(nomPuzleACopiar)) {
            String nomPuzleOnCopiar = args[2];
            if (existeixPuzle(nomPuzleOnCopiar)) {
                System.out.println("Ja existeix. El sobreescrivim?");
                if (UtilitatsConfirmacio.respostaABoolean(Entrada.readLine())) {
                    duplicaPuzle(nomPuzleACopiar, nomPuzleOnCopiar);
                }
                else {
                    return;
                }
            }
            else {
                duplicaPuzle(nomPuzleACopiar, nomPuzleOnCopiar);
            }
        }
        else {
            System.out.println("ERROR: puzle desconegut");
            return;
        }
        System.out.println("fet");
    }
    // Processa la comanda add
    public static void processaAdd(String[] args) throws IOException {
        if (args.length != 5) {
            System.out.println("ERROR: add «nom» «fila» «columna» «figura»");
            return;
        }
        String nomPuzle = args[1];
        if (existeixPuzle(nomPuzle)) {
            char figura = args[4].charAt(0);
            if (Escacs.esFiguraValida(figura)) {
                if (UtilString.esEnter(args[2]) && UtilString.esEnter(args[3])) {
                    Escacs escacs = llegeixPuzle(nomPuzle);
                    // Guardem el taulell a una variable per millorar la lectura del codi.
                    //char[][] taulell = escacs.getTaulell(); ***
                    int fila = Integer.parseInt(args[2]);
                    int columna = Integer.parseInt(args[3]);
                    //si no hi ha cap fitxa a la casella l'emplena amb la figura
                    if (escacs.posicionaFigura(fila, columna, figura)){
                        sobreescriuPuzle(nomPuzle, escacs.getTaulell());
                        //sobreescriuPuzle(nomPuzle, taulell); ***
                    }
                    else {
                        System.out.println("ERROR: no es pot posicionar");
                        return;
                    }
                }
                else {
                    System.out.println("ERROR: files i columnes han de ser valors enters");
                    return;
                }
            }
            else {
                System.out.println("ERROR: figura no vàlida");
                return;
            }
        }
        else {
            System.out.println("ERROR: puzle desconegut");
            return;
        }
        System.out.println("fet");
    }
    // Processa la comanda mv
    public static void processaMv(String[] args) throws IOException {
        if (args.length != 6) {
            System.out.println("ERROR: mv «nom» «fila0» «columna0» «fila1» «columna1»");
            return;
        }
        String nomPuzle = args[1];
        if (existeixPuzle(nomPuzle)) {
            if (UtilString.esEnter(args[2]) && 
                UtilString.esEnter(args[3]) && 
                UtilString.esEnter(args[4]) && 
                UtilString.esEnter(args[5])) {
                Escacs escacs = llegeixPuzle(nomPuzle);
                // Guardem el taulell a una variable per millorar la lectura del codi.
                //char[][] taulell = escacs.getTaulell(); ***
                int fila0 = Integer.parseInt(args[2]);
                int columna0 = Integer.parseInt(args[3]);
                int fila1 = Integer.parseInt(args[4]);
                int columna1 = Integer.parseInt(args[5]);
                //si no hi ha cap fitxa a la casella mou la figura
                if (escacs.mouFigura(fila0, columna0, fila1, columna1)){
                    sobreescriuPuzle(nomPuzle, escacs.getTaulell());
                    //sobreescriuPuzle(nomPuzle, taulell);
                }
                else {
                    System.out.println("ERROR: no es pot moure");
                    return;
                }
            }
            else {
                System.out.println("ERROR: files i columnes han de ser valors enters");
                return;
            }
        }
        else {
            System.out.println("ERROR: puzle desconegut");
            return;
        }
        System.out.println("fet");
    }
    // Processa la comanda del
    public static void processaDel(String[] args) throws IOException {
        if (args.length != 4) {
            System.out.println("ERROR: del «nom» «fila» «columna»");
            return;
        }
        String nomPuzle = args[1];
        if (existeixPuzle(nomPuzle)) {
            if (UtilString.esEnter(args[2]) && 
                UtilString.esEnter(args[3])) {
                Escacs escacs = llegeixPuzle(nomPuzle);
                // Guardem el taulell a una variable per millorar la lectura del codi.
                //char[][] taulell = escacs.getTaulell(); ***
                int fila = Integer.parseInt(args[2]);
                int columna = Integer.parseInt(args[3]);
                //si no hi ha cap fitxa a la casella lmou la figura
                if (escacs.eliminaFigura(fila, columna)){
                    //sobreescriuPuzle(nomPuzle, taulell); ***
                    sobreescriuPuzle(nomPuzle, escacs.getTaulell());
                }
                else {
                    System.out.println("ERROR: no es pot eliminar");
                    return;
                }
            }
            else {
                System.out.println("ERROR: files i columnes han de ser valors enters");
                return;
            }
        }
        else {
            System.out.println("ERROR: puzle desconegut");
            return;
        }
        System.out.println("fet");
    }

    /************  Moduls que comproven entrades  ************/
    // Comprova si es un nom de puzle valid
    public static boolean esNomPuzleValid (String nomPuzle) {
        if (nomPuzle.isEmpty()) return false;

        for (int i=0; i<nomPuzle.length(); i++) {
            if (Character.isLetter(nomPuzle.charAt(i))) ;
            else if (Character.isDigit(nomPuzle.charAt(i))) ;
            else if (nomPuzle.charAt(i)=='_') ;
            else return false;
        }

        return true;
    }
    // Comprova si es un nom de fitxer valid
    public static boolean esNomFitxerDePuzleValid (String nomFitxerPuzle) {
        if (nomFitxerPuzle.isEmpty()) return false;
        if (nomFitxerPuzle.length()<11) return false;

        //El fitxer ha de començar en puzle_
        if (!(nomFitxerPuzle.substring(0,6).equals("puzle_"))) return false;

        for (int i=7; i<(nomFitxerPuzle.length()-4); i++) {
            if (Character.isLetter(nomFitxerPuzle.charAt(i))) ;
            else if (Character.isDigit(nomFitxerPuzle.charAt(i))) ;
            else if (nomFitxerPuzle.charAt(i)=='_') ;
            else return false;
        }
        
        //El fitxer ha d'acabar' en .txt
        if (!(nomFitxerPuzle.substring(nomFitxerPuzle.length()-4,nomFitxerPuzle.length()).equals(".txt"))) return false;

        return true;
    }
    // Comprova si es un fitxer del puzle rebut per argument existeix
    public static boolean existeixPuzle(String nomPuzle) {
        String nomFitxer = composaNomFitxerDeNomPuzle(nomPuzle);
        if (esNomFitxerDePuzleValid(nomFitxer)) {
            File fitxer = new File(nomFitxer);
            if (fitxer.exists()) return true;
        }
        return false;
    }

    /************  Moduls que processen noms de fitxers/puzzles  ************/
    //Transforma un nom de puzle en nom de fitxer
    public static String composaNomFitxerDeNomPuzle (String nomPuzle) {
        return ("puzle_" + nomPuzle + ".txt");
    }
    //Transforma un nom de fitxer en nom de puzle
    public static String extreuNomPuzleDeNomFitxer (String nomPuzle) {
        String paraulaARetornar = "";

        for (int i=6; i<(nomPuzle.length()-4); i++) {
            paraulaARetornar += nomPuzle.charAt(i);
        }
        return paraulaARetornar;
    }
    
    /************  Moduls que processen el contingut dels puzles  ************/
    // Genera un taulell fet amb arrays en base al tauler que hi ha en un .txt
    public static Escacs llegeixPuzle(String nomPuzle) throws IOException {
        // Guardem el taulell a una variable per millorar la lectura del codi.
        char[][] taulell = new char[8][8];
        //char[][] taulell = escacs.getTaulell(); 
        String cami = composaNomFitxerDeNomPuzle(nomPuzle);
        FileReader filereader = new FileReader(cami);
        BufferedReader input = new BufferedReader(filereader);
        //Bucle que recorre l'arrai i l'emplena amb el tauler guardat al fitxer que
        //haguem passat per argument.
        for (int fila = 7; fila >= 0; fila--) {
            String linia = input.readLine();
            if (null==linia) break;
            for (int columna = 0; columna < taulell[fila].length; columna++) {
                taulell[fila][columna] = linia.charAt(columna);
            }
        }
        input.close();
        Escacs escacs = new Escacs(taulell);
        return escacs;
    }
    // Genera un tauler buit al fitxer del puzle indicat
    public static void escriuPuzle(String nomPuzle, Escacs escacs) throws IOException {
        String cami = Puzle.composaNomFitxerDeNomPuzle(nomPuzle);
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami));
        //Bucle que recorre l'arrai i emplena un string que escriurem al fitxer
        for (int fila = 0; fila < escacs.getTaulell().length; fila++) {
            String linia = "";
            for (int columna = 0; columna < escacs.getTaulell()[fila].length; columna++) {
                linia += '·';
            }
            sortida.write(linia + "\n");
        }
        sortida.close();
    }
    // Duplica el contingut d'un puzle al fitxer de l'altre puzle
    public static void duplicaPuzle(String fitxer1, String fitxer2) throws IOException {
        String camiACopiar = composaNomFitxerDeNomPuzle(fitxer1);
        String camiOnCopiar = composaNomFitxerDeNomPuzle(fitxer2);

        BufferedReader input = new BufferedReader(new FileReader(camiACopiar)); //llegir source
        BufferedWriter sortida = new BufferedWriter(new FileWriter(camiOnCopiar)); //escriure destí

        while(true) {
            String linia = input.readLine(); //llegir linia
            if (null == linia) break;
            sortida.write(linia + "\n");   //copiar linia al fitxer
        }

        input.close();
        sortida.close();
    }
    // Sobreescriu un puzle en base al tauler que reb per argument
    public static void sobreescriuPuzle(String nomPuzle, char[][] taulell) throws IOException {
        String cami = Puzle.composaNomFitxerDeNomPuzle(nomPuzle);
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami));
        //Bucle que recorre l'array i emplena un string que escriurem al fitxer
        for (int fila = 7; fila >= 0; fila--) {
            String linia = "";
            for (int columna = 0; columna < taulell[fila].length; columna++) {
                linia += taulell[fila][columna];
            }
            sortida.write(linia + "\n");
        }
        sortida.close();
    }
}