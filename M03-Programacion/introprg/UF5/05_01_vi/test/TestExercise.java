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
        @ParameterizedTest
        @CsvSource(value={
        "'   nom',nom,'cal eliminar els espais inicials'",
        "'nom   ',nom,'cal eliminar els espais finals'",
        "'nom   cognom1   cognom2', 'nom cognom1 cognom2', 'cal eliminar espais extra entre paraules'",
        "'nom cognom1 cognom2', 'nom cognom1 cognom2', 'cal respectar espais entre paraules'",
        "'  Nom  Cognom1 Cognom2 ', 'Nom Cognom1 Cognom2', 'cal respectar majúscules i minúscules quan s'eliminen espais'",
        "'   ', 'nom no vàlid', 'cal un nom per defecte quan el rebut no és vàlid'"
        })
        @DisplayName("test normalitza nom")
        public void testNormalitzaNom(String nom, String esperat, String missatge) {
            String obtingut = Vi.normalitzaNom(nom);
            assertEquals(esperat, obtingut, missatge);
        }

        @Test
        @DisplayName("test preu negatiu es queda en 0")
        public void preuNegatiu() {
            Vi vi = new Vi("nom vi", -1);
            int preuTrobatEnConstruccio = vi.getPreu();
            vi.setPreu(10);
            int preuTrobatEnSetPositiu = vi.getPreu();
            vi.setPreu(-10);
            int preuTrobatEnSetNegatiu = vi.getPreu();
            assertAll(
                    () -> assertEquals(0, preuTrobatEnConstruccio, "El constructor de Vi ha de controlar preus negatius"),
                    () -> assertEquals(10, preuTrobatEnSetPositiu, "Vi.setPreu() ha d'assignar preus correctes"),
                    () -> assertEquals(10, preuTrobatEnSetNegatiu, "Vi.setPreu() ha d'ignorar preus incorrectes")
                    );
        }

        @Test
        @DisplayName("test estoc negatiu es queda en 0")
        public void estocNegatiu() {
            Vi vi = new Vi("nom vi", 10, -1);
            int estocTrobatEnConstruccio = vi.getEstoc();
            vi.setEstoc(10);
            int estocTrobatEnSetPositiu = vi.getEstoc();
            vi.setEstoc(-10);
            int estocTrobatEnSetNegatiu = vi.getEstoc();
            assertAll(
                    () -> assertEquals(0, estocTrobatEnConstruccio, "El constructor de Vi ha de controlar estocs negatius"),
                    () -> assertEquals(10, estocTrobatEnSetPositiu, "Vi.setEstoc() ha d'assignar estocs correctes"),
                    () -> assertEquals(10, estocTrobatEnSetNegatiu, "Vi.setEstoc() ha d'ignorar estocs incorrectes")
                    );
        }

    }

}