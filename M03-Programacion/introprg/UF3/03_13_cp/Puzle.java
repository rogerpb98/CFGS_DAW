/* Cos principal "main" del puzle */

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
            String[] elementsComanda = resposta .split("\\s+");
            String comanda = elementsComanda[0];
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
                default: mostraErrorComandaDesconeguda();
            }
        }
        System.out.println("adèu");
        //Tests XD
        //System.out.println(extreuNomPuzleDeNomFitxer(Entrada.readLine()));
        //System.out.println(composaNomFitxerDeNomPuzle(Entrada.readLine()));
        //if (esNomFitxerDePuzleValid(Entrada.readLine())) System.out.println("true");
    }
    //moduls 09
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

    //moduls 10
    //Comprova si es un nom de puzle valid
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
    //Comprova si es un nom de fitxer valid
    public static boolean esNomFitxerDePuzleValid (String nomFitxerPuzle) {
        if (nomFitxerPuzle.isEmpty()) return false;
        if (nomFitxerPuzle.length()<11) return false;

        //El fitxer ha de començar en puzle_
        if (!(nomFitxerPuzle.substring(0,6).equals("puzle_"))) return false;

        //if (!(esNomPuzleValid(nomFitxerPuzle.substring(6,nomFitxerPuzle.length()-5)))) return false;
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
    //Mostra llista de puzles del directori actual
    public static void mostraLlista() {
        File fitxer = new File("Puzle.java");
        File carpeta = fitxer.getAbsoluteFile().getParentFile();
        String[] continguts = carpeta.list();
        Arrays.sort(continguts);
        for (int i = 0; i < continguts.length; i++) {
            String item = continguts[i];
            if (esNomFitxerDePuzleValid(item)) {
                System.out.println(extreuNomPuzleDeNomFitxer(item));
            }
        }
    }
    
    //moduls 11
    public static char[][] llegeixPuzle(String nomPuzle) throws IOException {
        //llegir totes les linies del fitxer que li entrem i posar les posicions a un array
        //Creem l'array on guardarem el taulell del fitxer
        char[][] taulell;
        taulell = new char[8][8];
        //
        String cami = composaNomFitxerDeNomPuzle(nomPuzle);
        FileReader filereader = new FileReader(cami);
        BufferedReader input = new BufferedReader(filereader);
        //Bucle que recorre l'arrai i l'emplena amb el tabler guardat al fitxer que
        //haguem passat per argument.
        for (int fila = 0; fila < taulell.length; fila++) {
            String linia = input.readLine();
            if (null==linia) break;
            for (int columna = 0; columna < taulell[fila].length; columna++) {
                taulell[fila][columna] = linia.charAt(columna);
            }
        }
        input.close();
        return taulell;
    }
    
    public static boolean existeixPuzle(String nomPuzle) {
        String nomFitxer = composaNomFitxerDeNomPuzle(nomPuzle);
        if (esNomFitxerDePuzleValid(nomFitxer)) {
            File fitxer = new File(nomFitxer);
            if (fitxer.exists()) return true;
        }
        return false;
    }
    
    /**
     * Processa la comanda show
     * @param args: arguments de la comanda
     */
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
        char[][] taulell = llegeixPuzle(nomPuzle);
        Escacs.mostraTaulell(taulell);
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
    
    //moduls 12
    public static void processaNew(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("ERROR: new «nom»");
            return;
        }
        String nomPuzle = args[1];
        if (existeixPuzle(nomPuzle)) {
            System.out.println("Ja existeix. El sobreescrivim?");
            if (UtilitatsConfirmacio.respostaABoolean(Entrada.readLine())) {
                char[][] taulell = Escacs.creaTaulellBuit();
                escriuPuzle(nomPuzle, taulell);
            }
            else {
                return;
            }
        }
        else {
            char[][] taulell = Escacs.creaTaulellBuit();
            escriuPuzle(nomPuzle, taulell);
        }
        System.out.println("fet");
    }
    public static void escriuPuzle(String nomPuzle, char[][] taulell) throws IOException {
        String cami = Puzle.composaNomFitxerDeNomPuzle(nomPuzle);
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami));
        //Bucle que recorre l'arrai i emplena un string que escriurem al fitxer
        for (int fila = 0; fila < taulell.length; fila++) {
            String linia = "";
            for (int columna = 0; columna < taulell[fila].length; columna++) {
                linia += '·';
            }
            sortida.write(linia + "\n");
        }
        sortida.close();
    }

    //moduls 13
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
}
