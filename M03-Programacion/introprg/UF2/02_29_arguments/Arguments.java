/*Programa que ens diu si cada argument que tingui el programa es enter o no*/
public class Arguments {
    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("Cap argument");
        }
        else {
            int longitud = args.length;
            for (int i=0; i<longitud; i++) {
                if (UtilString.esEnter(args[i])) {
                    System.out.println("[" + i + "] \"" + args[i] + "\": és enter");
                }
                else {
                    System.out.println("[" + i + "] \"" + args[i] + "\": no és enter");
                }
            }
        }
    }
}
