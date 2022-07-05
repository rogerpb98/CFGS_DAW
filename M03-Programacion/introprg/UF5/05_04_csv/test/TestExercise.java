import java.lang.reflect.Type;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise {

    @Nested
    @DisplayName("Tests de Vi")
    class SobreVi {

        @Test
        @DisplayName("test vi.aArrayString() genera adequadament")
        public void viAArrayString() {
            Vi vi = new Vi("Roure blanc", 1234, 24);
            String[] esperat = { "Roure blanc", "1234", "24" };
            String[] obtingut = vi.aArrayString();
            assertArrayEquals(esperat, obtingut, "revisa la conversió de Vi a String[]");
        }

        @Test
        @DisplayName("test vi.deArrayString() quan hi ha tots els valors")
        public void viDeArrayString() {
            String[] entrada = { "Roure blanc", "1234", "24" };
            Vi vi = Vi.deArrayString(entrada);
            assertAll(
                    () -> assertEquals("Roure blanc", vi.getNom()),
                    () -> assertEquals(1234, vi.getPreu()),
                    () -> assertEquals(24, vi.getEstoc())
                );
        }

        @Test
        @DisplayName("test vi.deArrayString() quan falten valors")
        public void viDeArrayStringFaltenValors() {
            String[] entrada = { "Roure blanc", "1234" };
            Vi vi = Vi.deArrayString(entrada);
            assertNull(vi, "Vi.deArrayString() ha de retornar null quan no hi ha prou valors");
        }

        @Test
        @DisplayName("test vi.deArrayString() quan nom incorrecte")
        public void viDeArrayStringNomIncorrecte() {
            String[] entrada = { "  ", "1234", "24" };
            Vi vi = Vi.deArrayString(entrada);
            assertNull(vi, "Vi.deArrayString() ha de retornar null quan el nom no és correcte");
        }

        @Test
        @DisplayName("test vi.deArrayString() quan preu incorrecte")
        public void viDeArrayStringPreuIncorrecte() {
            String[] entrada = { "Roure blanc", "gratis", "24" };
            Vi vi = Vi.deArrayString(entrada);
            assertNull(vi, "Vi.deArrayString() ha de retornar null quan el preu no és correcte");
        }

        @Test
        @DisplayName("test vi.deArrayString() quan preu negatiu")
        public void viDeArrayStringPreuNegatiu() {
            String[] entrada = { "Roure blanc", "-1234", "24" };
            Vi vi = Vi.deArrayString(entrada);
            assertNull(vi, "Vi.deArrayString() ha de retornar null quan el preu és negatiu");
        }

        @Test
        @DisplayName("test vi.deArrayString() quan estoc incorrecte")
        public void viDeArrayStringEstocIncorrecte() {
            String[] entrada = { "Roure blanc", "1234", "cap" };
            Vi vi = Vi.deArrayString(entrada);
            assertNull(vi, "Vi.deArrayString() ha de retornar null quan l'estoc no és correcte");
        }

        @Test
        @DisplayName("test vi.deArrayString() quan estoc negatiu")
        public void viDeArrayStringEstocNegatiu() {
            String[] entrada = { "Roure blanc", "1234", "-2" };
            Vi vi = Vi.deArrayString(entrada);
            assertNull(vi, "Vi.deArrayString() ha de retornar null quan l'estoc és negatiu");
        }

        @Test
        @DisplayName("test vi.deArrayString() normalitza nom")
        public void viDeArrayStringNormalitzaNom() {
            String[] entrada = { "   Roure    blanc   ", "1234", "24" };
            Vi vi = Vi.deArrayString(entrada);
            assertEquals("Roure blanc", vi.getNom(), "Cal normalitzar el nom");
        }

    }

    @Nested
    @DisplayName("Tests de Botiga")
    class SobreBotiga {

        @Test
        @DisplayName("test botiga pot ser recorreguda quan és buida")
        public void recorregutBuit() {
            Botiga botiga = new Botiga();
            botiga.iniciaRecorregut();
            Vi primer = botiga.getSeguent();
            assertNull(primer, "una botiga buida ha de retornar null al primer vi del recorregut");
        }

        @Test
        @DisplayName("test botiga pot ser recorreguda quan hi ha elements")
        public void recorregutComplet() {
            Vi[] vins = {
                new Vi("un vi", 1234),
                new Vi("un altre vi", 1342),
                new Vi("encara més vi", 1234)
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);

            botiga.iniciaRecorregut();
            Vi[] trobats = {
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
            };
            assertAll(
                    () -> assertEquals(vins[0], trobats[0], "la botiga ha de tornar el primer vi després d'iniciar recorregut"),
                    () -> assertEquals(vins[1], trobats[1], "la botiga ha de retornar el segon vi després del primer"),
                    () -> assertEquals(vins[2], trobats[2], "la botiga ha de retornar el següent vi en el recorregut"),
                    () -> assertNull(trobats[3], "la botiga ha de retornar null en demanar el següent del darrer")
                    );
        }

        @Test
        @DisplayName("test el recorregut de botiga pot ser reinicialitzat en meitat d'un recorregut")
        public void recorregutAmbReinici() {
            Vi[] vins = {
                new Vi("un vi", 1234),
                new Vi("un altre vi", 1342),
                new Vi("encara més vi", 1234)
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);

            botiga.iniciaRecorregut();
            Vi trobatPrimerPrimeraVolta = botiga.getSeguent();
            Vi trobatSegonPrimeraVolta = botiga.getSeguent();
            botiga.iniciaRecorregut();
            Vi trobatPrimerSegonaVolta = botiga.getSeguent();
            assertAll(
                    () -> assertEquals(vins[0], trobatPrimerPrimeraVolta, "la botiga ha de tornar el primer vi després d'iniciar recorregut"),
                    () -> assertEquals(vins[1], trobatSegonPrimeraVolta, "la botiga ha de retornar el segon vi després del primer"),
                    () -> assertEquals(vins[0], trobatPrimerSegonaVolta, "la botiga ha de retornar el primer vi en tornar a iniciar en mig d'un recorregut")
                    );
        }

        @Test
        @DisplayName("test el recorregut de botiga un cop arribat al final sempre torna null")
        public void recorregutSempreNullUnCopArribatAlFinal() {
            Vi[] vins = {
                new Vi("un vi", 1234),
                new Vi("un altre vi", 1342),
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);

            botiga.iniciaRecorregut();
            Vi[] trobats = {
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
                botiga.getSeguent(),
            };
            assertAll(
                    () -> assertEquals(vins[0], trobats[0], "la botiga ha de tornar el primer vi després d'iniciar recorregut"),
                    () -> assertEquals(vins[1], trobats[1], "la botiga ha de retornar el segon vi després del primer"),
                    () -> assertNull(trobats[2], "la botiga ha de retornar null en demanar el següent del darrer"),
                    () -> assertNull(trobats[3], "la botiga ha de retornar null un cop acabat el recorregut"),
                    () -> assertNull(trobats[4], "la botiga ha de retornar null un cop acabat el recorregut")
                    );
        }

        @Test
        @DisplayName("test el recorregut de botiga salta espais eliminats")
        public void recorregutAmbViEliminat() {
            Vi[] vins = {
                new Vi("un vi", 1234),
                new Vi("un altre vi", 1342),
                new Vi("encara més vi", 1234)
            };
            Botiga botiga = new Botiga();
            for (Vi vi: vins) botiga.afegeix(vi);
            botiga.elimina(vins[1]);

            botiga.iniciaRecorregut();
            Vi trobatPrimer = botiga.getSeguent();
            Vi trobatSegon = botiga.getSeguent();
            assertAll(
                    () -> assertEquals(vins[0], trobatPrimer, "la botiga ha de tornar el primer vi després d'iniciar recorregut"),
                    () -> assertEquals(vins[2], trobatSegon, "la botiga ha de saltar les posicions eliminades")
                    );
        }

        @Test
        @DisplayName("test el recorregut de botiga controla la mida de l'array de vins")
        public void recorregutForaDeRang() {
            Vi[] vins = {
                new Vi("un vi", 1234),
                new Vi("un altre vi", 1342),
            };
            Botiga botiga = new Botiga(2);
            for (Vi vi: vins) botiga.afegeix(vi);
            botiga.elimina(vins[1]);

            botiga.iniciaRecorregut();
            botiga.getSeguent();    // ignora primer
            botiga.getSeguent();    // ignora segon
            Vi primerForaDeRang  = botiga.getSeguent();
            Vi segonForaDeRang  = botiga.getSeguent();
            assertAll(
                    () -> assertNull(primerForaDeRang, "el recorregut ha de controlar quan arriba al final de l'array"),
                    () -> assertNull(segonForaDeRang, "el recorregut ha de controlar quan arriba al final de l'array")
                    );
        }


    }
}