
/*
 * programa que demana un nombre positiu més gran que 0. El programa escriurà una línia 
 * per nombre entre el nombre introduït i el 1 (és a dir, decreixentment). 
 * A cada línia escriurà tots els nombres des de l’1 fins el nombre corresponent a la línia.
 */
public class TriangleInvertit {
    public static void main(String[] args) {
        System.out.println("Nombre?");
        int valorFinal = Integer.parseInt(Entrada.readLine());
        if (valorFinal < 1) {
            System.out.println();
        }
        else{
            for (int linia=1; linia <= valorFinal; linia++) {
                int valor = 0;
                for (int columna=linia; columna <= valorFinal; columna++) {
                    valor = valor + 1;
                    System.out.print(valor);
                    if (valor != (valorFinal + 1 - linia)) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }
}
