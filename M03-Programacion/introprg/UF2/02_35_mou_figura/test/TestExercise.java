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

}