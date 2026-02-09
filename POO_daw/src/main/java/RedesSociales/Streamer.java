package RedesSociales;

public class Streamer extends Usuario{
    private int numero_retransmisiones;
    private int horas_directo;

    public Streamer(String nombre, int edad, int seguidores, String nombreUsuario, int numero_retransmisiones, int horas_directo) {
        super(nombre, edad, seguidores, nombreUsuario);
        this.horas_directo = horas_directo;
        this.numero_retransmisiones = numero_retransmisiones;

    }

    public int getNumero_retransmisiones() {
        return numero_retransmisiones;
    }

    public void setNumero_retransmisiones(int numero_retransmisiones) {
        this.numero_retransmisiones = numero_retransmisiones;
    }

    public int getHoras_directo() {
        return horas_directo;
    }

    public void setHoras_directo(int horas_directo) {
        this.horas_directo = horas_directo;
    }

    @Override

    public void mostrarInformacionUsuario(){
        super.mostrarInformacionUsuario();
        System.out.println("Esta es la informacion del streamer:" +
                "- Horas: " + horas_directo +
                "- Numero de restransmisiones " + numero_retransmisiones);
    }

        @Override
    public String toString() {
        return "Streamer{" +
                "numero_retransmisiones=" + numero_retransmisiones +
                ", horas_directo=" + horas_directo +
                '}';
    }
}
