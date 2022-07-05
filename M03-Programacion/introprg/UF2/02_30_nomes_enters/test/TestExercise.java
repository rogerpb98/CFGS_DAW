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
    @DisplayName("test filtraEnters() amb cap valor")
    public void filtraEntersCapValor() {
        String[] entrada = {};
        int[] esperat = {};
        int[] obtingut = SumaEnters.filtraEnters(entrada);
        assertArrayEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb cap enter'");
    }

    @Test
    @DisplayName("test filtraEnters() amb un valor no enter")
    public void filtraEntersUnValorNoEnter() {
        String[] entrada = {"un"};
        int[] esperat = {};
        int[] obtingut = SumaEnters.filtraEnters(entrada);
        assertArrayEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb cap enter'");
    }

    @Test
    @DisplayName("test filtraEnters() amb un valor enter")
    public void filtraEntersUnValorEnter() {
        String[] entrada = {"10"};
        int[] esperat = {10};
        int[] obtingut = SumaEnters.filtraEnters(entrada);
        assertArrayEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb un enter'");
    }

    @Test
    @DisplayName("test filtraEnters() amb mix valors")
    public void filtraEntersMixEnters() {
        String[] entrada = {"un", "2", "tres", "-4", "+5", "sis" };
        int[] esperat = {2, -4, 5};
        int[] obtingut = SumaEnters.filtraEnters(entrada);
        assertArrayEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb alguns enters'");
    }

    @Test
    @DisplayName("test quantsEnters() amb cap valor")
    public void quantsEntersCapValor() {
        String[] entrada = {};
        int esperat = 0;
        int obtingut = SumaEnters.quantsEnters(entrada);
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb cap enter'");
    }

    @Test
    @DisplayName("test quantsEnters() amb un valor no enter")
    public void quantsEntersUnValorNoEnter() {
        String[] entrada = {"un"};
        int esperat = 0;
        int obtingut = SumaEnters.quantsEnters(entrada);
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb cap enter'");
    }

    @Test
    @DisplayName("test quantsEnters() amb un valor enter")
    public void quantsEntersUnValorEnter() {
        String[] entrada = {"10"};
        int esperat = 1;
        int obtingut = SumaEnters.quantsEnters(entrada);
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb un enter'");
    }

    @Test
    @DisplayName("test quantsEnters() amb mix valors")
    public void quantsEntersMixEnters() {
        String[] entrada = {"un", "2", "tres", "-4", "+5", "sis" };
        int esperat = 3;
        int obtingut = SumaEnters.quantsEnters(entrada);
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb alguns enters'");
    }

    @Test
    @DisplayName("test sumaEnters() amb cap valor")
    public void sumaEntersCapValor() {
        int[] entrada = {};
        int esperat = 0;
        int obtingut = SumaEnters.sumaEnters(entrada);
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb cap enter'");
    }

    @Test
    @DisplayName("test sumaEnters() amb un valor enter")
    public void sumaEntersUnValorEnter() {
        int[] entrada = {10};
        int esperat = 10;
        int obtingut = SumaEnters.sumaEnters(entrada);
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb un enter'");
    }

    @Test
    @DisplayName("test sumaEnters() amb alguns valors")
    public void sumaEntersMixEnters() {
        int[] entrada = {2, -4, 5};
        int esperat = 3;
        int obtingut = SumaEnters.sumaEnters(entrada);
        assertEquals(esperat, obtingut, "Revisa el cas en que l'entrada sigui un array amb alguns enters'");
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