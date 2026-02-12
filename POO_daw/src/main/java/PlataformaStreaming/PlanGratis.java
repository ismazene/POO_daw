package PlataformaStreaming;

public class PlanGratis extends Suscripcion{

    public PlanGratis(double precio, String nombrePlan) {
        super(precio, nombrePlan);
    }

    @Override
    public void obtenerBeneficios() {
        System.out.println("Acceso limitado con anuncios");
    }

    @Override
    public void obtenerPeriodoPrueba() {
        System.out.println("Periodo de prueba: Sin periodo de prueba");
    }
}
