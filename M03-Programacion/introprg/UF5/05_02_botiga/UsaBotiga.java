/*
 * Aquesta classe fa una comprovació ràpida del funcionament de la classe
 * Botiga
 */
public class UsaBotiga {
    public static void main(String[] args) {
        final int QUANTS_VINS = 3;

        System.out.println("Creem uns quants vins");
        Vi[] vins = new Vi[QUANTS_VINS];
        for (int i=0; i<QUANTS_VINS; i++) {
            vins[i] = new Vi("Vi nr. " + i, 1000 + i * 100, 10 + i);
            System.out.println("Creat" + vins[i]);
        }

        Botiga botiga = new Botiga(QUANTS_VINS - 1);    // no hi cabran tots els vins

        System.out.println("Afegim els vins creats a la botiga");
        for (int i=0; i<QUANTS_VINS; i++) {
            Vi resposta = botiga.afegeix(vins[i]);
            System.out.println("En afegir" + vins[i] + "la botiga ens respon " + resposta);
        }

        System.out.printf("%nCerquem uns vins%n");
        String nomVi = vins[1].getNom();
        Vi resposta = botiga.cerca(nomVi);
        System.out.println("En cercar " + nomVi + " botiga ens respon " + resposta);

        nomVi = vins[QUANTS_VINS - 1].getNom();
        resposta = botiga.cerca(nomVi);
        System.out.println("En cercar " + nomVi + " botiga ens respon " + resposta);

    }
}
