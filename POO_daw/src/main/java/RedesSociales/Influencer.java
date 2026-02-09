package RedesSociales;

import java.util.ArrayList;

public class Influencer extends Usuario{
    private ArrayList<String> colaboraciones;
    public Influencer(String nombre, int edad, int seguidores, String nombreUsuario, ArrayList colaboraciones) {
        super(nombre, edad, seguidores, nombreUsuario);
        colaboraciones=new ArrayList<>();
    }

    public ArrayList<String> getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(ArrayList<String> colaboraciones) {
        this.colaboraciones = colaboraciones;
    }

    @Override
    public void mostrarInformacionUsuario(){
        super.mostrarInformacionUsuario();
        System.out.println("Estas son las colaboraciones en las que ha participado: " + colaboraciones);
    }

    @Override
    public String toString() {
        return "Influencer{" +
                "colaboraciones=" + colaboraciones +
                '}';
    }
}
