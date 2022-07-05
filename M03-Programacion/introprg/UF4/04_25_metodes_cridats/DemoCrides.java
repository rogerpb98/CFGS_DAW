/* Main del programa que s'encarregarà de fer d'interficie per utilitzar les classes Gat, Feli, Menjar i GatRenat */
public class DemoCrides {
    public static void main(String[] args) {
        Feli feli = new Feli();
        Gat gat = new Gat();
        GatRenat renat = new GatRenat();
        feli.netejaUrpes();
        gat.netejaUrpes();
        renat.netejaUrpes();
        gat.miola();
        renat.miola();
        Menjar bacalla = new Menjar("bacallà");
        renat.menja(bacalla);
    }
/*
Neix Feli
Neix Feli
Neix Gat
Neix Feli
Neix Gat
Neix Renat
Feli neteja urpes des de class Feli
Feli neteja urpes des de class Gat
Feli neteja urpes des de class GatRenat
Gat miola des de class Gat
Renat miola des de class GatRenat
Neix Menjar("bacallà")
Renat menja bacallà des de class GatRenat
Feli neteja urpes des de class GatRenat
Gat menja bacallà des de class GatRenat
Feli menja bacallà des de class GatRenat
*/
}
