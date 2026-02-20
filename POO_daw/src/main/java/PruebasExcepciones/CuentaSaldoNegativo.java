package PruebasExcepciones;

/// Con eso podemos hacer excepciones y tal para utilizarlas en los de mas metodos
public class CuentaSaldoNegativo extends RuntimeException {
    public CuentaSaldoNegativo() {
        super("El saldo tiene que ser positivo");
    }

}
