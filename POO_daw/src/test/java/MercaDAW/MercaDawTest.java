package MercaDAW;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MercaDawTest {

    @Test
    void constructorInicializaListaVacia() {
        MercaDaw mercaDaw = new MercaDaw();

        assertNotNull(mercaDaw.getListaClientes());
        assertTrue(mercaDaw.getListaClientes().isEmpty());
    }

    @Test
    void generarUsuarioDevuelveCadenaDeOchoCaracteres() {
        MercaDaw mercaDaw = new MercaDaw();

        String usuario = mercaDaw.generarUsuario();

        assertNotNull(usuario);
        assertEquals(8, usuario.length());
        assertTrue(usuario.matches("[A-Za-z0-9]{8}"));
    }

    @Test
    void generarContrasenyaDevuelveCadenaDeOchoCaracteres() {
        MercaDaw mercaDaw = new MercaDaw();

        String contrasenya = mercaDaw.generarContrasenya();

        assertNotNull(contrasenya);
        assertEquals(8, contrasenya.length());
        assertTrue(contrasenya.matches("[A-Za-z0-9]{8}"));
    }

    @Test
    void generarClientesAnyadeEntreUnoYQuinceClientes() {
        MercaDaw mercaDaw = new MercaDaw();

        mercaDaw.generarClientes();

        assertTrue(mercaDaw.getListaClientes().size() >= 1);
        assertTrue(mercaDaw.getListaClientes().size() <= 15);
    }
}
