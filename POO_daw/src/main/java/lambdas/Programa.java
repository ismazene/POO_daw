package lambdas;

public class Programa {
    public static void main(String[] args) {

        Prueba anonima = new Prueba() {
            @Override
            public char saludar(String nombre) {
                System.out.println("Hola " + nombre + " soy una anonima");
                return nombre.charAt(nombre.length() - 1);
            }
        };

        Prueba lambda = (String nombre) -> {
            System.out.println("Hola " + nombre + " soy lambda");
            int num = (nombre.length() - 1) / 2;
            return nombre.charAt(num);
        };

        System.out.println(anonima.saludar("Ivan"));
        System.out.println(lambda.saludar("Ismael"));
    }
}