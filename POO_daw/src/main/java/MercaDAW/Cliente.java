package MercaDAW;

/**
 * Representa a un cliente de la tienda online.
 */
public class Cliente {
    private String usuario;
    private String contrasenya;
    private String direccion;
    private Pedido pedido;
    private Boolean promociones;

    /**
     * Crea un cliente con sus datos.
     *
     * @param usuario nombre de usuario
     * @param contrasenya contrasenya del cliente
     * @param direccion direccion de envío
     * @param pedido pedido actual del cliente
     */
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

    /**
     * Inicializa un pedido vacio.
     */
    public void crearPedido() {
        pedido = new Pedido();
        promociones = false;
    }

    /**
     * Devuelve el importe actual del pedido del cliente.
     *
     * @return importe total
     */
    public double importePedido() {
        if (pedido == null) {
            return 0;
        }
        return pedido.importePedido();
    }

    public Boolean getPromociones() {
        return promociones;
    }

    public void setPromociones(Boolean promociones) {
        this.promociones = promociones;
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
