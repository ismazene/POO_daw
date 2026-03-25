package MercaDAW;

import java.util.HashMap;
import java.util.Map;

/**
 * Es el pedido actual de un cliente.
 */
public class Pedido {

    private Map<Producto, Integer> mapa;
    private double importe_total;

    /**
     * Crea un pedido vacio.
     */
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

    /**
     * Inserta un producto en el pedido o suma una unidad si ya existe.
     *
     * @param producto producto que se quiere insertar
     */
    public void insertarProducto(Producto producto) {
        mapa.put(producto, mapa.getOrDefault(producto, 0) + 1);
    }

    /**
     * Elimina una unidad del producto
     * Si se queda a cero se elimina la clave del mapa.
     *
     * @param producto producto a eliminar
     * @return true si se ha eliminado algo, false si no estaba en el pedido
     */
    public boolean eliminarProducto(Producto producto) {
        if (!mapa.containsKey(producto)) {
            return false;
        }

        int cantidadActual = mapa.get(producto);
        if (cantidadActual <= 1) {
            mapa.remove(producto);
        } else {
            mapa.put(producto, cantidadActual - 1);
        }

        importePedido();
        return true;
    }

    /**
     * Calcula el importe total del pedido sin promociones.
     *
     * @return importe total
     */
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

    /**
     * Aplica la promocion 3x2 a todos los productos del pedido.
     */
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

    /**
     * Aplica un 10% de descuento al importe actual.
     */
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
