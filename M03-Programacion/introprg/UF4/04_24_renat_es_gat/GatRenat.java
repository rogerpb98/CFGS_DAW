/* Cos del Gat Renat, amb els seus getters, setters i constructor, tant com les funcions 
 * per saber el seu estat
 */
public class GatRenat extends Gat {
    public GatRenat() {
    }
    
    public boolean estaViu() {
        if (getVides()>0) {
            return true;
        }
        return false;
    }
    public boolean estaDret() {
        if (getPosicio().equals("dret")) {
            return true;
        }
        return false;
    }
    public boolean estaAssegut() {
        if (getPosicio().equals("assegut")) {
            return true;
        }
        return false;
    }
    public boolean estaEstirat() {
        if (getPosicio().equals("estirat")) {
            return true;
        }
        return false;
    }
    public String aixecat() {
        if (!getPosicio().equals("dret")) {
            setPosicio("dret");
            return "m'aixeco";
        }
        return "no faig res";
    }
    public String seu() {
        if (!getPosicio().equals("assegut")) {
            setPosicio("assegut");
            return "m'assec";
        }
        return "no faig res";
    }
    public String estirat() {
        if (!getPosicio().equals("estirat")) {
            setPosicio("estirat");
            return "m'estiro";
        }
        return "no faig res";
    }
}
