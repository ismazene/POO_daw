package MonnegreFC;

/**
 * Excepcion que salta cuando se intenta asignar un dorsal que ya esta cogido en la misma categoria.
 */
public class ModificarJugador extends RuntimeException {

    public ModificarJugador() {
        super("El dorsal ya lo tiene un jugador...");
    }
}
