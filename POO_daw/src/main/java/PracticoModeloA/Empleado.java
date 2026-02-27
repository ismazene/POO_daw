package PracticoModeloA;

public class Empleado extends PizzaExpress implements AccionesPedido {
    private static int contador = 1;
    private String idEmpleado;
    private String nombre;

    public Empleado(String nombre) {
        this.idEmpleado = String.format("EMP%03d", contador++);
        this.nombre = nombre;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getNumeroEmpleadosCreados() {
        return contador - 1;
    }

    public void siguienteEstado(Pedido pedido) {
        Estado siguiente = pedido.getEstadoPedido().siguiente();
        if (siguiente != null) {
            pedido.setEstadoPedido(siguiente);
            System.out.println("Pedido " + pedido.getEstadoPedido());
        } else {
            System.out.println("No se puede avanzar mas el estado.");
        }
    }

    public void entregarPedido(Pedido pedido) throws PedidoNoListoException {
        if (pedido.getEstadoPedido() != Estado.LISTO) {
            throw new PedidoNoListoException("No se puede entregar. Estado actual: " + pedido.getEstadoPedido());
        }
        System.out.println("Pedido entregado por " + idEmpleado + " - " + nombre);
    }

    @Override
    public void obtenerDetalles() {
        System.out.println("Empleado -> ID: " + idEmpleado + " | Nombre: " + nombre);
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstadoPedido(Estado.CANCELADO);
        System.out.println("Pedido cancelado por el empleado " + idEmpleado);
    }
}
