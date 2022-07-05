/*
 * Unit testing methods for an exercise
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TestExercise {

    @Test
    @DisplayName("Test hi és mòdul requerit")
    public void comparaOcurrencies() {
        Method[] methods = ComptaAiEs.class.getDeclaredMethods();
        boolean foundTarget = false;
        for (Method method: methods) {
            if ("comparaOcurrencies".equals(method.getName())) {
                foundTarget=true;
                Type[] types = method.getGenericParameterTypes();
                assertEquals(3, types.length, "Revisa els paràmetres requerits pel nou mòdul");
                assertEquals("java.lang.String", types[0].getTypeName(), "Revisa els paràmetres requerits pel nou mòdul");
                assertEquals("char", types[1].getTypeName(), "Revisa els paràmetres requerits pel nou mòdul");
                assertEquals("char", types[2].getTypeName(), "Revisa els paràmetres requerits pel nou mòdul");
            }
        }
        assertTrue(foundTarget, "No es troba el mòdul requerit. Revisa enunciat.");
    }

    @Test
    @DisplayName("Test no hi és mòdul reemplaçat")
    public void comparaAiEs() {
        Method[] methods = ComptaAiEs.class.getDeclaredMethods();
        boolean foundTarget = false;
        for (Method method: methods) {
            assertNotEquals("comparaAiEs", method.getName(), "cal eliminar el mòdul reemplaçat");
        }
    }
}
