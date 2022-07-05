// Programa que printa nombres enters que li pasem per linea 
// de comandes entre comes utilitzant un array
// La longitud de l'array la decideix l'usuari
// Si indroduim un nombre negatiu a longitud para

public class EntersEntreComes {

    public static String emplenarString(int[] numeros) {
        String cadena="";
        for (int i = 0; i < numeros.length; i++) { //bucle que recorre l'array
            int a=i+1;
            System.out.println("Valor " + a + "?");   
            int entrada = Integer.parseInt(Entrada.readLine());
            if (i==(numeros.length-1)){
                cadena = cadena + (entrada);
            }
            else {
                cadena = cadena + (entrada) + ", ";
            }
        }
        return cadena;
    }
    public static void main(String[] args) {
        System.out.println("Quants?");
        int longitud = Integer.parseInt(Entrada.readLine());
        if (longitud < 0) {
            System.out.println("Res a fer");
        }
        else{
            int[] numeros;
            numeros = new int[longitud];
            String string = emplenarString(numeros);
            System.out.println(string);
            
        }
    }
}