package MercaDAW;

import java.util.HashMap;

public class Cliente {
    private String usuario;
    private String contrasenya;
    private String direccion;
    private Pedido pedido;
    private Boolean promociones;

    public Cliente(String usuario, String contrasenya, String direccion, Pedido pedido) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.direccion = direccion;
        this.pedido = pedido;
        this.promociones = false;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void crearPedido() {
        pedido = new Pedido(new HashMap<>(), 0);
    }

    public void insertarProducto() {
    }

    public double importePedido() {
        return 0;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "usuario='" + usuario + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", direccion='" + direccion + '\'' +
                ", promociones=" + promociones +
                ", pedido=" + pedido +
                '}';
    }
}
