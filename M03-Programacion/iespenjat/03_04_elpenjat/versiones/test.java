import java.io.IOException;

public class test{
    public static void main(String[] args) throws IOException{
        String paraula = ""; 
        String paraula1 = "A";
        String paraula2 = "A i B";
        String paraula3 = "A, B, C i D";
        String paraula4 = "A, B, C, D, E i F";
        
        System.out.println(UtilString.formataUtilitzades(paraula, 'a') + " --- Esperado: A");
        System.out.println(UtilString.formataUtilitzades(paraula1, 'b') + " --- Esperado: A i B");
        System.out.println(UtilString.formataUtilitzades(paraula2, 'c') + " --- Esperado: A, B i C");
        System.out.println(UtilString.formataUtilitzades(paraula3, 'f') + " --- Esperado: A, B, C, D i F");
        System.out.println(UtilString.formataUtilitzades(paraula4, 'g') + " --- Esperado: A, B, C, D, E, F i G");

    }
}
