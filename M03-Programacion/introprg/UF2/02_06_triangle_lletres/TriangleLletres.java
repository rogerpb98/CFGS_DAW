
/*
 * programa que demana una paraula i la mostra lletra per lletra amb una coma intercalada excepte la última
 */
public class TriangleLletres {

    public static void dibuixaLinia(String texte, int linia) {
        for (int columna=1; columna <= linia; columna++) {
            System.out.print(texte.charAt(columna-1));
            if (columna != linia) {
                System.out.print(", ");
            }
        }
        
    }

    public static void dibuixaTriangle(String texte) {
        int valorFinal = texte.length();
        for (int linia=1; linia <= valorFinal; linia++) {
            dibuixaLinia(texte, linia);
            
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        System.out.println("Text?");
        String texte = Entrada.readLine();
        
        dibuixaTriangle(texte);
        
        
    }
}
