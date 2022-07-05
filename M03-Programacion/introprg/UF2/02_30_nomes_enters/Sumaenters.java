/*Programa que ens diu si cada argument que tingui el programa es enter o no*/
public class Sumaenters {
    public static int[] filtraEnters(String[] valors){
        int longitud = valors.length;
        int[] enters = new int[valors.length];
        for (int i=0; i<longitud; i++) {
            if (UtilString.esEnter(valors[i])) {
                enters[i] = Integer.parseInt(valors[i]);
            }
            else {
                System.out.println("[" + i + "] \"" + valors[i] + "\": no és enter");
            }
        }
        return enters;
    }
    
    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("Cap argument");
        }
        else {
            int[] enters = filtraEnters(args);
            System.out.println(enters);
        }
    }
}
