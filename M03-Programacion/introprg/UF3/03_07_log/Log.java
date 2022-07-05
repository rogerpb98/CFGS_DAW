import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Log {
    public static int escriptures = 1;
    public static String printError(String args) throws IOException {
        String patata = "[" + escriptures +  "] ERROR: " + args ;
        escriptures++;
        return patata;
        
    }
    public static String printWarning(String args) throws IOException {
        String patata = "[" + escriptures +  "] WARNING: " + args ;
        escriptures++;
        return patata;
    }
    public static String printInfo(String args) throws IOException {
        String patata = "[" + escriptures +  "] INFO: " + args ;
        escriptures++;
        return patata;
    }
    public static void reset() throws IOException {
        escriptures = 1;
    }
    public static String printDebug(String args) throws IOException {
        String patata = "[" + escriptures +  "] DEBUG: " + args ;
        escriptures++;
        return patata;
    }
}
