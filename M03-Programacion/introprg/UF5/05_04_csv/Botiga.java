/* Segon exercici per acabar muntant una botiga, en aquesta classe está l'estructura
 * Que definirá com es crean les botigues, els requisits que tenen por poderse crear i els metodes
 * Per afegir-cercar-eliminar vins d'aquestes.
 */
public class Botiga {
    private final int DEFAULT_MAX_VINS = 100;
    private Vi[] vins;
    private int indice;
    public Botiga() {
        vins = new Vi[DEFAULT_MAX_VINS];
    }
    public Botiga(int maxVins) {
        if(maxVins>0)
            vins = new Vi[maxVins];
        else
            vins = new Vi[DEFAULT_MAX_VINS];
    }

    public Vi afegeix(Vi vi) {
        //Si no existeix un vi igual a l'array de vins procedeix
        if (!(existeixVi(vi.getNom()))) {
            for (int i = 0; i < vins.length; i++) {
                //Si troba una posicio null a l'array de vins l'omple amb el vi introduit
                if (vins[i]==null) {
                    vins[i]=vi;
                    return vins[i];
                }
            }
        }
        //Retorna null si be ja hi ha un vi igual a l'array o no hi ha lloc per introduirlo
        return null;
    }
    public Vi elimina(Vi vi) {
        //Si existeix un vi igual a l'array de vins procedeix
        if (existeixVi(vi.getNom())) {
            //Si el vi te estoc, no es pot eliminar
            if (vi.getEstoc()>0)
                return null;
            else {
                for (int i = 0; i < vins.length; i++) {
                    //Si troba una posicio un vi amb el mateix nom que el vi a eliminar
                    //posa la seva posicio a null i retorna el vi eliminat
                    if (vins[i].getNom()==vi.getNom()) {
                        Vi viARetornar = vins[i];
                        vins[i]=null;
                        return viARetornar;
                    }
                }
            }
        }
        //Retorna null si no troba l'instancia de vi
        return null;
    }
    public Vi cerca(String nom) {
        nom = Vi.normalitzaNom(nom);
        for (int i = 0; i < vins.length; i++) {
            if (vins[i]!=null && vins[i].getNom().equals(nom)) {
                return vins[i];
            }
        }
        return null;
    }

    //metodes extras propis
    public boolean existeixVi(String nom) {
        nom = Vi.normalitzaNom(nom);
        for (int i = 0; i < vins.length; i++) {
            if (vins[i]!=null && vins[i].getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    //04 csv
    public void iniciaRecorregut() {
        indice=0;
    }
    public Vi getSeguent() {
        Vi viARetornar=null;
        //Controlar que no entre al bucle cuando no toca para evitar petadas
        while(indice<vins.length) {
            if (vins[indice]!=null) {
                viARetornar = vins[indice];
                indice++;
                break;
            }
            indice++;
            if (indice==vins.length) break;
        }
        return viARetornar;
    }
}
