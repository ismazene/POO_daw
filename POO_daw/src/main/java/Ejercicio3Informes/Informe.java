package Ejercicio3Informes;
public class Informe {
    private int codigo;
    private String tipo;

    public Informe(int codigo, String tipo) {

        if(!tipo.equals("ADMINISTRATIVO") && !tipo.equals("EMPRESARIAL") && !tipo.equals("PERSONAL")){
            System.out.println("Tipo de tarea no válido");
        }

        this.codigo = codigo;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}