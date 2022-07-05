public class GatRenat {
    public int vides = 7;         // vides disponibles del gat Renat
    public static void main(String[] args) {
        GatRenat renat;           // declarem la referència al gat
        renat = new GatRenat();   // creem la instància del gat Renat.
        System.out.println("Al gat Renat li queden " + renat.vides + " vides");
    }
}