// Program that given an hour, can increase or decrease the seconds by 1 or the amount given
// Implements validation for the arguments received on the constructor,
// methos for comparing 2 hours, methods for duplicating an instance
public class Hora {
    private int hores = 0;
    private int minuts = 0;
    private int segons = 0;

    public Hora() {}

    public Hora(int hores, int minuts, int segons) {
        if (esValida(hores, minuts, segons)) {
            this.hores = hores;
            this.minuts = minuts;
            this.segons = segons;
        }
    }

    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }

    public int getMinuts() {
        return minuts;
    }

    public void setMinuts(int minuts) {
        this.minuts = minuts;
    }

    public int getSegons() {
        return segons;
    }

    public void setSegons(int segons) {
        this.segons = segons;
    }

    public int comptarSegons() {
        return (hores*60+minuts)*60+segons; // Retorna els segons totals
    }

    public void incrementa() {
        int increment = 1;
        // convertir hores/minuts/segons a segons
        int segonsTotals = comptarSegons();
        segonsTotals+=increment; //incrementar els segons en 1
        // Convertir els segons a minuts i els minuts a hores (arrodonint a la baixa)
        int minutsTotals = Math.floorDiv(segonsTotals, 60);
        int horesTotals = Math.floorDiv(minutsTotals, 60);

        this.segons = segonsTotals%60;
        this.minuts = minutsTotals%60;
        this.hores = horesTotals;

        if (hores==24) this.hores=0; // a les 24h passen a ser les 0h
    }

    public void incrementa(int increment) {
        if (increment>0)
        for (int i = 0; i < increment; i++) {
            incrementa();
        }
        else decrementa(Math.abs(increment));
    }

    public void decrementa() {
        // quan passa de les 0:00:00 torna a 23:59:59
        if (hores==0 && minuts==0 && segons==0) {
            this.hores=23;
            this.minuts = 59;
            this.segons = 59;
            return;
        }
        int decrement=1;
        // convertir hores/minuts/segons a segons
        int segonsTotals = comptarSegons();
        segonsTotals-=decrement; // decrementar els segons en 1
        int minutsTotals = Math.floorDiv(segonsTotals, 60);
        int horesTotals = Math.floorDiv(minutsTotals, 60);

        this.segons = segonsTotals%60;
        this.minuts = minutsTotals%60;
        this.hores = horesTotals;
    }

    public void decrementa(int decrement) {
        if (decrement>0)
        for (int i = 0; i < decrement; i++) {
            decrementa();
        }
        else incrementa(Math.abs(decrement));
    }

    public int compareTo(Hora rellotje) {
        if (this.comptarSegons()>rellotje.comptarSegons()) {
            return 1;
        }
        else if (this.comptarSegons()<rellotje.comptarSegons()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d", hores, minuts, segons);
    }

    // Exercici 19
    public static boolean esValida(int hores, int minuts, int segons) {
        /*if (hores <= 0 || hores >= 23) return false;
        if (minuts <= 0 || minuts >= 59) return false;
        if (segons <= 0 || segons >= 59) return false;
        return true;*/

        return  hores >= 0 && hores <=23 &&     // Si es cumpleixen totes les condicions
                minuts >= 0 && minuts <=59 &&   // el return serà un true
                segons >= 0 && segons <=59;     // sino sera un false
    }
    public static int compareTo(Hora rellotje1, Hora rellotje2) {
        if (rellotje1.comptarSegons()>rellotje2.comptarSegons()) {
            return 1;
        }
        else if (rellotje1.comptarSegons()<rellotje2.comptarSegons()) {
            return -1;
        }
        return 0;
    }
    public Hora duplica() {
        Hora duplicat = new Hora(this.getHores(), this.getMinuts(), this.getSegons());
        return duplicat;
    }
    public static Hora duplica(Hora rellotje1) {
        Hora duplicat = new Hora(rellotje1.getHores(), rellotje1.getMinuts(), rellotje1.getSegons());
        return duplicat;
    }

    /**
     * Compara dues hores i retorna l'operador corresponent
     * Per exemple, si hora1 és menor que hora2, l'operador serà "<". Els
     * altres dos valors possibles són ">" i "=="
     * @param hora1: primera hora a comparar
     * @param hora2: segona hora a comparar
     * @return operador resultant
     */
    private static String composaOperadorComparacio(Hora hora1, Hora hora2) {
        int comparacio = hora1.compareTo(hora2);
        if (comparacio < 0) {
            return "<";
        } else if (comparacio > 0) {
            return ">";
        } else {
            return "==";
        }
    }

    public static void main(String[] args) {
        Hora hora1 = new Hora();
        Hora hora2 = new Hora(0, 0, 2);
        System.out.printf("Inicialment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);
        System.out.println("Incrementem 1 segon a la primera i decrementem 1 segon a la segona");
        hora1.incrementa();
        hora2.decrementa();
        System.out.printf("Finalment hora1: %s %s hora2: %s%n",
                hora1,
                composaOperadorComparacio(hora1, hora2),
                hora2);

    }

    
}
