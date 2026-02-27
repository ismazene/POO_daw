package PracticoModeloA;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido extends PizzaExpress {
    private final List<CartaPizzas> listaPizzas = new ArrayList<>();
    private Cliente cliente;
    private Estado estadoPedido;

    public Pedido(Cliente cliente, Estado estadoPedido) {
        this.cliente = cliente;
        this.estadoPedido = estadoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(Estado estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public boolean agregarPizzaPorNombre(String nombrePizza) {
        CartaPizzas pizza = CartaPizzas.valueOf(nombrePizza.trim().toUpperCase());
        listaPizzas.add(pizza);
        return true;
    }

    public void mostrarCarta() {
        System.out.println("Carta de pizzas:");
        for (CartaPizzas pizza : CartaPizzas.values()) {
            System.out.printf("- %s (%.2f EUR)%n", pizza.name(), pizza.getPrecio());
        }
    }

    public int getCantidadPizzas() {
        return listaPizzas.size();
    }

    public List<CartaPizzas> getListaPizzas() {
        return Collections.unmodifiableList(listaPizzas);
    }

    public double calcularTotalSinDescuento() {
        double total = 0;
        for (CartaPizzas pizza : listaPizzas) {
            total += pizza.getPrecio();
        }
        return total;
    }

    public double calcularDescuentoAplicado() {
        return calcularTotalSinDescuento() * cliente.getDescuento() / 100.0;
    }

    public double calcularTotalConDescuento() {
        return cliente.aplicarDescuento(calcularTotalSinDescuento());
    }

    @Override
    public void obtenerDetalles() {
        System.out.println("Pedido de " + cliente.getNombre() + " | Estado: " + estadoPedido + " | Pizzas: " + listaPizzas);
    }

}
