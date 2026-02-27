package PracticoModeloA;

public enum CartaPizzas {
    BBQ(9),CARBONARA(8),JAMON(6), ATUN(7.5), HAWAIANA(7),VEGGIE(10);
    public final double precio;

    CartaPizzas(double precio){
        this.precio=precio;
    }

    public double getPrecio() {
        return precio;
    }

}
