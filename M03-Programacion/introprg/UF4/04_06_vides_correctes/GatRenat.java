public class GatRenat {
    private int vides = 7;
    public int getVides() {  //  retorna el nombre de vides
        return vides;
    }
    public void setVides(int novesVides) {   // modifica el nombre de vides si ens donen un de vàlid
        if (novesVides >= 0) {
            vides = novesVides;
        }
    }
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        renat.vides = -12;
        System.out.println("El gat Renat té " + renat.vides + " vides");
    }
}