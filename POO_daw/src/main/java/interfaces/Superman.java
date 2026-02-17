package interfaces;

public class Superman extends Superheroe implements Voladores, Ataques{

    @Override
    public void volar() {
        System.out.println("Sobrevolando la ciudad vigilando a los malos");
    }

    @Override
    public void ojos_laser() {
        System.out.println("Saliendo lase de los ojos...");
    }

    @Override
    public void saltar() {
        System.out.println("Escupiedno hielos");
    }

    @Override
    public void hielo() {
        System.out.println("Saltando 10 metros");
    }

}
