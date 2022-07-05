package pelota;

public class Pelota {

    //Atributos
    private String propietario;
    int presion;
    private boolean operativa;

    public Pelota(String propietario) {
        this.propietario = propietario;
        this.presion = 6;
        this.operativa = true;
    }

    //Funciones

    public void inflar (int inflado) {
        if (operativa) {
            presion = presion + inflado;
        if (presion > 25) {
            presion = 0;
            operativa = false;
            }
        }
    }

    public void desinflar (int desinflado) {
        if (operativa) {
            if (presion > desinflado) {
                presion = presion - desinflado;
            } else {
                presion = 0;
            }
        }
    }

    public String botar () {
        String cadena = "";
        if (operativa) {
            if (presion <= 5)
                cadena = "La pelota de " + propietario + " hace boing-boing.";
            else
                cadena = "La pelota de " + propietario + " hace BOING-BOING.";;
        }
        else {//No operativa
            cadena = "La pelota de " + propietario + " no bota por que se ha reventado.";
        }
        return cadena;
    }



}