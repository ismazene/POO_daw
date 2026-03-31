package Recuperacion_1.Parking;

public class Ticket implements Acciones{
    private String matricula;
    private Integer minutos;
    private Estado estado;

    public Ticket(String matricula, Integer minutos, Estado estado) {
        this.matricula = matricula;
        this.minutos = minutos;
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getMinutos() {
        return minutos;
    }
    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /// ------------------------------------------------------------------------------------------------------------- ///


    @Override
    public void generar() {

    }

    @Override
    public void recoger() {

    }

    @Override
    public void pagar() {

    }

    @Override
    public String toString() {
        return "Ticket{" +
                "matricula='" + matricula + '\'' +
                ", minutos=" + minutos +
                ", estado=" + estado +
                '}';
    }
}
