// Program that given an hour, can increase or decrease the seconds by 1 or the amount given
// Implements validation for the arguments received on the constructor,
// methos for comparing 2 hours, methods for duplicating an instance
import java.util.Random;
public class Hora {
    private int hores;
    private int minuts;
    private int segons;

    public Hora() {
        hores = 0;
        minuts = 0;
        segons = 0;
    }

    public int getHores() {
        return hores;
    }

    public boolean setHores(int hores) {
        if (hores<0 || hores >23) 
            return false;
        this.hores = hores;
        return true;
    }

    public int getMinuts() {
        return minuts;
    }

    public boolean setMinuts(int minuts) {
        if (minuts<0 || minuts >59) 
            return false;
        this.minuts = minuts;
        return true;
    }

    public int getSegons() {
        return segons;
    }

    public boolean setSegons(int segons) {
        if (segons<0 || segons >59) 
            return false;
        this.segons = segons;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d", hores, minuts, segons);
    }
}
