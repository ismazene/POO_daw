package MonnegreFC;

/**
 * Define acciones deportivas comunes
 */
public interface AccionesDeportivas {
    /**
     * Entrenar
     */
    void entrenar();

    /**
     * Ejecuta la accion
     *
     * @param rival nombre del otro equipo
     */
    void jugarPartidos(String rival);
}
