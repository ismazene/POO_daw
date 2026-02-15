package ECommerce;

import RedesSociales.Usuario;

public class AppEcommerce {
    static void main() throws InterruptedException {
//        TarjetaCredito Prueba = new TarjetaCredito("1234567890123456");
//
//        Prueba.validarTarjeta();
//        Prueba.validarTipo();

//        PayPal Prueba2 = new PayPal(23,"La mia");
//        Prueba2.validarPayPal();

        Bizum Prueba3 = new Bizum("123456789", 123456);
        Prueba3.validarPago();

    }
}
