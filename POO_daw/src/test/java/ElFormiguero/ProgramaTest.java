package ElFormiguero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramaTest {

    @Test
    void constructorInicializaPrograma() {
        Cadena cadena = new Cadena("Antena 3");
        Programa programa = new Programa("El Hormiguero", cadena, "Director1");

        assertEquals("El Hormiguero", programa.getNombre());
        assertEquals(cadena, programa.getCadena());
        assertNotNull(programa.getDirector());
        assertFalse(programa.getListaEmpleados().isEmpty());
    }

    @Test
    void insertarEmpleadoAgregaALaLista() {
        Cadena cadena = new Cadena("Antena 3");
        Programa programa = new Programa("El Hormiguero", cadena, "Director1");

        programa.insertarEmpleado(new Empleado("Sandra", "productora", null));

    }

    @Test
    void insertarInvitadoAgregaALaLista() {
        Cadena cadena = new Cadena("Antena 3");
        Programa programa = new Programa("El Hormiguero", cadena, "Director1");

        programa.insertarInvitado("Aitana", "cantante", 1);

    }

    @Test
    void buscarInvitadoDevuelveTrueFalse() {
        Cadena cadena = new Cadena("Antena 3");
        Programa programa = new Programa("El Hormiguero", cadena, "Director1");

        programa.insertarInvitado("Aitana", "cantante", 1);

        assertTrue(programa.buscarInvitado("Aitana"));
        assertFalse(programa.buscarInvitado("Shakira"));
    }
}
