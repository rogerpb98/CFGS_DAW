/*
 * Unit testing methods for an exercise
 */

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise {

    @Test
    @DisplayName("test entreComes() amb cap enter")
    public void entreComesCapEnter() {
        int[] entrada = {};
        String esperat = "";
        String obtingut = UtilString.entreComes(entrada, ',');
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb cap enter'");
    }
    @Test
    @DisplayName("test entreComes() amb un enter")
    public void entreComesUnEnter() {
        int[] entrada = {1};
        String esperat = "1";
        String obtingut = UtilString.entreComes(entrada, ',');
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb un enter'");
    }
    @Test
    @DisplayName("test entreComes() amb dos enters")
    public void entreComesDosEnters() {
        int[] entrada = {1, 2};
        String esperat = "1, 2";
        String obtingut = UtilString.entreComes(entrada, ',');
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb dos enters'");
    }
    @Test
    @DisplayName("test entreComes() amb cinc enters")
    public void entreComesCincEnters() {
        int[] entrada = {1, 2, 3, 4, 5};
        String esperat = "1, 2, 3, 4, 5";
        String obtingut = UtilString.entreComes(entrada, ',');
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb cinc enters'");
    }
    @Test
    @DisplayName("test entreComes() amb cinc enters")
    public void entreExclamacions() {
        int[] entrada = {1, 2, 3, 4, 5};
        String esperat = "1! 2! 3! 4! 5";
        String obtingut = UtilString.entreComes(entrada, '!');
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un altre separador'");
    }

    @Test
    @DisplayName("Test hi és mòdul esEnter()")
    public void prgtestX1esEnter() {
        Class classe = UtilString.class;
        String modulObjectiu = "esEnter";
        Method[] methods = classe.getDeclaredMethods();
        boolean foundTarget = false;
        for (Method method: methods) {
            if (modulObjectiu.equals(method.getName())) {
                foundTarget=true;
                Type[] types = method.getGenericParameterTypes();
                assertEquals(
                        1, 
                        types.length, 
                        "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                    "java.lang.String",
                    types[0].getTypeName(),
                    "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                        "boolean",
                        method.getGenericReturnType().getTypeName(),
                        "S'esperava " + modulObjectiu + "() d'un tipus diferent"
                );
            }
        }
        assertTrue(foundTarget, "No es troba el mòdul " + modulObjectiu + "(). Revisa enunciat.");
    }
}