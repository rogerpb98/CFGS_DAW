/* classe gat renat que exten a gat, els gats renats sempre es diràn Renat */
public class GatRenat extends Gat {
    public GatRenat() {
        super("Renat");
    }

    public GatRenat(int vides) {
        super("Renat", vides);
    }

    public GatRenat(String posicio) {
        super("Renat", posicio);
    }

    public GatRenat(int vides, String posicio) {
        super("Renat", vides, posicio);
    }
}
