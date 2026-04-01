package Recuperacion_1.Piscina;

public class Ninio extends Banista {
    private String telefonoTutor;

    public Ninio(int numero, String nombre, int edad, TipoUsuario tipoUsuario, String telefonoTutor) {
        super(numero, nombre, edad, tipoUsuario);
        this.telefonoTutor = telefonoTutor;
    }

    public String getTelefonoTutor() {
        return telefonoTutor;
    }

    public void setTelefonoTutor(String telefonoTutor) {
        this.telefonoTutor = telefonoTutor;
    }

    @Override
    public void pagar() {
        System.out.println("Pago de ninio: 2 euros");
    }

    @Override
    public String toString() {
        return "Ninio{" +
                "numero=" + getNumero() +
                ", nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", telefonoTutor='" + telefonoTutor + '\'' +
                '}';
    }
}
