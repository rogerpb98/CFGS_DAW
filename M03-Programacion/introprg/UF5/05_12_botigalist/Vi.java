/* Exercici inicial per acabar muntant una botiga, en aquesta classe está l'estructura
 * Que definirá com es crean els vins, els requisits que tenen por poderse crear i el metode
 * Per mostrar-lo per pantalla 
 */
public class Vi {
    //Values
    private String ref;
    private String nom;
    private String tipus;
    private int preu;
    private String collita;
    private int estoc;
    private String origen;
    private String lloc;
    //Constructors
    public Vi(String ref, String nom, String tipus, int preu, String collita, int estoc, String origen, String lloc) {
        this.ref=normalitzaString(ref);
        this.nom=normalitzaString(nom);
        this.tipus=normalitzaString(tipus);
        this.preu=preu;
        this.collita=normalitzaString(collita);
        this.estoc=estoc;
        this.origen=normalitzaString(origen);
        this.lloc=normalitzaString(lloc);
    }
    //Getters and Setters
    public String getRef() {return ref;}
    public String getNom() {return nom;}
    public String getTipus() {return tipus;}
    public int getPreu() {return preu;}
    public void setPreu(int preu) {
        if (preu<0) 
            preu=0;
        this.preu = preu;
    }
    public String getCollita() {return collita;}
    public int getEstoc() {return estoc;}
    public void setEstoc(int estoc) {
        if (estoc<0) 
            estoc=0;
        this.estoc = estoc;
    }
    public String getOrigen() {return origen;}
    public String getLloc() {return lloc;}
    public void setLloc(String lloc) {
        this.lloc = normalitzaString(lloc);
    }
    
    //Methods
    public static String normalitzaString(String nom) {
        if (nom==null || nom.isEmpty()||nom.isBlank())
            return "";
        nom = nom.strip();
        nom = nom.replaceAll("( )+", " ");
        return nom;
    }

    @Override
    public String toString() {
        return String.format("%n\tRef: %s%n\tNom: %s%n\tTipus: %s%n\tPreu: %d%n\tCollita: %s%n\tEstoc: %d%n\tD.O.: %s%n\tLloc: %s%n",
        ref, nom, tipus, preu, collita, estoc, origen, lloc);
    }

    public static Vi deArrayString(String[] ArrayVinsString) {
        //Si l'array no te la mida correcta retorna null
        if (ArrayVinsString.length!=8) return null;
        //Si la ref es incorrecte retorna null
        if (normalitzaString(ArrayVinsString[0]).equals("")) return null;
        //Si el nom es incorrecte retorna null
        if (normalitzaString(ArrayVinsString[1]).equals("")) return null;
        //Si el tipus es incorrecte retorna null
        if (normalitzaString(ArrayVinsString[2]).equals("")) return null;
        //Si el preu no es enter positiu retorna null
        if (!(UtilString.esEnterPositiu(normalitzaString(ArrayVinsString[3])))) return null;
        //Si la collita es incorrecte retorna null
        if (normalitzaString(ArrayVinsString[4]).equals("")) return null;
        //Si l'estoc no es enter positiu retorna null
        if (!(UtilString.esEnterPositiu(normalitzaString(ArrayVinsString[5])))) return null;
        //Si l'origen es incorrecte retorna null
        if (normalitzaString(ArrayVinsString[6]).equals("")) return null;
        //Si el lloc es incorrecte retorna null
        if (normalitzaString(ArrayVinsString[7]).equals("")) return null;
        //Sino, assigna els valors a les variables corresponents per millorar llegibilitat
        String nouRef = normalitzaString(ArrayVinsString[0]);
        String nouNom = normalitzaString(ArrayVinsString[1]);
        String nouTipus = normalitzaString(ArrayVinsString[2]);
        int nouPreu = Integer.parseInt(normalitzaString(ArrayVinsString[3]));
        String nouCollita = normalitzaString(ArrayVinsString[4]);
        int nouEstoc = Integer.parseInt(normalitzaString(ArrayVinsString[5]));
        String nouOrigen = normalitzaString(ArrayVinsString[6]);
        String nouLloc = normalitzaString(ArrayVinsString[7]);
        return new Vi(nouRef, nouNom, nouTipus, nouPreu, nouCollita, nouEstoc, nouOrigen, nouLloc);
    }
    public String[] aArrayString() {
        String[] arrayARetornar = new String[8];
        arrayARetornar[0]=ref;
        arrayARetornar[1]=nom;
        arrayARetornar[2]=tipus;
        arrayARetornar[3]=String.valueOf(preu);
        arrayARetornar[4]=collita;
        arrayARetornar[5]=String.valueOf(estoc);
        arrayARetornar[6]=origen;
        arrayARetornar[7]=lloc;
        return arrayARetornar;
    }

    public boolean esValid() {
        if (normalitzaString(this.ref).equals("")
            || normalitzaString(this.nom).equals("")
            || normalitzaString(this.tipus).equals("")
            || this.preu<0
            || normalitzaString(this.collita).equals("")
            || this.estoc<0
            || normalitzaString(this.origen).equals("")
            || normalitzaString(this.lloc).equals("")
            ) return false;
        return true;
    }
}
