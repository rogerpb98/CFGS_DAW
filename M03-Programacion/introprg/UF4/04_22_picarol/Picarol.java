/* classe del picarol */
public class Picarol {
    private int cops;

    public Picarol() {
        cops = 0;
    }
    public Picarol(int repetides) {
        cops = repetides;
    }

    public void sona() {
        System.out.println("clink-clink");
        cops++;
    }
    public int quantsCops() {
        return cops;
    }
}
