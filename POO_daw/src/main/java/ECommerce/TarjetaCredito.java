package ECommerce;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase de pago con tarjeta de crédito.
 */
public class TarjetaCredito extends MetodoPago {

    /** Scanner */
    static Scanner teclado = new Scanner(System.in);
    final static int NUMERO_MAX = 16;
    private String nro_tarjeta;
    private String tipoSeleccionado;
    String[] tipoTarjetas = {"VISA", "MAESTRO", "MASTERCARD"};

    /**
     * Constructor
     *
     * @param nro_tarjeta numero de la tarjeta
     */
    public TarjetaCredito(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    /**
     * Valida el pago de la tarjeta de crédito
     */
    public void validarPago() throws InterruptedException {
        System.out.println("Dame el numero de la tarjeta, recuerda que solo se pueden 16 numeros:");
        String numero = teclado.nextLine();

        if (numero.length() != NUMERO_MAX || !numero.matches("\\d+")) {
            System.out.println("Numero de tarjeta no valido");
            System.exit(0);
        }

        this.nro_tarjeta = numero;

        if (!validarTipo()) {
            System.out.println("Tipo de tarjeta no valido");
            System.exit(0);
        }

        System.out.println("Validando tarjeta...");
        Thread.sleep(5000);

        System.out.println("Introduce el importe a pagar:");
        double importe = Double.parseDouble(teclado.nextLine());

        procesarPago(importe);
    }

    /**
     * Valida el tipo de tarjeta
     *
     * @return true si el tipo de tarjeta es válido, false si no lo es
     */
    public boolean validarTipo() {
        System.out.println("Selecciona el tipo de tarjeta [VISA, MASTERCARD, MAESTRO]: ");
        String tipoTarjeta = teclado.nextLine().toUpperCase();

        if (Arrays.asList(tipoTarjetas).contains(tipoTarjeta)) {
            tipoSeleccionado = tipoTarjeta;
            return true;
        }
        return false;
    }

    /**
     * Procesa el pago
     *
     * @param importe Importe a pagar
     */
    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " € con tarjeta " + tipoSeleccionado);
        System.out.println("Pago aceptado. Muchas gracias.");
    }
}
