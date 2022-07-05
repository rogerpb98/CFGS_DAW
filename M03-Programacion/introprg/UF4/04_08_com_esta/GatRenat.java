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
}
