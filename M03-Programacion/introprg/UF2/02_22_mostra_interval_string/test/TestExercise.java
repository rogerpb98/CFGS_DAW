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

    @ParameterizedTest
    @CsvSource(value={
        "hola, -2, -1, ''",
        "hola, -2,  0, h",
        "hola, -2,  2, hol",
        "hola, -2,  3, hola",
        "hola, -2,  5, hola",
        "hola,  0,  0, h",
        "hola,  0,  2, hol",
        "hola,  0,  3, hola",
        "hola,  0,  5, hola",
        "hola,  1,  2, ol",
        "hola,  1,  3, ola",
        "hola,  1,  5, ola",
        "hola, -1, -2, ''",
        "hola,  0, -2, h",
        "hola,  2, -2, loh",
        "hola,  3, -2, aloh",
        "hola,  5, -2, aloh",
        "hola,  0,  0, h",
        "hola,  2,  0, loh",
        "hola,  3,  0, aloh",
        "hola,  5,  0, aloh",
        "hola,  2,  1, lo",
        "hola,  3,  1, alo",
        "hola,  5,  1, alo"
    })
    @DisplayName("test intervalString()")
    public void intervalString(String text, int ini, int fi, String esperat) {
        String obtingut = UtilString.intervalString(text, ini, fi);
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui '" +
                                        text + "' amb inici " + ini + 
                                        " i final " + fi);
    }
}