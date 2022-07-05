public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";

    public int getVides() {
        return vides;
    }
    public void setVides(int novesVides) {
        if (novesVides >= 0) {
            vides = novesVides;
        }
    }
    public String getPosicio() {
        return posicio;
    }
    public void setPosicio(String novaPosicio) {
        if (novaPosicio.equals("dret") || novaPosicio.equals("assegut") || novaPosicio.equals("estirat")) {
            posicio = novaPosicio;
        }
    }
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
    public String aixecat() {
        if (!posicio.equals("dret")) {
            posicio = "dret";
            return "m'aixeco";
        }
        return "no faig res";
    }
    public String seu() {
        if (!posicio.equals("assegut")) {
            posicio = "assegut";
            return "m'assec";
        }
        return "no faig res";
    }
    public String estirat() {
        if (!posicio.equals("estirat")) {
            posicio = "estirat";
            return "m'estiro";
        }
        return "no faig res";
    }
    public String mor() {
        if (vides>0) {
            vides--;
            if (vides==0) return "ximpún";
            return "auch";
        }
        else return "...";
    }
    public String resuscita() {
        if (vides==0) {
            vides++;
            return "guai!";
        }
        else return "...";
    }
    public String resuscita(int augment) {
        if (vides==0) {
            if (augment<1) return "...";
            vides+=augment;
            return "guai!";
        }
        else return "...";
    }
}
