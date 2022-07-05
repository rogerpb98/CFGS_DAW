/* Cos de Gat Renat amb totes les seves funcions, getters, setters etc i un main per executar-lo */
public class GatRenat {
    private String posicio = "estirat";
    private UllDeGat ullDret;
    private UllDeGat ullEsquerre;
    
    public GatRenat() { 
        ullDret = new UllDeGat(false);
        ullEsquerre = new UllDeGat(false);
    }
    //dubte no em passa les proves que fan servir aquest constructor
    public GatRenat(String posicioInicial) {
        if (posicioInicial.equals("estirat")) {
            posicio = posicioInicial;
            ullDret = new UllDeGat(false);
            ullEsquerre = new UllDeGat(false);
        }
        else if (posicioInicial.equals("assegut")) {
            posicio = posicioInicial;
            ullDret = new UllDeGat(true);
            ullEsquerre = new UllDeGat(false);
        }
        else if (posicioInicial.equals("dret")) {
            posicio = posicioInicial;
            ullDret = new UllDeGat(true);
            ullEsquerre = new UllDeGat(true);
        }
    }
    public GatRenat(String posicioInicial, boolean esperatDret, boolean esperatEsquerre) {
        posicio = posicioInicial;
        ullDret = new UllDeGat(esperatDret);
        ullEsquerre = new UllDeGat(esperatEsquerre);
    }
    public UllDeGat getUllDret() {
        UllDeGat copiaUllDret = new UllDeGat(ullDret.estaObert());
        return copiaUllDret;
    }
    public UllDeGat getUllEsquerre() {
        UllDeGat copiaUllEsquerre = new UllDeGat(ullEsquerre.estaObert());
        return copiaUllEsquerre;
    }
    public String getPosicio() {
        return posicio;
    }

    public String aixecat() {
        if (posicio.equals("dret"))
            return "no faig res";
        ullDret.obret();
        ullEsquerre.obret();
        posicio="dret";
        return "m'aixeco";
    }
    public String seu() {
        if (posicio.equals("assegut"))
            return "no faig res";
        ullDret.obret();
        ullEsquerre.tancat();
        posicio="assegut";
        return "m'assec";
    }
    public String estirat() {
        if (posicio.equals("estirat"))
            return "no faig res";
        ullDret.tancat();
        ullEsquerre.tancat();
        posicio="estirat";
        return "m'estiro";
    }

    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        UllDeGat ullDret = renat.getUllDret();
        UllDeGat ullEsquerre = renat.getUllEsquerre();
        
        System.out.printf("Quan està %s: %b + %b%n",
                renat.getPosicio(),
                renat.getUllDret().estaObert(),
                renat.getUllEsquerre().estaObert());

        renat.seu();
        System.out.printf("Quan està %s: %b + %b%n",
                renat.getPosicio(),
                renat.getUllDret().estaObert(),
                renat.getUllEsquerre().estaObert());

        renat.aixecat();
        System.out.printf("Quan està %s: %b + %b%n",
                renat.getPosicio(),
                renat.getUllDret().estaObert(),
                renat.getUllEsquerre().estaObert());
    }
    


    
}
