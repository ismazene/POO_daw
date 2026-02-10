package restaurante;

import java.util.ArrayList;

public class Encargado extends Persona{

    private ArrayList<Camarero> listaCamarero;
    private double salario;
    public Encargado(String nombre, String dni, double salario) {
        super(nombre, dni);
        this.salario = salario;
        listaCamarero=new ArrayList<>();
    }

    public ArrayList<Camarero> getListaCamarero() {
        return listaCamarero;
    }

    public void setListaCamarero(ArrayList<Camarero> listaCamarero) {
        this.listaCamarero = listaCamarero;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void echarBronca(){
        System.out.println("Sirve más rapido anda");
    }

    @Override
    public void mostrarInfoPersona(){
        super.mostrarInfoPersona();
        System.out.println("Encargado con salario: " + salario + " €");
        System.out.println("Camareros a cargo: ");
        for (Camarero camarero : listaCamarero){
            System.out.println("- " + camarero.getNombre());
        }
    }
    @Override
    public String toString() {
        return "Encargado{" +
                "listaCamarero=" + listaCamarero +
                ", salario=" + salario +
                '}';
    }
}
