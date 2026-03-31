package Recuperacion_1.TicketMutxa;

public enum MetodoPago {

    BIZUM(0),PAYPAL(3),TARJETA(1.5),APPLEPAY(0);

    public final double precio;

    MetodoPago(double precio){
        this.precio=precio;
    }

    public double getPrecio() {
        return precio;
    }
}
