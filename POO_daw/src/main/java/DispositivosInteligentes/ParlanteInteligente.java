package DispositivosInteligentes;

public class ParlanteInteligente extends Dispositivo{

    public ParlanteInteligente(String nombre, boolean estado) {
        super(nombre, estado);
    }

    @Override
    void encender() {
        if (!super.isEstado()){
            System.out.println("Activando parlante con comando de voz...");
        }else {
            System.out.println("El parlante ya está encendido.");
        }
    }
}
