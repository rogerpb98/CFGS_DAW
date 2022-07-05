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
        "-1,0,0,0",
        "0,-1,0,0",
        "8,0,0,0",
        "0,8,0,0",
        "-1,8,0,0",
        "8,-1,0,0",
        "-1,-1,0,0",
        "8,8,0,0",

        "0,0,-1,0",
        "0,0,0,-1",
        "0,0,8,0",
        "0,0,0,8",
        "0,0,-1,8",
        "0,0,8,-1",
        "0,0,-1,-1",
        "0,0,8,8",

        "-1,0,-1,0",
        "0,-1,0,-1",
        "8,0,8,0",
        "0,8,0,8",
        "8,-1,-1,8",
        "-1,8,8,-1",
        "8,8,-1,-1",
        "-1,-1,8,8",
    })
    @DisplayName("test mouFigura() quan coordenades fora de taulell")
    public void posicionaFiguraForaTaulell(int filaOrigen, int columnaOrigen, int filaDest, int columnaDest) {
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
        char figura = 'p';
        boolean found = Escacs.mouFigura(taulell, filaOrigen, columnaOrigen, filaDest, columnaDest);
        assertFalse(found, "Revisa la funció quan les coordenades estan fora del taulell");
    }

    @ParameterizedTest
    @CsvSource(value={
        "5,4,4,2",
        "5,4,3,3",
        "5,4,3,5",
        "5,4,4,6",
        "5,4,6,6",
        "5,4,7,5",
        "5,4,7,3",
        "5,4,6,2",
    })
    @DisplayName("test mouFigura() retorna cert quan moviment és possible")
    public void mouFiguraQuanPosibleRetornaTrue(int filaOrigen, int columnaOrigen, int filaDest, int columnaDest) {
        char[][] taulell = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','C','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'}
        };
        boolean found = Escacs.mouFigura(taulell, filaOrigen, columnaOrigen, filaDest, columnaDest);
        assertTrue(found, "Revisa la funció quan es demana moure una figura existent a una posició lliure");
    }

    @ParameterizedTest
    @CsvSource(value={
        "5,4,4,2",
        "5,4,3,3",
        "5,4,3,5",
        "5,4,4,6",
        "5,4,6,6",
        "5,4,7,5",
        "5,4,7,3",
        "5,4,6,2",
    })
    @DisplayName("test mouFigura() posiciona la figura quan moviment és possible")
    public void mouFiguraQuanPosiblePosicionaEnDestinacio(int filaOrigen, int columnaOrigen, int filaDest, int columnaDest) {
        char[][] taulell = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','C','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'}
        };
        Escacs.mouFigura(taulell, filaOrigen, columnaOrigen, filaDest, columnaDest);
        assertTrue(taulell[filaDest][columnaDest] == 'C', "Revisa que la funció estigui posicionant la figura en destinació");
    }

    @ParameterizedTest
    @CsvSource(value={
        "5,4,4,2",
        "5,4,3,3",
        "5,4,3,5",
        "5,4,4,6",
        "5,4,6,6",
        "5,4,7,5",
        "5,4,7,3",
        "5,4,6,2",
    })
    @DisplayName("test mouFigura() elimina la figura de la posició d'origen")
    public void mouFiguraQuanPosibleAlliberaOrigen(int filaOrigen, int columnaOrigen, int filaDest, int columnaDest) {
        char[][] taulell = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','C','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'}
        };
        Escacs.mouFigura(taulell, filaOrigen, columnaOrigen, filaDest, columnaDest);
        assertTrue(taulell[filaOrigen][columnaOrigen] == '·', "Revisa que la funció estigui alliberant la posició d'origen");
    }

    @ParameterizedTest
    @CsvSource(value={
        "5,4,4,2",
        "5,4,3,3",
        "5,4,3,5",
        "5,4,4,6",
        "5,4,6,6",
        "5,4,7,5",
        "5,4,7,3",
        "5,4,6,2",
    })
    @DisplayName("test mouFigura() retorna fals quan la destinació està ocupada")
    public void mouFiguraQuanOcupadaRetornaFalse(int filaOrigen, int columnaOrigen, int filaDest, int columnaDest) {
        char[][] taulell = {
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','P','·','P','·','·'},
            {'·','·','P','·','·','·','P','·'},
            {'·','·','·','·','C','·','·','·'},
            {'·','·','P','·','·','·','P','·'},
            {'·','·','·','P','·','P','·','·'}
        };
        boolean found = Escacs.mouFigura(taulell, filaOrigen, columnaOrigen, filaDest, columnaDest);
        assertFalse(found, "Revisa la funció quan es demana moure una figura existent a una posició lliure");
    }

    @Test
    @DisplayName("test mouFigura() retorna fals quan l'origen està buit")
    public void mouFiguraQuanOrigenBuit() {
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
        assertFalse(Escacs.mouFigura(taulell, 1, 2, 3, 4), "Revisa el cas que l'origen no contingui cap figura");
    }

    @Test
    @DisplayName("Test hi és mòdul processaMv()")
    public void prgtestX1processaMv() {
        Class classe = Puzle.class;
        String modulObjectiu = "processaMv";
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
    @Test
    @DisplayName("Test hi és mòdul esEnter()")
    public void prgtestX2esEnter() {
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