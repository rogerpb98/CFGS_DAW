/*
 * Demostració d'ús del mòdul de Log
 */
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class UsaLog {
    public static void main(String[] args) throws IOException {
        
        String cami = "log.txt";
        BufferedWriter sortida = new BufferedWriter(new FileWriter(cami, true));
        String errorLog = Log.printError("Això és un error greu");
        sortida.write(errorLog + "\n");
        //escriptures++;
        String avisLog = Log.printWarning("Això és un avís");
        sortida.write(avisLog + "\n");
        //escriptures++;
        for (int i=0; i < args.length; i++) {
            String infoLog = Log.printInfo(String.format("Argument %d: %s", i, args[i]));
            sortida.write(infoLog + "\n");
            //escriptures++;
        }
        Log.reset();     // comencem a comptar un altre cop
        String debugLog = Log.printDebug("Aquí s'acaba el main()");
        sortida.write(debugLog + "\n");
        //escriptures++;
        sortida.close();
    }
}
