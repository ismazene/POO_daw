package Recuperacion_1.ContenidoMasVisto;

import java.util.*;

public class AppContenidoMasVisto {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> visualizaciones = new LinkedHashMap<>();

        registrarVisualizacion(visualizaciones, "isma", "Dark", 45);
        registrarVisualizacion(visualizaciones, "isma", "The Office", 20);
        registrarVisualizacion(visualizaciones, "patri", "Breaking Bad", 60);
        registrarVisualizacion(visualizaciones, "patri", "Dark", 15);

        mostrarSeriesRecomendables(visualizaciones);
    }

    public static void registrarVisualizacion(Map<String, Map<String, Integer>> visualizaciones,
                                              String usuario,
                                              String serie,
                                              int minutos) {
        visualizaciones.putIfAbsent(usuario, new LinkedHashMap<>());

        Map<String, Integer> seriesUsuario = visualizaciones.get(usuario);
        int minutosActuales = seriesUsuario.getOrDefault(serie, 0);
        seriesUsuario.put(serie, minutosActuales + minutos);
    }

    public static void mostrarSeriesRecomendables(Map<String, Map<String, Integer>> visualizaciones) {
        for (Map.Entry<String, Map<String, Integer>> entradaUsuario : visualizaciones.entrySet()) {
            String usuario = entradaUsuario.getKey();
            Map<String, Integer> series = entradaUsuario.getValue();

            System.out.println("Usuario: " + usuario);
            boolean hayRecomendaciones = false;

            for (Map.Entry<String, Integer> entradaSerie : series.entrySet()) {
                if (entradaSerie.getValue() >= 30) {
                    System.out.println("- " + entradaSerie.getKey() + " (" + entradaSerie.getValue() + " min)");
                    hayRecomendaciones = true;
                }
            }

            if (!hayRecomendaciones) {
                System.out.println("- Sin series para recomendar");
            }
        }
    }
}
