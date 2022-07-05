import java.lang.reflect.Type;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise {


    @Nested
    @DisplayName("Tests de Botiga")
    class SobreBotiga {
        @Test
        @DisplayName("test botiga afegeix nou vi")
        public void testAfegeix() {
            Vi vi = new Vi("Roure blanc", 1323);
            Vi trobat = new Botiga().afegeix(vi);
            assertEquals(vi, trobat, "s'ha de retornar el vi afegit");
        }
        @Test
        @DisplayName("test botiga no afegeix vi amb nom repetit")
        public void testNoRepetits() {
            Vi vi = new Vi("Roure blanc", 1323);
            Vi viRepetit = new Vi("Roure blanc", 1324);
            Botiga botiga = new Botiga();
            botiga.afegeix(vi);
            Vi trobat = botiga.afegeix(viRepetit);
            assertNull(trobat, "no s'ha d'afegir un vi amb nom repetit");
        }
        @Test
        @DisplayName("test botiga no afegeix vi quan no queda espai")
        public void testNoEspai() {
            Vi viInicial = new Vi("Roure blanc", 1323);
            Vi viFinal = new Vi("Roure negre", 1324);
            Botiga botiga = new Botiga(1);
            botiga.afegeix(viInicial);
            Vi trobat = botiga.afegeix(viFinal);
            assertNull(trobat, "Quan la botiga està plena no es pot afegir un nou vi");
        }
        @Test
        @DisplayName("test botiga troba vi conegut")
        public void testTrobaExisteix() {
            Vi cercat = new Vi("Roure blanc", 1323);
            Vi[] vins = {
                new Vi("un vi", 1234),
                cercat ,
                new Vi("un altre vi", 1342)
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);
            Vi trobat = botiga.cerca("Roure blanc");
            assertEquals(cercat , trobat, "El mètode cerca() ha de trobar un vi que hi és");
        }
        @Test
        @DisplayName("test botiga troba vi conegut normalitzant el nom")
        public void testTrobaExisteixNormalitzant() {
            Vi cercat = new Vi("Roure blanc", 1323);
            Vi[] vins = {
                new Vi("un vi", 1234),
                cercat ,
                new Vi("un altre vi", 1342)
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);
            Vi trobat = botiga.cerca("  Roure   blanc    ");
            assertEquals(cercat , trobat, "El mètode cerca() ha de normalitzar el nom");
        }
        @Test
        @DisplayName("test botiga no troba vi desconegut")
        public void testNoTrobaDesconegut() {
            Vi[] vins = {
                new Vi("un vi", 1234),
                new Vi("un altre vi", 1342),
                new Vi("encara més vi", 1234)
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);
            Vi trobat = botiga.cerca("un vi desconegut");
            assertNull(trobat, "El mètode cerca() ha de tornar null quan no troba un vi que no hi és");
        }
        @Test
        @DisplayName("test botiga elimina vi conegut")
        public void testEliminaConegut() {
            Vi cercat = new Vi("Roure blanc", 1323);
            Vi[] vins = {
                new Vi("un vi", 1234),
                cercat ,
                new Vi("un altre vi", 1342)
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);
            botiga.elimina(cercat);
            Vi trobat = botiga.cerca("Roure blanc");
            assertNull(trobat, "El mètode elimina() ha d'eliminar un vi conegut");
        }
        @Test
        @DisplayName("test botiga elimina vi conegut")
        public void testRetornaViEliminat() {
            Vi cercat = new Vi("Roure blanc", 1323);
            Vi[] vins = {
                new Vi("un vi", 1234),
                cercat ,
                new Vi("un altre vi", 1342)
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);
            Vi trobat = botiga.elimina(cercat);
            assertEquals(cercat , trobat, "El mètode elimina() ha de retornar el vi eliminat");
        }
        @Test
        @DisplayName("test botiga no elimina vi desconegut")
        public void testNoEliminaDesconegut() {
            Vi cercat = new Vi("Roure blanc", 1323);
            Vi[] vins = {
                new Vi("un vi", 1234),
                new Vi("un altre vi", 1342),
                new Vi("encara més vi", 1234)
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);
            Vi trobat = botiga.elimina(cercat);
            assertNull(trobat, "El mètode elimina() ha de tornar null quan ha d'eliminar un vi que no hi és");
        }
        @Test
        @DisplayName("test botiga en eliminar segon vi queda espai per un de nou")
        public void testEliminaDeixaEspai() {
            Vi cercat = new Vi("Roure blanc", 1323);
            Vi[] vins = {
                new Vi("un vi", 1234),
                cercat ,
                new Vi("un altre vi", 1342)
            };
            Vi nouVi = new Vi("El Quintà", 1387);
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);
            Vi eliminat = botiga.elimina(cercat);
            Vi cercatEliminat = botiga.cerca("Roure blanc");
            Vi afegitNou = botiga.afegeix(nouVi);
            assertAll(
                    () -> assertNull(cercatEliminat, "El mètode elimina() ha d'eliminar un vi conegut"),
                    () -> assertEquals(cercat, eliminat, "El mètode elimina() ha de retornar el vi eliminat"),
                    () -> assertEquals(nouVi, afegitNou, "El mètode elimina() ha de deixar espai per poder afegir un nou vi")
                    );
        }
        @Test
        @DisplayName("test botiga no es pot eliminar un vi amb estoc")
        public void testNoEliminaAmbEstoc() {
            Vi cercat = new Vi("Roure blanc", 1323, 24);
            Botiga botiga = new Botiga();
            botiga.afegeix(cercat);
            Vi eliminat = botiga.elimina(cercat);
            assertNull(eliminat, "El mètode elimina() no ha d'eliminar vins amb estoc");
        }
    }
}