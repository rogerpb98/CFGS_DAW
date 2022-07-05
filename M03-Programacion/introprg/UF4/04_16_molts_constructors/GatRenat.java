// Program that will create 4 instances of GatRenat, using the 4 possible constructors
public class GatRenat {
    private int vides = 7;
    private String posicio = "estirat";
    
    // Constructors
    public GatRenat(int vides, String posicio) {
        if (vides>0)
        this.vides = vides;
        if (posicio.equals("dret") || posicio.equals("assegut") || posicio.equals("estirat"))
        this.posicio = posicio;
    }

    public GatRenat(int vides) {
        if (vides>0)
        this.vides = vides;
        posicio = "estirat";
    }

    public GatRenat(String posicio) {
        vides = 7;
        if (posicio.equals("dret") || posicio.equals("assegut") || posicio.equals("estirat"))
        this.posicio = posicio;
    }

    public GatRenat() {
        vides = 7;
        posicio = "estirat";
    }

    public int getVides() { return vides; }
    public String getPosicio() { return posicio; }
    public void setVides(int vides) { this.vides = vides; }
    public void setPosicio(String posicio) { this.posicio = posicio; }
    
    @Override
    public String toString() {
        return String.format("Vides: %d. Posició: %s", vides, posicio);
    }

    public static void main(String[] args) {
        GatRenat[] renats = {
            new GatRenat(),
            new GatRenat(8),
            new GatRenat("dret"),
            new GatRenat(8, "dret")
        };
        for (GatRenat renat : renats) {
            System.out.println(renat);
        }
    }

    

    
}
