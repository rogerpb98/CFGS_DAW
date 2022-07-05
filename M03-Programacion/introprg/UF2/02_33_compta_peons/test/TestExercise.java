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
    @DisplayName("test quatesOcurrencies() quan no hi ha cap")
    public void quantesOcurrenciesCap() {
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
        int expected = 0;
        int found = Escacs.quantesOcurrencies(entrada, 'D');
        assertEquals(found, expected, "No compta bé les ocurrències quan no n'hi ha");
    }

    @Test
    @DisplayName("test quatesOcurrencies() quan tot ple")
    public void quantesOcurrenciesPle() {
        char[][] entrada = {
            {'p','p','p','p','p','p','p','p'},
            {'p','p','p','p','p','p','p','p'},
            {'p','p','p','p','p','p','p','p'},
            {'p','p','p','p','p','p','p','p'},
            {'p','p','p','p','p','p','p','p'},
            {'p','p','p','p','p','p','p','p'},
            {'p','p','p','p','p','p','p','p'},
            {'p','p','p','p','p','p','p','p'}
        };
        int expected = 64;
        int found = Escacs.quantesOcurrencies(entrada, 'p');
        assertEquals(found, expected, "No compta bé les ocurrències quan tot ple");
    }

    @Test
    @DisplayName("test quatesOcurrencies() quan extrems")
    public void quantesOcurrenciesExtrems() {
        char[][] entrada = {
            {'D','·','·','·','·','·','·','D'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'r','d','a','c','t','p','·','·'},
            {'R','·','A','C','T','P','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'D','·','·','·','·','·','·','D'}
        };
        int expected = 4;
        int found = Escacs.quantesOcurrencies(entrada, 'D');
        assertEquals(found, expected, "No compta bé les ocurrències quan són a les cantonades");
    }
}