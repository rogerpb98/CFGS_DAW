import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise {

    @Test
    @DisplayName("test Renat neix estirat")
    public void testRenatNeixEstirat() {
        assertEquals("estirat", new GatRenat().getPosicio());
    }

    @ParameterizedTest
    @CsvSource(value={
        "estirat, estirat",
        "dret, dret",
        "assegut, assegut",
        "corrent, estirat",
        "saltant, estirat"
    })
    @DisplayName("test Renat quan canvia")
    public void testRenatNeixEstirat(String nouPosicio, String posicioFinal) {
        GatRenat renat = new GatRenat();
        renat.setPosicio(nouPosicio);
        assertEquals(posicioFinal, renat.getPosicio());
    }


    @Test
    @DisplayName("test Renat.posicio és privat")
    public void testRenatPosicioEsPrivate() {
        assertTrue(UtilTests.classHasPrivateField(GatRenat.class, "posicio"),
                "Cal que la posició sigui privada per grantir que no pugui ser modificada malament");
    }

}