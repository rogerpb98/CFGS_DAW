public class Felí {
    private int legs = 4;
    private int eyes = 2;
    private int tail = 1;

    public void caça(Animal presa) {
        this.sound();
        System.out.println("Ha caçat un " + presa.getEspecie());
    }
}