package pruebasEnum;

public class Metodos {
    static void main() {

        Metodo opcion = Metodo.PAYPAL;

        System.out.println(opcion);

        /// Devuelve un vector
        for (Metodo metodo : Metodo.values()){
            System.out.println(metodo);
        }

    }
}
