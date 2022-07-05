/* Cos principal de Garfield que exten a Gat, no pot tenir mes de 9 vides i 
 * implementa animal de companyia, que permet donarli mostres d'afecte
 */
public class Garfield extends Gat implements AnimalDeCompanyia {
    public Garfield() {
        super("Garfield", 9);
    }

    @Override
    //Les vides de Garfield mai poden superar 9
    public void setVides(int vides) {
        if (vides <= 9 && vides >= 0) 
            super.setVides(vides);
    }

    public String deixatEstimar() {
        return "em deixo estimar una mica";
    }
}
