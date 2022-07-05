/* Cos principal d'un gat
 * Es un ésser viu, per lo tant pot morir i ressuscitar.
 */
public class Gat implements EsserViu {
    private final String nom;
    private int vides;
    
    //Constructors

    public Gat(String nom) {
        if (nom==null || nom.isEmpty()||nom.isBlank())
            this.nom = "anònim";
        else
            this.nom = nom;
        vides = 7;
    }

    public Gat(String nom, int vides) {
        if (nom==null || nom.isEmpty()||nom.isBlank())
            this.nom = "anònim";
        else
            this.nom = nom;
        this.vides = vides;
    }
    
    //Getters and Setters
    public String getNom() {
        return nom;
    }

    public int getVides() {
        return vides;
    }

    public void setVides(int vides) {
        this.vides = vides;
    }

    //Evaluators
    public boolean estaViu() {
        if (vides>0) {
            return true;
        }
        return false;
    }
    
    public String mor() {
        if (vides>0) {
            vides--;
            if (vides==0) return "adéu món cruel";
            return "adéu món cruel";
        }
        else return "ja l'he palmada";
    }

    public String ressuscita() {
        if (vides==0) {
            vides++;
            return "guai!";
        }
        else return "encara visc";
    }
}
