/*
 * Unit testing methods for an exercise
 */

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise {

    @Test
    @DisplayName("test teDamaNegra() quan no hi és")
    public void teDamaNegra() {
        char[][] entrada = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'r','d','a','c','t','p','·','·'},
            {'R','·','A','C','T','P','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'}
        };
        assertFalse(Escacs.teDamaNegra(entrada), "Ha respost true quan no hi ha una dama negra");
    }

    @Test
    @DisplayName("test teDamaNegra() quan hi és a l'inici")
    public void teDamaNegraInici() {
        char[][] entrada = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'r','d','a','c','t','p','·','·'},
            {'R','·','A','C','T','P','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','D'}
        };
        assertTrue(Escacs.teDamaNegra(entrada), "Ha respost false quan sí hi ha una dama negra");
    }

    @Test
    @DisplayName("test teDamaNegra() quan hi és al final")
    public void teDamaNegraFinal() {
        char[][] entrada = {
            {'D','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'r','d','a','c','t','p','·','·'},
            {'R','·','A','C','T','P','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'}
        };
        assertTrue(Escacs.teDamaNegra(entrada), "Ha respost false quan sí hi ha una dama negra");
    }

    @Test
    @DisplayName("test teDamaNegra() quan hi és al mig")
    public void teDamaNegraMig() {
        char[][] entrada = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'r','d','a','c','t','p','·','·'},
            {'R','D','A','C','T','P','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'}
        };
        assertTrue(Escacs.teDamaNegra(entrada), "Ha respost false quan sí hi ha una dama negra");
    }

}