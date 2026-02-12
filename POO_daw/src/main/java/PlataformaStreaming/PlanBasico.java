package PlataformaStreaming;

public class PlanBasico extends Suscripcion{
    public PlanBasico(double precio, String nombrePlan) {
        super(precio, nombrePlan);
    }

    @Override
    public void obtenerBeneficios() {
        System.out.println("Acceso a todo el contenido en calidad estándar sin anuncios.");
    }

    @Override
    public void obtenerPeriodoPrueba() {
        System.out.println("Periodo de prueba: 30 días de prueba gratuita");
    }
}
