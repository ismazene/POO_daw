package DispositivosInteligentes;

public class Televisor extends Dispositivo implements ControlRemoto{
    public Televisor(String nombre, boolean estado) {
        super(nombre, estado);
    }

    @Override
    public void sincronizar() {
        System.out.println("Sincronizando televisor con control remoto...");
    }

    @Override
    void encender() {
        if (!isEstado()){
            System.out.println("Encendiendo televisor...");
        }else {
            System.out.println("El televisor ya está encendido.");
        }
    }
}
