package refactoring2;

import java.util.Vector;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Client {
	private static final double EUROS_PER_UNITAT_DE_COST = 30;
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public String informe() {
        return composaCapsalera() + composaDetalls() + composPeu();
    }
    
    public String composaCapsalera() {
    	return "Informe de lloguers del client " +getNom() +" (" + getNif() + ")\n";
    }
    public String composaDetalls() {
    	String resultat = "";
    	for (Lloguer lloguer: lloguers) {
            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
        }
    	return resultat;
    }
    public String composPeu() {
    	String resultat = "";
    	// afegeix informació final
        resultat += "Import a pagar: " + importTotal() + "€\n" +
            "Punts guanyats: " + bonificacionsTotals() + "\n";
        return resultat;
    }
    
    public void informeHTML() throws IOException {
    	String cami = "informe.html";
        FileWriter fileReader = new FileWriter(cami);
        BufferedWriter sortida = new BufferedWriter(fileReader);
        sortida.write(composaCapsaleraHTML() + composaDetallsHTML() + composPeuHTML());
        sortida.close();
        //return composaCapsaleraHTML() + composaDetallsHTML() + composPeuHTML();
    }
    
    public String composaCapsaleraHTML() {
    	return "<h1>Informe de lloguers</h1>\n"+
    			"<p>Informe de lloguers del client <em>"+getNom()+"</em> (<strong>" + getNif() + "</strong>)</p>\n";
    }
    public String composaDetallsHTML() {
    	String resultat = "";
    	resultat += "<table>\n" +
    				"\t<tr>\n"+
    					"\t\t<td><strong>Marca</strong></td>\n"+
    					"\t\t<td><strong>Model</strong></td>\n"+
    					"\t\t<td><strong>Import</strong></td>\n"+
    				"\t</tr>\n";
    	for (Lloguer lloguer: lloguers) {
            // composa els resultats d'aquest lloguer
    		resultat += "\t<tr>\n"+
    						"\t\t<td>"+lloguer.getVehicle().getMarca()+"</td>\n"+
    						"\t\t<td>"+lloguer.getVehicle().getModel()+"</td>\n"+
    						"\t\t<td>"+(lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST)+"€</td>\n"+
    					"\t</tr>\n";
        }
    	resultat += "</table>\n";
    	return resultat;
    }
    public String composPeuHTML() {
    	String resultat = "";
    	// afegeix informació final
    	resultat += "<p>Import a pagar: <em>"+importTotal()+"€</em></p>\n"+
    			    "<p>Punts guanyats: <em>"+bonificacionsTotals()+"</em></p>";
        return resultat;
    }
    
    public double importTotal() {
    	double total = 0;
    	for (Lloguer lloguer: lloguers) {
            total += lloguer.quantitat() * EUROS_PER_UNITAT_DE_COST;
        }
    	return total;
    }
    public double bonificacionsTotals() {
    	int bonificacions = 0;
    	for (Lloguer lloguer: lloguers) {
    		bonificacions += lloguer.bonificacions();
        }
    	return bonificacions;
    }
}