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
/*
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        System.out.println("Vides inicials: " + renat.getVides());
        System.out.println("Posició inicial: " + renat.getPosicio());
        renat.setPosicio();
        System.out.println("Posició final: " + renat.getPosicio());
    }*/
}
