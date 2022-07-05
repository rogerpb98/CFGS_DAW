/* Cos de Ull de Gat que s'encarregara de crear-li els ulls als gats i gestionar quan s'obren
 * o es tanquen
 */
public class UllDeGat {
    private boolean estatUll;

    public UllDeGat() {
        estatUll = false;
    }
    public UllDeGat(boolean posicio) {
        if (posicio)
            estatUll = true;
        else 
            estatUll = false;
    }
    
    public void obret() {
        if (estatUll)
            return;
        estatUll = true;
    }
    public void tancat() {
        if (!estatUll)
            return;
        estatUll = false;
    }
    public boolean estaObert() {
        if (estatUll) 
            return true;
        return false;
    }


    @Override
    public String toString() {
        return "UllDeGat [estatUll=" + estatUll + "]";
    }
}
