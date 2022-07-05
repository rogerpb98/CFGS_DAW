/*
* Exercici per practicar el dowhile
*/
public class SequenciaCreixent {
    public static void main(String[] args){
        int maxim = 0;
        int contador = 0;
        int valor = 0;
        do {
            System.out.println("Introdueix un valor ");
            valor = Integer.parseInt(Entrada.readLine());
            if (valor > maxim ) {
                maxim = valor;
                valor += 1;
                contador += 1;
            }
        } while (valor > maxim);
        System.out.println("Longitud de la següència creixent: " + contador);
    }
}
