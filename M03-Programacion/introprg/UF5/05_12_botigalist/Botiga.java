/* Segon exercici per acabar muntant una botiga, en aquesta classe está l'estructura
 * Que definirá com es crean les botigues, els requisits que tenen por poderse crear i els metodes
 * Per afegir-cercar-eliminar vins d'aquestes.
 */
import java.util.List;
import java.util.LinkedList;

public class Botiga {
    private final int DEFAULT_MAX_VINS = 100;
    private Vi[] vins;
    private int indice;
    public Botiga() {
        vins = new Vi[DEFAULT_MAX_VINS];
    }
    public Botiga(int maxVins) throws IllegalArgumentException {
        if(maxVins>0)
            vins = new Vi[maxVins];
        else
            throw new IllegalArgumentException("No es pot crear una botiga amb menys d'un vi");
    }

    public List<Vi> cerca(Vi plantilla) throws IllegalArgumentException {
        LinkedList<Vi> llistaVinsTrobats= new LinkedList<>();
        if (plantilla==null)
            throw new IllegalArgumentException("El paràmetre plantilla no ha de rebre null");
        for (Vi vi: vins) {
            if (vi == null) continue;
            if (! plantilla.getRef().isEmpty() && ! plantilla.getRef().equalsIgnoreCase(vi.getRef())) continue;
            if (! plantilla.getNom().isEmpty() && ! plantilla.getNom().equalsIgnoreCase(vi.getNom())) continue;
            if (! plantilla.getTipus().isEmpty() && ! plantilla.getTipus().equalsIgnoreCase(vi.getTipus())) continue;
            if (plantilla.getPreu() >= 0 && plantilla.getPreu() < vi.getPreu()) continue;
            if (! plantilla.getCollita().isEmpty() && ! plantilla.getCollita().equalsIgnoreCase(vi.getCollita())) continue;
            if (plantilla.getEstoc() >= 0 && plantilla.getEstoc() > vi.getEstoc()) continue;
            if (! plantilla.getOrigen().isEmpty() && ! plantilla.getOrigen().equalsIgnoreCase(vi.getOrigen())) continue;
            if (! plantilla.getLloc().isEmpty() && ! plantilla.getLloc().equalsIgnoreCase(vi.getLloc())) continue;
            llistaVinsTrobats.add(vi);
        }
        return llistaVinsTrobats;
    }

    //metodes extras propis
    public boolean existeixVi(String ref) {
        ref = Vi.normalitzaString(ref);
        for (int i = 0; i < vins.length; i++) {
            if (vins[i]!=null && vins[i].getRef().equals(ref)) {
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

    public Vi afegeix(Vi vi) throws BotigaPlenaException {
        //Si no existeix un vi igual a l'array de vins procedeix
        if (vi.esValid() && !(existeixVi(vi.getRef()))) {
            for (int i = 0; i < vins.length; i++) {
                //Si troba una posicio null a l'array de vins l'omple amb el vi introduit
                if (vins[i]==null) {
                    vins[i]=vi;
                    return vins[i];
                }
            }
        }
        //Retorna null si be ja hi ha un vi igual a l'array o no hi ha lloc per introduirlo
        else return null;
        throw new BotigaPlenaException();
    }
    public Vi elimina(Vi vi) throws IllegalArgumentException{
        if (vi==null) 
            throw new IllegalArgumentException("El paràmetre vi no ha de rebre null");
        //Si existeix un vi igual a l'array de vins amb estoc 0 procedeix
        if (existeixVi(vi.getRef()) && vi.getEstoc()==0) {
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
        //Retorna null si no troba l'instancia de vi o no te estoc a 0
        throw new IllegalArgumentException("La instància a eliminar ha d'estar present");
    }
}
