package CajeroAutomatico;

public class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        if (saldoInicial < 0) {
            saldo = 0;
        } else {
            saldo = saldoInicial;
        }
    }

    public void ingresar(double importe) throws DepositoMaximoException {
        validarImporte(importe);

        if (importe > 3000) {
            throw new DepositoMaximoException("No puedes ingresar más de 3000€");
        }

        saldo += importe;
        System.out.println("Ingreso realizado correctamente.");
    }

    public void retirar(double importe) throws SaldoInsuficienteException, LimiteDiarioException {
        validarImporte(importe);

        if (importe > 600) {
            throw new LimiteDiarioException("No puedes retirar más de 600€ por operación.");
        }

        if (importe > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }

        saldo -= importe;
        System.out.println("Retirada realizada correctamente.");
    }

    public double consultarSaldo() {
        return saldo;
    }

    private void validarImporte(double importe) {
        if (importe <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que 0.");
        }
    }
}