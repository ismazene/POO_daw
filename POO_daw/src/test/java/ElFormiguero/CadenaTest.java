package ElFormiguero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CadenaTest {

    @Test
    void insertarProgramaAgregaALista() {
        Cadena cadena = new Cadena("Antena 3");
        Programa programa = new Programa("El Hormiguero", cadena, "Ismael");

        assertTrue(cadena.getListaProgramas().contains(programa));
    }
}
