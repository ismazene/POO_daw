package PlataformaStreaming;

public abstract class Suscripcion {
    private String nombrePlan;
    private double precio;

    public Suscripcion(double precio, String nombrePlan) {
        this.precio = precio;
        this.nombrePlan = nombrePlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract void obtenerBeneficios();
    public abstract void obtenerPeriodoPrueba();

    /// Imprimir nombre del plan y el precio
    public void mostrarInfo() {
        System.out.println("Plan: " + getNombrePlan() + ", Precio: " + getPrecio());
    }

    @Override
    public String toString() {
        return "Suscripcion{" +
                "nombrePlan='" + nombrePlan + '\'' +
                ", precio=" + precio +
                '}';
    }
}
