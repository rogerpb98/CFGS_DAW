public class UsaGatRenat {
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        System.out.println("Vides inicials: " + renat.getVides());
        System.out.println("Posició inicial: " + renat.getPosicio());
        System.out.println("Introdueix nova posició:");
        String nouPosicio=Entrada.readLine();
        renat.setPosicio(nouPosicio);
        System.out.println("Posició final: " + renat.getPosicio());
    }
}
