package MercaDAW;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void insertarProductoEImportePedidoFuncionan() {
        Pedido pedido = new Pedido();

        pedido.insertarProducto(Producto.PAN);
        pedido.insertarProducto(Producto.PAN);
        pedido.insertarProducto(Producto.LECHE);

        assertEquals(2, pedido.getMapa().get(Producto.PAN));
        assertEquals(1, pedido.getMapa().get(Producto.LECHE));
        assertEquals(3.3, pedido.importePedido(), 0.0001);
    }

    @Test
    void eliminarProductoDevuelveFalseSiNoExisteYReduceCantidadSiExiste() {
        Pedido pedido = new Pedido();

        assertFalse(pedido.eliminarProducto(Producto.ARROZ));

        pedido.insertarProducto(Producto.ARROZ);
        pedido.insertarProducto(Producto.ARROZ);

        assertTrue(pedido.eliminarProducto(Producto.ARROZ));
        assertEquals(1, pedido.getMapa().get(Producto.ARROZ));

        assertTrue(pedido.eliminarProducto(Producto.ARROZ));
        assertFalse(pedido.getMapa().containsKey(Producto.ARROZ));
    }

    @Test
    void promocionesActualizanElImporteTotal() {
        Pedido pedido = new Pedido();
        pedido.insertarProducto(Producto.PAN);
        pedido.insertarProducto(Producto.PAN);
        pedido.insertarProducto(Producto.PAN);

        pedido.aplicarPromo3x2();
        assertEquals(2.0, pedido.getImporte_total(), 0.0001);

        pedido.aplicarPromo10();
        assertEquals(1.8, pedido.getImporte_total(), 0.0001);
    }
}
