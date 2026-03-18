package MercaDAW;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    Map<Producto, Integer> mapa = new HashMap<>();
    private double importe_total;

    public Pedido(Map<Producto, Integer> mapa, double importe_total) {
        this.mapa = mapa;
        this.importe_total = importe_total;
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

    public void aplicarPromo3x2(){}
    public void aplicarPromo10(){}

    @Override
    public String toString() {
        return "Pedido{" +
                "mapa=" + mapa +
                ", importe_total=" + importe_total +
                '}';
    }
}
