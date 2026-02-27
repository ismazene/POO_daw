package PracticoModeloB;

public class Presentador extends MutxaAwards implements AccionesAsistentes {
    private String nombre;

    public Presentador(int anyo, String nombre) {
        super(anyo);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void presentar(){
        System.out.println("El presentador/ar " + nombre + " empieza a hablar...");
    }
    public void entregarPremio(Premio premio){
        System.out.println("El presentador " + nombre + " entrega el premio " + premio.getCategoria());
    }

    @Override
    public void obtenerDetalles() {
        System.out.println("Presentador: " + nombre + " | Edicion: " + getAnyo());
    }

    @Override
    public void aplaudir() {
        System.out.println(nombre + " aplaude");
    }

    @Override
    public void alfombraRoja() {
        System.out.println(nombre + " desfila por la alfombra roja");
    }

    @Override
    public void darDiscurso(String tematica) {
        System.out.println(nombre + " da un discurso: " + tematica);
    }

    @Override
    public void celebrarPremio(String premio) {
        System.out.println(nombre + " celebra el premio " + premio);
    }
}
