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
        "-1,0", "0,-1","0,1","1,0","3,4",
        "6,0", "7,-1", "8,0","7,1",
        "7,-1", "6,0","7,1","8,0",
        "7,6","6,7","7,8","8,7",
    })
    @DisplayName("test enroc quan coordenades fora de taulell")
    public void enrocQuanNoTorre(int fila, int columna) {
        char[][] taulell = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        boolean found = Escacs.enroc(taulell, fila, columna);
        assertFalse(found, "Revisa la funció quan les coordenades no corresponen a una posició inicial de torre");
    }

    @ParameterizedTest
    @CsvSource(value={
        "0,0", "0,7", "7,0", "7,7"
    })
    @DisplayName("test enroc quan és possible")
    public void enrocQuanPossible(int fila, int columna) {
        char[][] taulell = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        boolean found = Escacs.enroc(taulell, fila, columna);
        assertTrue(found, "Revisa el valor de retorn quan sí es pot enrocar");
    }

    @ParameterizedTest
    @CsvSource(value={
        "0,0", "0,7", "7,0", "7,7"
    })
    @DisplayName("test enroc quan falta la torre")
    public void enrocQuanFaltaTorre(int fila, int columna) {
        char[][] taulell = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        taulell[fila][columna] = '·';
        boolean found = Escacs.enroc(taulell, fila, columna);
        assertFalse(found, "Revisa el valor de retorn quan falta la torre");
    }

    @ParameterizedTest
    @CsvSource(value={
        "0,0", "0,7", "7,0", "7,7"
    })
    @DisplayName("test enroc quan falta el rei")
    public void enrocQuanFaltaRei(int fila, int columna) {
        char[][] taulell = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        taulell[fila][4] = '·';
        boolean found = Escacs.enroc(taulell, fila, columna);
        assertFalse(found, "Revisa el valor de retorn quan falta el rei");
    }

    @ParameterizedTest
    @CsvSource(value={
        "0,0", "0,7", "7,0", "7,7"
    })
    @DisplayName("test enroc quan peça entre mig")
    public void enrocQuanCamiOcupat(int fila, int columna) {
        char[][] taulell = {
            {'t','c','·','·','r','·','c','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','C','·','·','R','·','C','T'}
        };
        boolean found = Escacs.enroc(taulell, fila, columna);
        assertFalse(found, "Revisa el valor de retorn hi ha peça entre mig");
    }

    @Test
    @DisplayName("test enroc llarg blanques")
    public void enrocLlargBlanques() {
        char[][] taulellOrigen = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        char[][] taulellFinal = {
            {'·','·','r','t','·','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        Escacs.enroc(taulellOrigen, 0, 0);
        assertTaulellsIguals(taulellFinal, taulellOrigen,
                "Revisa l'enroc llarg de blanques");
    }

    @Test
    @DisplayName("test enroc curt blanques")
    public void enrocCurtBlanques() {
        char[][] taulellOrigen = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        char[][] taulellFinal = {
            {'t','·','·','·','·','t','r','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        Escacs.enroc(taulellOrigen, 0, 7);
        assertTaulellsIguals(taulellFinal, taulellOrigen, "Revisa l'enroc curt de blanques");
    }

    @Test
    @DisplayName("test enroc llarg negres")
    public void enrocLlargnegres() {
        char[][] taulellOrigen = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        char[][] taulellFinal = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','R','T','·','·','·','T'}
        };
        Escacs.enroc(taulellOrigen, 7, 0);
        assertTaulellsIguals(taulellFinal, taulellOrigen, "Revisa l'enroc llarg de negres");
    }

    @Test
    @DisplayName("test enroc curt negres")
    public void enrocCurtNegres() {
        char[][] taulellOrigen = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','R','·','·','T'}
        };
        char[][] taulellFinal = {
            {'t','·','·','·','r','·','·','t'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'·','·','·','·','·','·','·','·'},
            {'T','·','·','·','·','T','R','·'}
        };
        Escacs.enroc(taulellOrigen, 7, 7);
        assertTaulellsIguals(taulellFinal, taulellOrigen, "Revisa l'enroc curt de negres");
    }

    public static void assertTaulellsIguals(char[][] taulellExpected, char[][] taulellFound, String missatge) {
        for (int i=0; i<8;i++) {
            assertArrayEquals(taulellExpected[i], taulellFound[i], missatge);
        }
    }


}