/* Cos principal "main" del puzle */

import java.io.File;
import java.util.Arrays;

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
            if (comanda.equals("ls")) {
                mostraLlista();
                continue;
            }
            mostraErrorComandaDesconeguda();
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
        File carpeta = new File(".");
        //File carpeta = fitxer.getAbsoluteFile().getParentFile();
        String[] continguts = carpeta.list();
        Arrays.sort(continguts);
        for (int i = 0; i < continguts.length; i++) {
            String item = continguts[i];
            if (esNomFitxerDePuzleValid(item)) {
                System.out.println(extreuNomPuzleDeNomFitxer(item));
            }
        }
    }
}
