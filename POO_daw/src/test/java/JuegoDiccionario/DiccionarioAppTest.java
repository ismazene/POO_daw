package JuegoDiccionario;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

public class DiccionarioAppTest {

    private HashMap<String, String> diccionario;

    @BeforeEach
    public void setUp() {
        // Creamos el diccionario antes de cada test
        diccionario = Diccionario.crearDiccionario();
    }

    @Test
    public void testDiccionarioNoVacio() {
        // Comprobamos que el diccionario existe y no está vacío
        assertNotNull(diccionario);
        assertFalse(diccionario.isEmpty());
    }

    @Test
    public void testAgregarPalabra() {
        // Agregamos un nuevo par y comprobamos que se guarda correctamente
        diccionario.put("casa", "house");
        assertEquals("house", diccionario.get("casa"));
    }

    @Test
    public void testTraduccionPerro() {
        // Comprobamos que la traducción de 'Perro' es 'Dog'
        assertEquals("dog", diccionario.get("perro"));
    }

    @Test
    public void testPrimeraLetraMesa() {
        // Comprobamos que la primera letra de la traducción de mesa es la t
        String traduccion = diccionario.get("mesa");
        assertNotNull(traduccion);
        assertEquals('t', traduccion.charAt(0));
    }

    @Test
    public void testPalabraNoExistente() {
        // Una palabra que no existe debe devolver null
        assertNull(diccionario.get("avion"));
    }

    @Test
    public void testNoSobreescribe() {
        String vieja = diccionario.get("perro");
        diccionario.putIfAbsent("perro", "dog");
        assertEquals(vieja, diccionario.get("perro"));
    }

    @Test
    public void testPalabraAleatoriaValida() {
        String palabraAleatoria = DiccionarioApp.palabraAleatoria(diccionario);
        assertTrue(diccionario.containsKey(palabraAleatoria), "La palabra aleatoria debe estar en el diccionario");
    }
}