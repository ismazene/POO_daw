package MercaDAW;

import java.util.HashMap;
import java.util.Map;

public class Pedido {

    private Map<Producto, Integer> mapa;
    private double importe_total;

    public Pedido() {
        mapa = new HashMap<>();
        importe_total = 0;
    }

    public Map<Producto, Integer> getMapa() {
        return mapa;
    }

    public void setMapa(Map<Producto, Integer> mapa) {
        this.mapa = mapa;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    public void insertarProducto(Producto producto) {
        mapa.put(producto, mapa.getOrDefault(producto, 0) + 1);
    }

    public double importePedido() {
        double total = 0;

        for (Map.Entry<Producto, Integer> entry : mapa.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();

            total += producto.getPrecio() * cantidad;
        }

        this.importe_total = total;
        return total;
    }

    public void aplicarPromo3x2() {
        double total = 0;

        for (Map.Entry<Producto, Integer> entry : mapa.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();

            int gruposDe3 = cantidad / 3;
            int restantes = cantidad % 3;

            int unidadesPagadas = (gruposDe3 * 2) + restantes;

            total += unidadesPagadas * producto.getPrecio();
        }

        this.importe_total = total;
    }

    public void aplicarPromo10() {
        this.importe_total = this.importe_total * 0.9;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "mapa=" + mapa +
                ", importe_total=" + importe_total +
                '}';
    }
}