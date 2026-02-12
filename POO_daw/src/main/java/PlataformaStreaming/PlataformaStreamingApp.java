package PlataformaStreaming;

import java.util.ArrayList;

public class PlataformaStreamingApp {
    static void main() {

        PlanGratis Ismael = new PlanGratis(0, "Gratuito");
        PlanBasico Izan = new PlanBasico(5, "Basico");
        PlanPremium Jose = new PlanPremium(9.99, "Premium");
        PlanFamiliar Paula = new PlanFamiliar(15, "Familiar");

        ArrayList<Suscripcion> listaSuscripciones = new ArrayList<>();

        listaSuscripciones.add(Ismael);
        listaSuscripciones.add(Izan);
        listaSuscripciones.add(Jose);
        listaSuscripciones.add(Paula);

        for (Suscripcion suscripcion : listaSuscripciones){
            suscripcion.mostrarInfo();
            suscripcion.obtenerBeneficios();
            suscripcion.obtenerPeriodoPrueba();
        }
    }
}
