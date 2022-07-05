import java.lang.reflect.Type;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/*
 * XXX comprovacions a realitzar
 * - Gat té nom per defecte "Gat"
 * - Gat implements EsserViu
 * - GatRenat, Garfield i GatSalvatge extends Gat
 * - GatRenat i Garfield implements AnimalDeCompanyia
 * - GatSalvatge no implements AnimalDeCompanyia
 * - GatRenat implements Ensinistrable
 * - Garfiels i GatSalvatge no implements Ensinistrable
 */

public class TestExercise {


    @Nested
    @DisplayName("Tests de Gat")
    class SobreGat {

        @Test
        @DisplayName("test Gat.vides és privat")
        public void testGatVidesEsPrivate() {
            assertTrue(UtilTests.classHasPrivateField(Gat.class, "vides"),
                    "Cal que vides sigui privada per grantir que no pugui ser modificada malament");
        }

        @Test
        @DisplayName("test Gat.nom és privat")
        public void testGatNomEsPrivate() {
            assertTrue(UtilTests.classHasPrivateField(Gat.class, "nom"),
                    "Cal que nom sigui privada per grantir que no pugui ser modificada malament");
        }

        @Test
        @DisplayName("test Gat es diu anònim quan nom no vàlid")
        public void gatAnonim() {
            assertAll(
                    () -> assertEquals("anònim", new Gat(null).getNom()),
                    () -> assertEquals("anònim", new Gat("").getNom()),
                    () -> assertEquals("anònim", new Gat("   ").getNom()),
                    () -> assertEquals("anònim", new Gat(null, 5).getNom()),
                    () -> assertEquals("anònim", new Gat("", 5).getNom()),
                    () -> assertEquals("anònim", new Gat("   ", 5).getNom())
                    );
            }


    }

}