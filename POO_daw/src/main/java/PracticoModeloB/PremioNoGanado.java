package PracticoModeloB;

public class PremioNoGanado extends RuntimeException {
    public PremioNoGanado() {
        super("No has ganado el premio sientate anda");
    }
}
