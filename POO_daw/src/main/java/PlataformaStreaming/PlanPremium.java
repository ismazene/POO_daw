package PlataformaStreaming;

public class PlanPremium extends Suscripcion{

    public PlanPremium(double precio, String nombrePlan) {
        super(precio, nombrePlan);
    }

    @Override
    public void obtenerBeneficios() {
        System.out.println("Acceso a todo el contenido en alta definición y descargas offline.");
    }

    @Override
    public void obtenerPeriodoPrueba() {
        System.out.println("Periodo de prueba: 14 días de prueba gratuita");
    }
}
