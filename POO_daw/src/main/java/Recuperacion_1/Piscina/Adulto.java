package Recuperacion_1.Piscina;

public class Adulto extends Banista {
    public Adulto(int numero, String nombre, int edad, TipoUsuario tipoUsuario) {
        super(numero, nombre, edad, tipoUsuario);
    }

    @Override
    public void pagar() {
        System.out.println("Pago de adulto: 5 euros");
    }
}
