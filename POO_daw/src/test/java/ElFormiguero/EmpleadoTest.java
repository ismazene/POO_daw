package ElFormiguero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    void cargoInvalidoSeConvierteEnPte() {
        Empleado empleado = new Empleado("Ana", "cargo_raro", null);
        assertEquals("pte", empleado.getCargo());
    }
}
