/* Cos principal de Garfield que exten a Gat, no pot tenir mes de 9 vides i 
 * et respon malament amb cerca condicio
 */
public class Garfield extends Gat {
    public Garfield() {
        super("Garfield", 9, "estirat");
    }

    @Override
    //Les vides de Garfield mai poden superar 9
    public void setVides(int vides) {
        if (vides <= 9 && vides >= 0) 
            super.setVides(vides);
    }

    @Override
    public String aixecat() {
        if (getPosicio().equals("dret"))
            return "no faig res";
        else if (getPosicio().equals("assegut")) {
            setPosicio("dret");
            return "m'aixeco";
        }
        return "Bai Maitea, bai";
    }
    @Override
    public String estirat() {
        if (getPosicio().equals("estirat"))
            return "no faig res";
        else if (getPosicio().equals("assegut")) {
            setPosicio("estirat");
            return "m'estiro";
        }
        return "Bai Maitea, bai";
    }
}
