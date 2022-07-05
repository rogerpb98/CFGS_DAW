public class BotigaPlenaException extends Exception{
    public BotigaPlenaException() {
        super("Botiga plena");
    }
    public BotigaPlenaException(String missatge) {
        super(missatge);
    }
}
