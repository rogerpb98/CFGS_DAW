import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestExercise {

    @Test
    @DisplayName("test Renat neix estirat")
    public void testRenatNeixEstirat() {
        assertEquals("estirat", new GatRenat().posicio);
    }
}