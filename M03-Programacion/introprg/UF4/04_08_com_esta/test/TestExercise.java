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
        assertTrue(new GatRenat().estaEstirat(), "Renat ha de néixer estirat");
    }

    @ParameterizedTest
    @CsvSource(value={
        "estirat,true,false,false",
        "assegut,false,true,false",
        "dret,false,false,true"
    })
    @DisplayName("test consultes de posició")
    public void testRenatNeixEstirat(String posicio,
                                     boolean estaEstirat,
                                     boolean estaAssegut,
                                     boolean estaDret) {
        GatRenat renat = new GatRenat();
        renat.setPosicio(posicio);
        assertAll(
                () -> assertEquals(estaEstirat, renat.estaEstirat()),
                () -> assertEquals(estaAssegut, renat.estaAssegut()),
                () -> assertEquals(estaDret, renat.estaDret())
                );
    }

    @Test
    @DisplayName("test Renat neix viu")
    public void testRenatNeixViu() {
        assertTrue(new GatRenat().estaViu(), "Renat ha de néixer viu");
    }

    @Test
    @DisplayName("test Renat pot morir")
    public void testRenatPotMorir() {
        GatRenat renat = new GatRenat();
        renat.setVides(0);
        assertFalse(renat.estaViu(), "Renat no està viu amb 0 vides");
    }


    @Test
    @DisplayName("test Renat quan està dret")
    public void testRenatDret() {
        GatRenat renat = new GatRenat();
        renat.setPosicio("dret");

        assertAll("dret", 
                () -> assertTrue(renat.estaDret(), "Renat ha d'estar dret"),
                () -> assertFalse(renat.estaEstirat(), "Renat no pot estar estirat quan està dret"),
                () -> assertFalse(renat.estaAssegut(), "Renat no pot estar assegut quan està dret")
                );
    }


    @Test
    @DisplayName("test Renat.posicio és privat")
    public void testRenatPosicioEsPrivate() {
        assertTrue(UtilTests.classHasPrivateField(GatRenat.class, "posicio"),
                "Cal que la posició sigui privada per grantir que no pugui ser modificada malament");
    }

}