package ECommerce;

/**
 * Clase abstracta
 * Todas las clases deben heredar de esta clase y tener el metodo
 */
public abstract class MetodoPago {

    /**
     * @param importe Importe a pagar
     */
    abstract void procesarPago(double importe);
}
