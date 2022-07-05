import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class TestExercise {

    @Test
    @DisplayName("test bàsic de la classe")
    public void testHora() {
        Random r = new Random();
        Hora hora = new Hora();
        String horaDefault = hora.toString();
        boolean quanHoresNegatiu = hora.setHores(- (r.nextInt(5) + 1));
        boolean quanMinutsNegatiu = hora.setMinuts(- (r.nextInt(10) + 1));
        boolean quanSegonsNegatiu = hora.setSegons(- (r.nextInt(10) + 1));
        boolean quanHoresMassa = hora.setHores(24);
        boolean quanMinutsMassa = hora.setMinuts(60);
        boolean quanSegonsMassa = hora.setSegons(60);
        String horaFinal = hora.toString();

        assertAll(
                () -> assertEquals("0:00:00", horaDefault, "S'esperava l'hora per defecte 0:00:00"),
                () -> assertEquals("0:00:00", horaFinal, "S'esperava que no canviés l'hora"),
                () -> assertFalse(quanHoresNegatiu, "Els setters accepten valors no vàlids"),
                () -> assertFalse(quanHoresMassa, "Els setters accepten valors no vàlids"),
                () -> assertFalse(quanMinutsNegatiu, "Els setters accepten valors no vàlids"),
                () -> assertFalse(quanMinutsMassa, "Els setters accepten valors no vàlids"),
                () -> assertFalse(quanSegonsNegatiu, "Els setters accepten valors no vàlids"),
                () -> assertFalse(quanSegonsMassa, "Els setters accepten valors no vàlids")
                );
    }

}