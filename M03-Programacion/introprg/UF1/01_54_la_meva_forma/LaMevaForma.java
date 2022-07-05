/*
* Programa que ens deixarà escullir entre un trapezi i un hexagon, un cop escollit, ens demanarà l'amplada i 
* la quantitat que volem i ens les mostratà per pantalla.
*/
public class LaMevaForma {
    public static void main(String[] args) {

        System.out.println("Triangle (t) o hexagon (h)?");
        String forma = (Entrada.readLine());

        if (forma.equals("t")) {
            // obtenir nombre de trapezis
            System.out.println("quants?");
            int triangles = Integer.parseInt(Entrada.readLine());

            // obtenir amplada de la part superior
            System.out.println("amplada?");
            int amplada = Integer.parseInt(Entrada.readLine());
        
            for (int triangle=0; triangle<triangles; triangle++) {
                //dibuixar trapezi
                for (int linia=9; linia >=0; linia--) {
                    //dibuixar puntets
                    for (int columna=1; columna<=linia; columna++) {
                        System.out.print('.');
                    }
                    //rampa de pujada
                    for (int columna=linia; columna<=9; columna++) {
                        System.out.print("*");
                    }
                    //amplada
                    for (int columna=amplada-2; columna>=0; columna--) {
                        System.out.print("*");
                    }
                    //rampa de baixada
                    for (int columna=8; columna>=linia; columna--) {
                        System.out.print("*");
                    }
                    for (int columna=1; columna<=linia; columna++) {
                        System.out.print('.');
                    }
                    System.out.println();
                }
            }
        }

        else if (forma.equals("h")) {
            // obtenir nombre de hexagons
            System.out.println("quants?");
            int rombos = Integer.parseInt(Entrada.readLine());

            // obtenir amplada de la part superior
            System.out.println("amplada?");
            int amplada = Integer.parseInt(Entrada.readLine());

            //dibuixar hexagon
            for (int rombo=0; rombo<rombos; rombo++) {
                for (int triangle=0; triangle<1; triangle++) {
                    //dibuixar meitat superior
                    for (int linia=9; linia >=0; linia--) {
                        //dibuixar puntets
                        for (int columna=1; columna<=linia; columna++) {
                            System.out.print('.');
                        }
                        //rampa de pujada
                        for (int columna=linia; columna<=9; columna++) {
                            System.out.print("*");
                        }
                        //amplada
                        for (int columna=amplada-2; columna>=0; columna--) {
                            System.out.print("*");
                        }
                        //rampa de baixada
                        for (int columna=8; columna>=linia; columna--) {
                            System.out.print("*");
                        }
                        for (int columna=1; columna<=linia; columna++) {
                            System.out.print('.');
                        }
                        System.out.println();
                    }
                }
                for (int triangle=0; triangle<1; triangle++) {
                    //dibuixar meitat inferior
                    for (int linia=1; linia <=9; linia++) {
                        //dibuixar puntets
                        for (int columna=1; columna<=linia; columna++) {
                            System.out.print('.');
                        }
                        //dibuixar numeros creixents
                        for (int columna=linia; columna<=9; columna++) {
                            System.out.print("*");
                        }
                        //amplada
                        for (int columna=amplada-2; columna>=0; columna--) {
                            System.out.print("*");
                        }
                        //dibuixar numeros decreixents
                        for (int columna=8; columna>=linia; columna--) {
                            System.out.print("*");
                        }
                        for (int columna=1; columna<=linia; columna++) {
                            System.out.print('.');
                        }
                        System.out.println();
                    }
                }
            }
        }
        else {
            System.out.println("Opció inexistent.");
        }
    }
}
