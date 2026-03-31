package MercaDAW;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void constructorYGettersFuncionan() {
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente("isma", "1234", "Calle Mayor", pedido);

        assertEquals("isma", cliente.getUsuario());
        assertEquals("1234", cliente.getContrasenya());
        assertEquals("Calle Mayor", cliente.getDireccion());
        assertSame(pedido, cliente.getPedido());
        assertFalse(cliente.getPromociones());
    }

    @Test
    void crearPedidoInicializaPedidoVacioYSinPromociones() {
        Cliente cliente = new Cliente("isma", "1234", "Calle Mayor", null);
        cliente.setPromociones(true);

        cliente.crearPedido();

        assertNotNull(cliente.getPedido());
        assertTrue(cliente.getPedido().getMapa().isEmpty());
        assertFalse(cliente.getPromociones());
    }

    @Test
    void importePedidoDevuelveCeroSiNoHayPedidoYCalculaSiExiste() {
        Cliente cliente = new Cliente("isma", "1234", "Calle Mayor", null);
        assertEquals(0.0, cliente.importePedido());

        Pedido pedido = new Pedido();
        pedido.insertarProducto(Producto.PAN);
        pedido.insertarProducto(Producto.LECHE);
        cliente.setPedido(pedido);

        assertEquals(2.3, cliente.importePedido(), 0.0001);
    }
}
