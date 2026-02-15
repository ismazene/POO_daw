package ECommerce;

import java.util.Arrays;
import java.util.Scanner;

public class TarjetaCredito extends MetodoPago{
    static Scanner teclado = new Scanner(System.in);
    final static int NUMERO_MAX = 16;
    String [] tipoTarjetas = {"VISA", "MAESTRO", "MASTERCARD"};
    private String nro_tarjeta;

    public TarjetaCredito(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;

    }

    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public void validarTarjeta() throws InterruptedException {
        System.out.println("Dame el numero de la tarjeta, recuerda que solo se pueden 16 numeros (V,M o M)");
        String numero = teclado.nextLine();
        if (numero.length() == NUMERO_MAX && numero.matches("\\d+")){validarTipo();}

    }
    public void validarTipo() throws InterruptedException {
        System.out.println("Selecciona el tipo de tarjeta [VISA, MASTERCARD, MAESTRO]: ");
        String tipoTarjeta = teclado.nextLine();
        /// Devuelve true...
        if (Arrays.asList(tipoTarjetas).contains(tipoTarjeta)) {
            System.out.println("Validando tarjeta...");
            Thread.sleep(5000);
            System.out.println("Validacion COMPLETA!!");
        }
    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de [importe] € con tarjeta de crédito [Tipo de tarjeta]");
    }
}
