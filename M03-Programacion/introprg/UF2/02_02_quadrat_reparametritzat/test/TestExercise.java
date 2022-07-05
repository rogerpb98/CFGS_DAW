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
    @DisplayName("Test hi és mòdul dibuixaQuadrat")
    public void comparaOcurrencies() {
        Class classe = Quadrat.class;
        String modulObjectiu = "dibuixaQuadrat";
        Method[] methods = classe.getDeclaredMethods();
        boolean foundTarget = false;
        for (Method method: methods) {
            if (modulObjectiu.equals(method.getName())) {
                foundTarget=true;
                Type[] types = method.getGenericParameterTypes();
                assertEquals(2, types.length, "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()");
                assertEquals("int", types[0].getTypeName(), "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()");
                assertEquals("char", types[1].getTypeName(), "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()");
                assertEquals("void", method.getGenericReturnType().getTypeName(), "S'esperava que " + modulObjectiu + "() fos un procediment");
            }
        }
        assertTrue(foundTarget, "No es troba el mòdul " + modulObjectiu + "(). Revisa enunciat.");
    }
}
