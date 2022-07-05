/* Exercici inicial per acabar muntant una botiga, en aquesta classe está l'estructura
 * Que definirá com es crean els vins, els requisits que tenen por poderse crear i el metode
 * Per mostrar-lo per pantalla 
 */
public class Vi {
    //Values
    private String nom;
    private int preu;
    private int estoc;
    //Constructors
    public Vi(String nom, int preu) {
        this.nom = normalitzaNom(nom);
        if (preu<0) this.preu = 0;
        else this.preu = preu;
        estoc = 0;
    }
    public Vi(String nom, int preu, int estoc) {
        this.nom = normalitzaNom(nom);
        if (preu<0) this.preu = 0;
        else this.preu = preu;
        if (estoc<0) this.estoc = 0;
        else this.estoc = estoc;
    }
    //Getters and Setters
    public String getNom() {
        return nom;
    }
    public int getPreu() {
        return preu;
    }
    public void setPreu(int preu) {
        if (preu<0) this.preu = 0;
        else this.preu = preu;
    }
    public int getEstoc() {
        return estoc;
    }
    public void setEstoc(int estoc) {
        if (estoc<0) this.estoc = 0;
        else this.estoc = estoc;
    }
    //Methods
    public static String normalitzaNom(String nom) {
        if (nom==null || nom.isEmpty()||nom.isBlank())
            return "nom no vàlid";
        nom = nom.strip();
        nom = nom.replaceAll("( )+", " ");
        return nom;
    }
    
    @Override
    public String toString() {
        return String.format("%n\tVi: %s%n\tPreu: %d%n\tEstoc: %d%n",
        nom, preu, estoc);
    }

    public static Vi deArrayString(String[] ArrayVinsString) {
        //Si l'array no te la mida correcta retorna null
        if (ArrayVinsString.length!=3) return null;
        //Si el nom es incorrecte retorna null
        if (ArrayVinsString[0]==null || ArrayVinsString[0].isEmpty()||ArrayVinsString[0].isBlank()) return null;
        //Si el preu no es enter positiu retorna null
        if (!(UtilString.esEnterPositiu(ArrayVinsString[1]))) return null;
        //Si l'estoc no es enter positiu retorna null
        if (!(UtilString.esEnterPositiu(ArrayVinsString[2]))) return null;
        //Sino, assigna els valors a les variables corresponents per millorar llegibilitat
        String nouNom = normalitzaNom(ArrayVinsString[0]);
        int nouPreu = Integer.parseInt(ArrayVinsString[1].strip());
        int nouEstoc = Integer.parseInt(ArrayVinsString[2].strip());
        return new Vi(nouNom, nouPreu, nouEstoc);
    }
    public String[] aArrayString() {
        String[] arrayARetornar = new String[3];
        arrayARetornar[0]=nom;
        arrayARetornar[1]=String.valueOf(preu);
        arrayARetornar[2]=String.valueOf(estoc);
        return arrayARetornar;
    }
}
