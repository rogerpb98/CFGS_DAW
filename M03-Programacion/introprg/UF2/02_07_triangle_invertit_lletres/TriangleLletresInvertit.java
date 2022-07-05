
/*
 * programa que demana una paraula i la mostra lletra per lletra amb una 
 * coma intercalada excepte la última (invertit)
 */
public class TriangleLletresInvertit {

    public static void dibuixaLinia(String texte, int linia) {
        for (int columna=linia; columna >= 1; columna--) {
            System.out.print(texte.charAt(columna-1));
            if (columna != 1) {
                System.out.print(", ");
            }
        }
        
    }

    public static void dibuixaTriangle(String texte) {
        int valorFinal = texte.length();
        for (int linia=valorFinal; linia >= 1; linia--) {
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
