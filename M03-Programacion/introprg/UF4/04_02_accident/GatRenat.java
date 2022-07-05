public class GatRenat {
    public int vides = 7;         // vides disponibles del gat Renat
    public static void main(String[] args) {
        GatRenat renat;           // declarem l'objecte (la referència) al gat
        renat = new GatRenat();   // creem la instància del gat Renat.
        System.out.println("Abans el gat Renat tenia " + renat.vides + " vides");
        renat.vides = renat.vides - 1;  // Renat ha tingut un accident
        System.out.println("Ara el gat Renat té " + renat.vides);
    }
}