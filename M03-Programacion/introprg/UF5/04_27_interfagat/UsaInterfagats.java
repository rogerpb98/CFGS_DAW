/*
 * Aquest programa serveix de comprovació de que es disposa de tots els
 * requeriments bàsics de l'exercici del Gat Renat amb Interfaces
 */
public class UsaInterfagats {
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();
        Garfield garfield = new Garfield();
        GatSalvatge gatSalvatge = new GatSalvatge();
        Gat gargamel = new Gat("Gargamel"); 
        Gat[] gats = { renat, garfield, gatSalvatge, gargamel };
        AnimalDeCompanyia[] animalsDeCompanyia = { renat, garfield };
        Ensinistrable[] ensinistrables = { renat };
        EsserViu[] essersVius = {renat, garfield, gatSalvatge, gargamel };
            
        System.out.println("Comprovem els mètodes de ensinistrable");
        System.out.println("======================================");
        for (Ensinistrable ensinistrable: ensinistrables) {
            System.out.println(ensinistrable.aixecat());
            System.out.println(ensinistrable.estaDret());
            System.out.println(ensinistrable.seu());
            System.out.println(ensinistrable.estaAssegut());
            System.out.println(ensinistrable.estirat());
            System.out.println(ensinistrable.estaEstirat());
        }

        System.out.println("Comprovem els mètodes d'AnimalDeCompanyia");
        System.out.println("=========================================");
        for (AnimalDeCompanyia pet: animalsDeCompanyia) {
            System.out.println(pet.deixatEstimar());
        }

        System.out.println("Comprovem els mètodes d'Esser viu");
        System.out.println("=================================");
        for (EsserViu esser: essersVius) {
            System.out.println(esser.estaViu());
            System.out.println(esser.mor());
            System.out.println(esser.ressuscita());
        }

        System.out.println("Comprovem els mètodes de Gat");
        System.out.println("============================");
        for (Gat gat: gats) {
            System.out.println(gat.getNom());
            gat.setVides(1);
            System.out.println(gat.mor());
            System.out.println(gat.estaViu());
            System.out.println(gat.ressuscita());
            System.out.println(gat.getVides());
        }

    }
}
