import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Log {
    public static int escriptures = 1;
    public static void printError(String args) throws IOException {
        String cami = "log.txt";
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami, true));
        sortida.write("[" + escriptures +  "] ERROR: " + args + System.lineSeparator());
        escriptures++;
        sortida.close();
    }
    public static void printWarning(String args) throws IOException {
        String cami = "log.txt";
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami, true));
        sortida.write("[" + escriptures +  "] WARNING: " + args + System.lineSeparator());
        escriptures++;
        sortida.close();
    }
    public static void printInfo(String args) throws IOException {
        String cami = "log.txt";
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami, true));
        sortida.write("[" + escriptures +  "] INFO: " + args + System.lineSeparator());
        escriptures++;
        sortida.close();
    }
    public static void reset() throws IOException {
        escriptures = 1;
    }
    public static void printDebug(String args) throws IOException {
        String cami = "log.txt";
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami, true));
        sortida.write("[" + escriptures +  "] DEBUG: " + args + System.lineSeparator());
        escriptures++;
        sortida.close();
    }
}
