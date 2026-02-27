package PracticoModeloA;

public class Cliente extends PizzaExpress implements AccionesPedido {
    private String nombre;
    private int descuento = 20;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(String nombre, int descuento) {
        this(nombre);
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void pedir() {
        System.out.println(nombre + ", que te apetece hoy?");
    }

    public void pagar(Pedido pedido) {
        System.out.printf("Pagando pedido. Total final: %.2f EUR%n", pedido.calcularTotalConDescuento());
    }

    public void recoger() {
        System.out.println(nombre + " ha recogido su pedido.");
    }

    public double aplicarDescuento(double total) {
        return total - (total * descuento / 100.0);
    }

    @Override
    public void obtenerDetalles() {
        System.out.println("Cliente -> Nombre: " + nombre + " | Descuento: " + descuento + "%");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstadoPedido(Estado.CANCELADO);
        System.out.println("Pedido cancelado por el cliente " + nombre);
    }
}
