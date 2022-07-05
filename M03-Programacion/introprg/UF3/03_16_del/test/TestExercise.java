/*
    Unit testing methods for exercise 03_11_show
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
        "-1,0",
        "0,-1",
        "8,0",
        "0,8",
        "-1,8",
        "8,-1",
        "-1,-1",
        "8,8",
    })
    @DisplayName("test eliminaFigura() quan coordenades fora de taulell")
    public void eliminaFiguraForaTaulell(int fila, int columna) {
        char[][] taulell = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'}
        };
        boolean found = Escacs.eliminaFigura(taulell, fila, columna);
        assertFalse(found, "Revisa la funció quan la coordenada és (" + fila + ", " + columna + ")");
    }

    @Test
    @DisplayName("test eliminafigura() retorna true quan la figura hi és")
    public void eliminaFiguraQuanHiEs() {
        char[][] taulell = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','R','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'}
        };
        boolean found = Escacs.eliminaFigura(taulell, 3, 4);
        assertTrue(found, "revisa la funció quan la figura a eliminar hi és");
    }

    @Test
    @DisplayName("test eliminafigura() retorna false quan la figura no hi és")
    public void eliminaFiguraQuanNoHiEs() {
        char[][] taulell = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'}
        };
        boolean found = Escacs.eliminaFigura(taulell, 7, 2);
        assertFalse(found, "revisa la funció quan la figura a eliminar no hi és");
    }

    @Test
    @DisplayName("Test hi és mòdul processaDel()")
    public void prgtestX1processaDel() {
        Class classe = Puzle.class;
        String modulObjectiu = "processaDel";
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
                    "java.lang.String[]",
                    types[0].getTypeName(),
                    "Revisa els paràmetres requerits pel mòdul " + modulObjectiu + "()"
                );
                assertEquals(
                        "void",
                        method.getGenericReturnType().getTypeName(),
                        "S'esperava " + modulObjectiu + "() d'un tipus diferent"
                );
            }
        }
        assertTrue(foundTarget, "No es troba el mòdul " + modulObjectiu + "(). Revisa enunciat.");
    }
}