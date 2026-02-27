package MonnegreFC;

/**
 * Excepcion que salta cuando el formato de formacion no es valido.
 */
public class FormatoFormacion extends RuntimeException {
    public FormatoFormacion() {
        super("El formato de la formacion hacerlo bien");
    }
}
