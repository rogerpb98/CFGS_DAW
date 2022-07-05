import java.util.List;

import java.util.Arrays;

public class maintest {
    public static void main(String[] args) throws BotigaPlenaException {
        Vi[] vins = {
            new Vi("LLUMALBA20200001", "Llum Alba Blanc", "blanc", 1750, "2020", 12, "Priorat", "P02E03N55D"),
            new Vi("CARPATHI20180021", "Carpathia Negre", "negre", 3450, "2018", 6, "Montsant", "P23E01N43D"),
            new Vi("MATISNEG20190011", "Matís Negre", "negre", 1325, "2019", 12, "Pla del Bages", "P20E01N12E"),
            new Vi("ROURABLA20200232", "Roura blanc", "blanc", 606, "2020", 32, "Alella", "P21E45N55E"),
            new Vi("ROURABLA20200232", "Roura blanc", "blanc", 1606, "2018", 2, "Alella", "P21E45N55E")
        };
        Botiga botiga = new Botiga();
        for (Vi vi: vins) botiga.afegeix(vi);

        List<Vi> esperat = Arrays.asList(vins[0], vins[3]);
        Vi plantilla = new Vi("", "", "blanc", 3000, "", 5, "", "");
        List<Vi> trobat = botiga.cerca(plantilla);
    }
}
