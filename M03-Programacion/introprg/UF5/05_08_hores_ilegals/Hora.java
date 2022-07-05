// Program that given an hour, can increase or decrease the seconds by 1 or the amount given
// Implements validation for the arguments received on the constructor,
// methods for comparing 2 hours, methods for duplicating an instance
public class Hora {
    private int hores;
    private int minuts;
    private int segons;

    public Hora() {
        hores = 0;
        minuts = 0;
        segons = 0;
    }
    public Hora(int hores, int minuts, int segons) throws IllegalArgumentException {
        this.setHores(hores);
        this.setMinuts(minuts);
        this.setSegons(segons);
    }

    public int getHores() {
        return hores;
    }
    public int getMinuts() {
        return minuts;
    }
    public int getSegons() {
        return segons;
    }

    public void setHores(int hores) throws IllegalArgumentException {
        if (hores>=0 && hores<24)
            this.hores = hores;
        else {
            throw new IllegalArgumentException("hores fora de rang: "+hores);
        }
    }

    public void setMinuts(int minuts) throws IllegalArgumentException {
        if (minuts>=0 && minuts<60)
            this.minuts = minuts;
        else {
            throw new IllegalArgumentException("minuts fora de rang: "+minuts);
        }
    }

    public void setSegons(int segons) throws IllegalArgumentException {
        if (segons>=0 && segons<60)
            this.segons = segons;
        else {
            throw new IllegalArgumentException("segons fora de rang: "+segons);
        }
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d", hores, minuts, segons);
    }
}
