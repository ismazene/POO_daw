package restaurante;


public class Cliente extends Persona{
    private Integer mesa;
    private int numeroComensales;


    public Cliente (String nombre, String dni, int numeroComensales, Integer mesa) {
        super(nombre, dni);
        this.numeroComensales = numeroComensales;
        this.mesa = mesa;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public int getNumeroComensales() {
        return numeroComensales;
    }

    public void setNumeroComensales(int numeroComensales) {
        this.numeroComensales = numeroComensales;
    }

    @Override
    public void mostrarInfoPersona(){
        super.mostrarInfoPersona();
        System.out.println("Estas sentado en la mesa " + mesa + " y hay " + numeroComensales + " de comensales");
    }

    @Override
    public void accerderBanyo() {
        System.out.println("El clente se dirige al baño (vigilar)");
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "mesa=" + mesa +
                ", numeroComensales=" + numeroComensales +
                '}';
    }
}
