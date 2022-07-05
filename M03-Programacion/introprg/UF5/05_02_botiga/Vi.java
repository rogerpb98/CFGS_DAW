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
}
