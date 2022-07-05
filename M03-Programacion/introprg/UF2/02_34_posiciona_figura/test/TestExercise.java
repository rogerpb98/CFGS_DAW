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
        "-1,0",
        "0,-1",
        "8,0",
        "0,8",
        "-1,8",
        "8,-1",
        "-1,-1",
        "8,8",
    })
    @DisplayName("test posicionaFigura() quan coordenades fora de taulell")
    public void posicionaFiguraForaTaulell(int fila, int columna) {
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
        boolean found = Escacs.posicionaFigura(taulell, fila, columna, figura);
        assertFalse(found, "Revisa la funció quan la coordenada és (" + fila + ", " + columna + ")");
    }

    @ParameterizedTest
    @CsvSource(value={
        "0,0",
        "0,1",
        "0,7",
        "1,0",
        "7,0",
        "3,4",
        "7,7",
    })
    @DisplayName("test posicionafigura() retorna true quan coordenades dins del taulell")
    public void posicionaFiguraDinsRetornaTrue(int fila, int columna) {
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
        boolean found = Escacs.posicionaFigura(taulell, fila, columna, figura);
        assertTrue(found, "revisa la funció quan la coordenada és (" + fila + ", " + columna + ") i casella lliure");
    }

    @ParameterizedTest
    @CsvSource(value={
        "0,0",
        "0,1",
        "0,7",
        "1,0",
        "7,0",
        "3,4",
        "7,7",
    })
    @DisplayName("test posicionafigura() col·loca figura quan coordenades dins del taulell")
    public void posicionafiguraDinsPosiciona(int fila, int columna) {
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
        Escacs.posicionaFigura(taulell, fila, columna, figura);
        char found = taulell[fila][columna];
        assertEquals(figura, found, "revisa que la funció posicioni la figura quan la coordenada és (" + fila + ", " + columna + ") i casella lliure");
    }

    @ParameterizedTest
    @CsvSource(value={
        "0,0",
        "0,1",
        "0,7",
        "1,0",
        "7,0",
        "3,4",
        "7,7",
    })
    @DisplayName("test posicionafigura() retorna false quan coordenades dins del taulell però ocupades")
    public void posicionaFiguraDinsOcupadaRetornaFalse(int fila, int columna) {
        char[][] taulell = {
            {'r','r','·','·','·','·','·','r'},
            {'r','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','r','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'r','·','·','·','·','·','·','r'}
        };
        char figura = 'p';
        boolean found = Escacs.posicionaFigura(taulell, fila, columna, figura);
        assertFalse(found, "revisa la funció quan la coordenada és (" + fila + ", " + columna + ") i casella ocupada");
    }

    @ParameterizedTest
    @CsvSource(value={
        "0,0",
        "0,1",
        "0,7",
        "1,0",
        "7,0",
        "3,4",
        "7,7",
    })
    @DisplayName("test posicionafigura() col·loca figura quan coordenades dins del taulell")
    public void posicionafiguraDinsOcupadaNoPosiciona(int fila, int columna) {
        char[][] taulell = {
            {'r','r','·','·','·','·','·','r'},
            {'r','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','r','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'r','·','·','·','·','·','·','r'}
        };
        char figura = 'p';
        Escacs.posicionaFigura(taulell, fila, columna, figura);
        char expected = 'r';
        char found = taulell[fila][columna];
        assertEquals(expected, found, "revisa que la funció posicioni la figura quan la coordenada és (" + fila + ", " + columna + ") i casella ocupada");
    }

}