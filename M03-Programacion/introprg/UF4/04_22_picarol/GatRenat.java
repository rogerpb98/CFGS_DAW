/* Gat Renat amb un picarol que sona amb els moviments del gat */
public class GatRenat {
    private String posicio;
    private Picarol picarol;
    
    public GatRenat() { 
        posicio = "estirat";
    }
    public GatRenat(String posicioInicial) { 
        posicio = posicioInicial;
    }
    public String getPosicio() {
        return posicio;
    }
    public void setPosicio(String novaPosicio) {
        posicio = novaPosicio;
    }

    public String aixecat() {
        if (posicio.equals("dret"))
            return "no faig res";
        setPosicio("dret");
        if (tePicarol())
            picarol.sona();
        return "m'aixeco";
    }
    public String seu() {
        if (posicio.equals("assegut"))
            return "no faig res";
        setPosicio("assegut");
        if (tePicarol())
            picarol.sona();
        return "m'assec";
    }
    public String estirat() {
        if (posicio.equals("estirat"))
            return "no faig res";
        setPosicio("estirat");
        if (tePicarol())
            picarol.sona();
        return "m'estiro";
    }

    public Picarol posaPicarol(Picarol nouPicarol) {
        if (tePicarol()) {
            Picarol anteriorPicarol = picarol;
            picarol = nouPicarol;
            return anteriorPicarol;
        }
        picarol = nouPicarol;
        return null;
    }
    public Picarol treuPicarol() {
        if (tePicarol()) {
            Picarol picarolARetornar = picarol;
            picarol = null;
            return picarolARetornar;
        }
        return null;
    }
    public boolean tePicarol() {
        if (picarol == null) 
            return false;
        return true;
    }

    public static void main(String[] args) {
        Picarol picarol = new Picarol();
        picarol.sona();   // el picarol funciona fins i tot sense gat!
        GatRenat renat = new GatRenat();
        renat.aixecat();
        renat.posaPicarol(picarol);
        renat.seu();      // ha de sonar el picarol
        renat.seu();      // no sona el picarol doncs no es mou!
        renat.treuPicarol();
        renat.estirat();  // no sona el picarol doncs ja no el té
        System.out.println("Nombre de cops que sona el picarol: " + picarol.quantsCops());
    }
}
