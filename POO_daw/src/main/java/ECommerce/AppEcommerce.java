package ECommerce;

/**
 * Punto de entrada de la aplicacion.
 */
public class AppEcommerce {

    /**
     * Inicia la simulacion del pago en la tienda.
     *
     * @param args argumentos de linea de comandos
     * @throws InterruptedException si se interrumpe una pausa de validacion
     */
    public static void main(String[] args) throws InterruptedException {
        Tienda.iniciarPago();
    }
}
