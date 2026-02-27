package PracticoModeloA;

public enum Estado {
    CREANDO,
    CANCELADO,
    RECIBIDO,
    MONTANDO_PIZZA,
    HORNEANDO,
    PREPARANDO_PEDIDO,
    LISTO;

    public Estado siguiente() {
        return switch (this) {
            case CREANDO -> RECIBIDO;
            case RECIBIDO -> MONTANDO_PIZZA;
            case MONTANDO_PIZZA -> HORNEANDO;
            case HORNEANDO -> PREPARANDO_PEDIDO;
            case PREPARANDO_PEDIDO -> LISTO;
            case LISTO, CANCELADO -> null;
        };
    }
}
