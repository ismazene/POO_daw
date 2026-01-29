package chalet;

import java.util.ArrayList;

public class Casa {
    private String direccion;
    private ArrayList<Habitacion> listaHabitaciones;

    public Casa(String direccion) {
        this.direccion = direccion;
        listaHabitaciones = new ArrayList<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void crearHabitacion (String nombre, Double metros){

        for (Habitacion habitacion : listaHabitaciones){
            if (habitacion.getNombre().equals(nombre)){
                System.out.println("La habitacion ya existe");
                return;
            }
        }

        Habitacion habitacion = new Habitacion(nombre, metros);
        listaHabitaciones.add(habitacion);
    }

    public void mostrarHabitaciones (){
        System.out.println("Habitaciones de la casa en la direccion: " + direccion);
        for (Habitacion habitacion : listaHabitaciones) {
            System.out.println("- " + habitacion.getNombre() + " con " + habitacion.getMetros() + " m2");
        }
    }

    public Habitacion getHabitacionMasGrande(){
        Habitacion maximo = listaHabitaciones.get(1);
        for (Habitacion habitacion : listaHabitaciones){
            if (maximo.getMetros()<habitacion.getMetros()){
                maximo=habitacion;
            }
        }
        return maximo;
    }


    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                '}';
    }
}
