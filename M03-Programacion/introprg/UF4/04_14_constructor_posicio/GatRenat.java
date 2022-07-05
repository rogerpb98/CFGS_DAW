// Program that will show the state of "renat" inicialized with a constructor through the CLI
public class GatRenat {
    private int vides;
    private String posicio = "estirat";
    public GatRenat(int novesVides, String novaPosicio) {
        vides = novesVides;
        if (novaPosicio.equals("dret") || novaPosicio.equals("assegut") || novaPosicio.equals("estirat"))
        posicio = novaPosicio;
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
        System.out.println(new GatRenat(7, "dret"));
    }

    
}
