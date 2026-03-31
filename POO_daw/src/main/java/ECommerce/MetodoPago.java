package ECommerce;

import java.util.Scanner;

/**
 * Clase base para todos los metodos de pago.
 */
public abstract class MetodoPago {

    private final String nombre;

    /**
     * @param nombre nombre del metodo de pago
     */
    protected MetodoPago(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return nombre del metodo de pago
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Valida los datos propios del metodo de pago.
     *
     * @param teclado scanner compartido para leer datos del usuario
     * @return true si los datos son validos
     * @throws InterruptedException si se interrumpe la espera simulada
     */
    public abstract boolean validarDatos(Scanner teclado) throws InterruptedException;

    /**
     * Comprueba si el metodo puede pagar el importe indicado.
     *
     * @param importe importe a pagar
     * @return true si el metodo puede asumir el pago
     */
    public boolean puedePagar(double importe) {
        return true;
    }

    /**
     * Procesa el pago ya validado.
     *
     * @param importe importe a pagar
     */
    public abstract void procesarPago(double importe);
}
