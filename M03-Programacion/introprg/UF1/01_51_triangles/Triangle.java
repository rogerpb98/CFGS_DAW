/*
* Programa que mostra tanta triangles com li indiquem utilitzant recorreguts niuats.
*/
public class Triangle {
    public static void main(String[] args) {
        // obtenir nombre de triangles
        System.out.println("quants?");
        int triangles = Integer.parseInt(Entrada.readLine());
    
        for (int triangle=0; triangle<triangles; triangle++) {
            //dibuixar triangle
            for (int linia=9; linia >=0; linia--) {
                //dibuixar puntets
                for (int columna=1; columna<=linia; columna++) {
                    System.out.print('.');
                }
                //dibuixar numeros creixents
                for (int columna=linia; columna<=9; columna++) {
                    System.out.print(columna);
                }
                //dibuixar numeros decreixents
                for (int columna=8; columna>=linia; columna--) {
                    System.out.print(columna);
                }
                for (int columna=1; columna<=linia; columna++) {
                    System.out.print('.');
                }
                System.out.println();
            }
        }
    }
}
