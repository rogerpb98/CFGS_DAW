/* Cos del Gat, amb els seus getters, setters i constructors */
public class Gat {
    private int vides = 7;
    private String posicio = "estirat";
    public Gat() {
    }
    public Gat(int vides) {
        this.vides = vides;
    }
    public Gat(String posicio) {
        this.posicio = posicio;
    }
    public Gat(int vides, String posicio) {
        this.vides = vides;
        this.posicio = posicio;
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
}
