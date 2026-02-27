package PracticoModeloB;

public class AppMutxaAwards {
    public static void main(String[] args) {
        Presentador patri = new Presentador(2025, "Patri");
        patri.obtenerDetalles();

        Artista ismael = new Artista(2025, "Ismael");
        Artista jose = new Artista(2025, "Jose");
        Artista lau = new Artista(2025, "Lau");
        Artista maria = new Artista(2025, "Maria");
        Artista vero = new Artista(2025, "Vero");

        ismael.alfombraRoja();
        jose.alfombraRoja();
        lau.alfombraRoja();
        maria.alfombraRoja();
        vero.alfombraRoja();

        ismael.aplaudir();
        jose.aplaudir();
        lau.aplaudir();
        maria.aplaudir();
        vero.aplaudir();

        patri.presentar();
        patri.darDiscurso("para solidarizarse con los afectados de la DANA");

        Premio premioActor = new Premio(2025, Categoria.MEJOR_ACTOR);

        ismael.esNominado(Categoria.MEJOR_ACTOR);
        jose.esNominado(Categoria.MEJOR_ACTOR);
        lau.esNominado(Categoria.MEJOR_ACTOR);
        maria.esNominado(Categoria.MEJOR_ACTOR);

        ismael.ganarPremio(premioActor);
        premioActor.setGanador(ismael);

        ismael.aplaudir();
        jose.aplaudir();
        lau.aplaudir();
        maria.aplaudir();
        vero.aplaudir();

        ismael.celebrarPremio("MEJOR_ACTOR");
        jose.celebrarPremio("MEJOR_ACTOR");
        lau.celebrarPremio("MEJOR_ACTOR");
        maria.celebrarPremio("MEJOR_ACTOR");
        vero.celebrarPremio("MEJOR_ACTOR");

        try {
            jose.recogerPremio(premioActor);
        } catch (PremioNoGanado e) {
            System.out.println(e.getMessage());
        }

        ismael.recogerPremio(premioActor);
        patri.entregarPremio(premioActor);
        ismael.darDiscurso("sobre el esfuerzo realizado para rodar la pelicula");

        ismael.aplaudir();
        jose.aplaudir();
        lau.aplaudir();
        maria.aplaudir();
        vero.aplaudir();

        patri.darDiscurso("para introducir el siguiente premio: MEJOR_PELICULA");

        Premio premioPelicula = new Premio(2025, Categoria.MEJOR_PELICULA);

        ismael.esNominado(Categoria.MEJOR_PELICULA);
        jose.esNominado(Categoria.MEJOR_PELICULA);
        maria.esNominado(Categoria.MEJOR_PELICULA);
        vero.esNominado(Categoria.MEJOR_PELICULA);

        maria.ganarPremio(premioPelicula);
        premioPelicula.setGanador(maria);

        ismael.celebrarPremio("MEJOR_PELICULA");
        jose.celebrarPremio("MEJOR_PELICULA");
        lau.celebrarPremio("MEJOR_PELICULA");
        maria.celebrarPremio("MEJOR_PELICULA");
        vero.celebrarPremio("MEJOR_PELICULA");

        maria.recogerPremio(premioPelicula);
        patri.entregarPremio(premioPelicula);
        maria.darDiscurso("sobre lo duro que ha sido conseguir financiacion");

        patri.darDiscurso("para despedir la gala");

        ismael.mostrarDetalles();
        jose.mostrarDetalles();
        lau.mostrarDetalles();
        maria.mostrarDetalles();
        vero.mostrarDetalles();
    }
}
