/* classe gat renat que exten a gat, els gats renats sempre es diràn Renat 
 * implementa animal de companyia, que permet donarli mostres d'afecte 
 * tambe implemeta ensinistrable, aixi que podem dirli que canvii de posició
 */
public class GatRenat extends Gat implements AnimalDeCompanyia, Ensinistrable {
    private String posicio = "estirat";
    public GatRenat() {
        super("Renat");
    }

    public GatRenat(String posicio) {
        super("Renat");
        this.posicio = posicio;
    }

    public String getPosicio() {
        return posicio;
    }
    /****************************/
    public void setPosicio(String posicio) {
        this.posicio = posicio;
    }
    /****************************/
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

    public String deixatEstimar() {
        return "em deixo estimar";
    }
}
