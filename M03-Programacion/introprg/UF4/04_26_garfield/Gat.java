/* cos principal d'un gat, amb els constructors que toquen, getters, setters, funcions per comprovar
 * el seu estat i modificar-lo
 */
public class Gat {
    private final String nom;
    private int vides;
    private String posicio;
    
    //Constructors

    public Gat(String nom) {
        if (nom==null || nom.isEmpty()||nom.isBlank())
            this.nom = "anònim";
        else
            this.nom = nom;
        vides = 7;
        posicio = "estirat";
    }

    public Gat(String nom, int vides) {
        if (nom==null || nom.isEmpty()||nom.isBlank())
            this.nom = "anònim";
        else
            this.nom = nom;
        this.vides = vides;
        posicio = "estirat";
    }

    public Gat(String nom, String posicio) {
        if (nom==null || nom.isEmpty()||nom.isBlank())
            this.nom = "anònim";
        else
            this.nom = nom;
        vides = 7;
        this.posicio = posicio;
    }

    public Gat(String nom, int vides, String posicio) {
        if (nom==null || nom.isEmpty()||nom.isBlank())
            this.nom = "anònim";
        else
            this.nom = nom;
        this.vides = vides;
        this.posicio = posicio;
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

    public String getPosicio() {
        return posicio;
    }

    public void setPosicio(String posicio) {
        this.posicio = posicio;
    }

    //Evaluators
    public boolean estaViu() {
        if (vides>0) {
            return true;
        }
        return false;
    }
    public boolean estaDret() {
        if (posicio.equals("dret")) {
            return true;
        }
        return false;
    }
    public boolean estaAssegut() {
        if (posicio.equals("assegut")) {
            return true;
        }
        return false;
    }
    public boolean estaEstirat() {
        if (posicio.equals("estirat")) {
            return true;
        }
        return false;
    }

    //Actions
    public String aixecat() {
        if (getPosicio().equals("dret"))
            return "no faig res";
        setPosicio("dret");
        return "m'aixeco";
    }
    public String seu() {
        if (getPosicio().equals("assegut"))
            return "no faig res";
        setPosicio("assegut");
        return "m'assec";
    }
    public String estirat() {
        if (getPosicio().equals("estirat"))
            return "no faig res";
        setPosicio("estirat");
        return "m'estiro";
    }
    
    public String mor() {
        if (vides>0) {
            vides--;
            if (vides==0) return "ximpún";
            return "auch";
        }
        else return "...";
    }

}
