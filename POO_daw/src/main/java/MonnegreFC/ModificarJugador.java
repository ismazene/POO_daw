package MonnegreFC;

public class ModificarJugador extends RuntimeException {
    public ModificarJugador(String message) {
        super("El dorsal ya lo tiene un jugador...");
    }
}
