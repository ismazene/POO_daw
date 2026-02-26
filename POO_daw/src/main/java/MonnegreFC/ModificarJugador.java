package MonnegreFC;

public class ModificarJugador extends RuntimeException {
    public ModificarJugador() {
        super("El dorsal ya lo tiene un jugador...");
    }
}
