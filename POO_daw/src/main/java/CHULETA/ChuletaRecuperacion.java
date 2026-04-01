package CHULETA;

import java.time.LocalDate;
import java.util.*;

public class ChuletaRecuperacion {

    static Scanner teclado = new Scanner(System.in);
    static Random random = new Random();


    ///
    /// Si cae polimorfismo:
    ///   “Se ejecuta el método de la subclase porque el objeto real es de ese tipo. Eso es polimorfismo dinámico.”
    ///
    ///   Si cae “¿y si no sobrescribe?”:
    ///   “Si la subclase no sobrescribe el método, se ejecuta el heredado de la clase padre.”
    ///
    ///   Si cae encapsulación:
    ///   “El problema es que el atributo público puede recibir valores inválidos. La solución es ponerlo private y controlar el
    ///   acceso con getter y setter, validando el dato.”
    ///
    ///   Si cae herencia múltiple:
    ///   “Java no permite herencia múltiple de clases para evitar ambigüedades. La alternativa es implementar varias
    ///   interfaces.”
    ///
    ///   Si cae Iterator:
    ///   “No se debe borrar con for-each porque puede lanzar ConcurrentModificationException. Con Iterator sí se puede usando
    ///   remove().”
    ///
    ///   Si cae excepción personalizada:
    ///   “Se crea una clase que hereda de Exception o RuntimeException para representar un error concreto del dominio, por
    ///   ejemplo saldo insuficiente.”
    ///
    ///   Si cae recursividad:
    ///   “Un método recursivo se llama a sí mismo y necesita un caso base para terminar. Las llamadas pendientes se guardan en
    ///   la pila de llamadas.”
    ///
    ///   Si cae “¿qué pasa si no hay caso base correcto?”:
    ///   “La recursión no termina y puede producir un StackOverflowError.”
    ///
    ///   Si cae matrices:
    ///   “En una matriz, el primer índice es la fila y el segundo la columna: matriz[i][j].”
    ///
    ///   Si cae vector/array:
    ///   “Se recorre normalmente con un for desde 0 hasta length - 1.”
    ///
    ///   Si cae traza de bucles:
    ///   “Hay que seguir la ejecución paso a paso, anotando en cada vuelta los valores de las variables y el acumulador.”
    ///
    ///   Si cae diagrama de flujo:
    ///   “Primero identifico entradas, luego proceso, después decisión si la hay, y por último salida.”
    /*
    ######################################################################
    # CHULETA DE RECUPERACION
    ######################################################################
    # Archivo pensado para COPIAR Y PEGAR.
    # Usa Ctrl + F y busca por estas etiquetas:
    #
    # [INDICE]
    # [MAIN]
    # [ATRIBUTOS]
    # [CONSTRUCTOR]
    # [ENUM]
    # [INTERFAZ]
    # [ABSTRACTA]
    # [HERENCIA]
    # [RANDOM]
    # [LOGIN]
    # [LISTAS]
    # [SET]
    # [MAPAS]
    # [COLAS]
    # [STACK]
    # [ITERATOR]
    # [ORDENAR]
    # [BUSCAR]
    # [MENU]
    # [EXCEPCIONES]
    # [VECTORES]
    # [MATRICES]
    # [RECURSIVIDAD]
    # [TEORIA]
    # [CHECKLIST]
    ######################################################################
    */

    /*
    ######################################################################
    # [INDICE]
    ######################################################################
    #  1. [MAIN] MAIN BASE DE EXAMEN
    #  2. [ATRIBUTOS] ATRIBUTOS TIPICOS
    #  3. [CONSTRUCTOR] CONSTRUCTOR + GETTERS/SETTERS
    #  4. [ENUM] ENUMS
    #  5. [INTERFAZ] INTERFACES.
    #  6. [ABSTRACTA] CLASE ABSTRACTA
    #  7. [HERENCIA] HERENCIA
    #  8. [RANDOM] METODOS UTILES
    #  9. [RANDOM] GENERAR USUARIOS ALEATORIOS
    # 10. [RANDOM] GENERAR CLIENTES ALEATORIOS
    # 11. [LISTAS] INSERTAR OBJETOS POR TIPO
    # 12. [LOGIN] AUTENTICACION
    # 13. [ORDENAR] ORDENAR POR FECHA
    # 14. [ORDENAR] COMPARATOR
    # 15. [ORDENAR] COMPARING
    # 16. [BUSCAR] BUSCAR Y DEVOLVER OBJETO
    # 17. [BUSCAR] GET POR OPCION
    # 18. [LISTAS] MOSTRAR LISTA
    # 19. [MAPAS] CARRITO
    # 20. [MAPAS] HASHMAP BASICO
    # 21. [COLAS] COLA VIRTUAL
    # 22. [MENU] MENU CON SWITCH
    # 23. [VALIDACION] IF TIPICO
    # 24. [ITERATOR] BORRAR CON ITERATOR
    # 25. [ITERATOR] LISTITERATOR
    # 26. [HERENCIA] INSTANCEOF
    # 27. [FECHAS] FECHA ACTUAL
    # 28. [EXCEPCIONES] EXCEPCION PERSONALIZADA
    # 29. [EXCEPCIONES] LANZAR EXCEPCION
    # 30. [EXCEPCIONES] PATRONES REALES
    # 31. [EXCEPCIONES] VALIDAR IMPORTE
    # 32. [ENUM] CAMBIO DE ESTADO
    # 33. [CALCULO] IMPORTE
    # 34. [TOSTRING] TOSTRING
    # 35. [EQUALS] EQUALS Y HASHCODE
    # 36. [MAIN] MAIN TIPO PARKING
    # 37. [MAIN] MAIN TIPO TICKETMUTXA
    # 38. [MAIN] MAIN TIPO PAGO
    # 39. [LISTAS] ARRAYLIST BASICO
    # 40. [SET] SET BASICO
    # 41. [TEORIA] RESPUESTAS RAPIDAS
    # 42. [VECTORES] VECTORES
    # 43. [MATRICES] MATRICES
    # 44. [RECURSIVIDAD] RECURSIVIDAD
    # 45. [TRAZAS] TRAZA DE BUCLES
    # 46. [CHECKLIST] RECORDATORIO PRACTICO
    # 47. [STACK] PILA BASICA
    # 48. [STACK] INVERTIR DATOS
    # 49. [STACK] PARENTESIS BALANCEADOS
    # 50. [STACK] POSTFIJA
    # 51. [STRINGS] CHARAT
    # 52. [STRINGS] VALIDAR CADENA FINAL
    # 53. [STRINGS] SPLIT
    # 54. [LISTAS] ARRAYLIST DE OBJETOS
    # 55. [MAPAS] DICCIONARIO
    # 56. [MAPAS] RECORRER HASHMAP
    # 57. [ABSTRACTA] ABSTRACTA SENCILLA
    # 58. [INTERFAZ] VARIAS INTERFACES
    # 59. [INTERFAZ] INTERFAZ MINIMA
    # 60. [SWITCH] SWITCH CON STRING
    # 61. [HERENCIA] CREAR OBJETO SEGUN TIPO
    # 62. [ITERATOR] REMOVEIF
    # 63. [ITERATOR] ELIMINAR SIN LAMBDAS
    # 64. [VALIDACION] DUPLICADOS EN LISTA
    # 65. [SET] DUPLICADOS EN SET
    # 66. [RANDOM] FORMULAS RANDOM
    # 67. [LISTAS] FOR EACH
    # 68. [LISTAS] FOR CLASICO
    # 69. [FECHAS] COMPARAR FECHAS
    # 70. [EXCEPCIONES] TRY CATCH
    # 71. [EXCEPCIONES] THROW SIMPLE
    # 72. [PLANTILLA] CLASE TIPO EXAMEN
    # 73. [CHECKLIST] CHECKLIST FINAL
    ######################################################################
    */

    /*
    ######################################################################
    # 1. [MAIN] MAIN BASE DE EXAMEN
    ######################################################################

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
    }
    */

    /*
    ######################################################################
    # 2. [ATRIBUTOS] ATRIBUTOS TIPICOS
    ######################################################################

    private String nombre;
    private int edad;
    private double precio;
    private LocalDate fecha;
    private Estado estado;

    private List<Ticket> listaTickets = new ArrayList<>();
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private Set<Usuario> usuariosRegistrados = new LinkedHashSet<>();
    private Map<Evento, Integer> carrito = new HashMap<>();
    private Queue<Usuario> cola = new LinkedList<>();
    */

    /*
    ######################################################################
    # 3. [CONSTRUCTOR] CONSTRUCTOR + GETTERS/SETTERS + ENCAPSULACION
    ######################################################################

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        }
    }
    */

    /*
    ######################################################################
    # 4. [ENUM] ENUM
    ######################################################################

    public enum Estado {
        PENDIENTE, GENERADO, RECOGIDO, PAGADO
    }

    public enum TipoUsuario {
        ADULTO, NINIO, INVITADO
    }
    */

    /*
    ######################################################################
    # 5. [INTERFAZ] INTERFAZ
    ######################################################################

    public interface Acciones {
        void generar();
        void recoger();
        void pagar();
    }
    */

    /*
    ######################################################################
    # 6. [ABSTRACTA] CLASE ABSTRACTA
    ######################################################################

    public abstract class MetodoPago {
        private String nombre;

        public MetodoPago(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public abstract boolean validarDatos(Scanner teclado) throws InterruptedException;
        public abstract void procesarPago(double importe);
    }
    */

    /*
    ######################################################################
    # 7. [HERENCIA] HERENCIA
    ######################################################################

    public class Adulto extends Banista {
        public Adulto(int numero, String nombre, int edad, TipoUsuario tipo) {
            super(numero, nombre, edad, tipo);
        }

        @Override
        public void pagar() {
            System.out.println("Pago de adulto");
        }
    }
    */

    /*
    ######################################################################
    # 8. [RANDOM] METODOS UTILES REALES
    ######################################################################
    */

    public static String generarMatriculaAleatoria() {
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";
        String matricula = "";

        for (int i = 0; i < 4; i++) {
            matricula += numeros.charAt(random.nextInt(numeros.length()));
        }

        for (int i = 0; i < 3; i++) {
            matricula += letras.charAt(random.nextInt(letras.length()));
        }

        return matricula;
    }

    public static String generarCadenaAleatoria(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String resultado = "";

        for (int i = 0; i < longitud; i++) {
            resultado += caracteres.charAt(random.nextInt(caracteres.length()));
        }

        return resultado;
    }

    public static int leerEnteroSeguro(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            System.out.print("> ");
            String texto = teclado.nextLine();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un numero entero.");
            }
        }
    }

    public static double leerDoubleSeguro(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            System.out.print("> ");
            String texto = teclado.nextLine();
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un numero valido.");
            }
        }
    }

    public static void pausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /*
    ######################################################################
    # 9. [RANDOM] GENERAR USUARIOS ALEATORIOS SIN REPETIR
    # Patron real de TicketMutxa
    ######################################################################

    static Set<Usuario> usuariosRegistrados = new LinkedHashSet<>();

    public static void generarUsuarios(int cantidad) {
        while (usuariosRegistrados.size() < cantidad) {
            String usuario = generarCadenaAleatoria(8);
            String contrasena = generarCadenaAleatoria(8);

            boolean repetido = false;
            for (Usuario u : usuariosRegistrados) {
                if (u.getNombre_usuario().equals(usuario)) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) {
                Usuario nuevo = new Usuario(usuario, contrasena);
                usuariosRegistrados.add(nuevo);
                System.out.println("Chivato -- " + usuario + " - " + contrasena);
            }
        }
    }
    */

    /*
    ######################################################################
    # 10. [RANDOM] GENERAR CLIENTES ALEATORIOS PARKING
    ######################################################################

    public void generarClientesAleatorios() {
        int cantidad = random.nextInt(10) + 1;

        while (clientesActuales.size() < cantidad) {
            String matricula = generarMatriculaAleatoria();
            boolean repetida = false;

            for (Ticket ticket : clientesActuales) {
                if (ticket.getMatricula().equals(matricula)) {
                    repetida = true;
                    break;
                }
            }

            if (!repetida) {
                int minutos = random.nextInt(360) + 1;
                clientesActuales.add(new Ticket(matricula, minutos, Estado.RECOGIDO));
            }
        }
    }
    */

    /*
    ######################################################################
    # 11. [LISTAS] INSERTAR OBJETOS POR TIPO
    # Patron real de insertarEvento()
    ######################################################################

    public static void insertarEvento(String nombre, LocalDate fecha, double precio, String tipo) {
        Evento nuevoEvento;

        if (tipo.equalsIgnoreCase("festival")) {
            nuevoEvento = new Festival(nombre, fecha, precio);
        } else if (tipo.equalsIgnoreCase("concierto")) {
            nuevoEvento = new Concierto(nombre, fecha, precio);
        } else {

            System.out.println("No existe el tipo de evento.");
            return;
        }

        listaEvento.add(nuevoEvento);
    }
    */

    /*
    ######################################################################
    # 12. [LOGIN] AUTENTICACION
    # Patron real de AppCompraEntradas
    ######################################################################

    public static Usuario autentificarse(Set<Usuario> usuariosRegistrados) {
        while (true) {
            System.out.println("*** BIENVENIDO ***");
            System.out.println("Usuario");
            System.out.print("> ");
            String nombreUsuario = teclado.nextLine();
            System.out.println("Contrasena");
            System.out.print("> ");
            String contrasena = teclado.nextLine();

            for (Usuario usuario : usuariosRegistrados) {
                if (usuario.getNombre_usuario().equals(nombreUsuario)
                        && usuario.getContrasena().equals(contrasena)) {
                    System.out.println("BIENVENIDO!!!");
                    return usuario;
                }
            }

            System.out.println("Credenciales no validas. Intentalo de nuevo...");
        }
    }
    */

    /*
    ######################################################################
    # 13. [ORDENAR] VER LISTA ORDENADA POR FECHA
    # Patron real de TicketMutxa
    ######################################################################

    private static List<Evento> getEventosOrdenados() {
        List<Evento> eventosOrdenados = new ArrayList<>(listaEvento);
        Collections.sort(eventosOrdenados, new Comparator<Evento>() {
            @Override
            public int compare(Evento e1, Evento e2) {
                return e1.getFecha().compareTo(e2.getFecha());
            }
        });
        return eventosOrdenados;
    }
    */

    /*
    ######################################################################
    # 14. [ORDENAR] ORDENAR CON COMPARATOR
    # Patron real de CompararComparator
    ######################################################################

    public int compare(Portatil o1, Portatil o2) {
        int compararRam = o1.getRam().compareTo(o2.getRam());
        if (compararRam != 0) {
            return compararRam;
        }

        int compararPeso = o1.getPeso().compareTo(o2.getPeso());
        if (compararPeso != 0) {
            return compararPeso;
        }

        return o1.getNombre().compareTo(o2.getNombre());
    }
    */

    /*
    ######################################################################
    # 15. [ORDENAR] ORDENAR RAPIDO CON LAMBDA
    # Si el examen no lo prohibe
    ######################################################################

    listaTickets.sort(Comparator.comparing(Ticket::getMinutos));
    listaEventos.sort(Comparator.comparing(Evento::getFecha));
    */

    /*
    ######################################################################
    # 16. [BUSCAR] BUSCAR EN LISTA Y DEVOLVER OBJETO O NULL
    ######################################################################

    public Ticket validarTicket(String matricula) {
        for (Ticket ticket : clientesActuales) {
            if (ticket.getMatricula().equalsIgnoreCase(matricula)) {
                return ticket;
            }
        }
        return null;
    }
    */

    /*
    ######################################################################
    # 17. [BUSCAR] GET POR OPCION DE MENU
    ######################################################################

    public Evento getEvento(int opcion) {
        List<Evento> eventosOrdenados = getEventosOrdenados();

        if (opcion < 1 || opcion > eventosOrdenados.size()) {
            return null;
        }

        return eventosOrdenados.get(opcion - 1);
    }
    */

    /*
    ######################################################################
    # 18. [LISTAS] IMPRIMIR LISTA
    ######################################################################

    public void mostrarClientesActuales() {
        for (Ticket ticket : clientesActuales) {
            System.out.println(ticket);
        }
    }
    */

    /*
    ######################################################################
    # 19. [MAPAS] MAPA / CARRITO
    # Patron real de Usuario.java
    ######################################################################

    private Map<Evento, Integer> mapa = new HashMap<>();

    public void anyadirAlCarrito(Evento evento, int cantidad) {
        int actual = mapa.getOrDefault(evento, 0);
        int nuevaCantidad = actual + cantidad;

        if (cantidad <= 0 || nuevaCantidad > 7) {
            System.out.println("Error: no se pueden comprar mas de 7 entradas por persona.");
            return;
        }

        mapa.put(evento, nuevaCantidad);
    }

    public void setCarrito(Evento evento, int cantidad) {
        if (cantidad < 0 || cantidad > 7) {
            System.out.println("Error: la cantidad del carrito debe estar entre 0 y 7.");
            return;
        }

        if (cantidad == 0) {
            mapa.remove(evento);
            return;
        }

        mapa.put(evento, cantidad);
    }

    public void verCarrito() {
        if (mapa.isEmpty()) {
            System.out.println("El carrito esta vacio.");
            return;
        }

        System.out.println("Carrito actual:");
        for (Map.Entry<Evento, Integer> entrada : mapa.entrySet()) {
            Evento evento = entrada.getKey();
            Integer cantidad = entrada.getValue();
            System.out.println("- " + evento.getNombre() + " | Entradas: " + cantidad);
        }
    }
    */

    /*
    ######################################################################
    # 20. [MAPAS] MAPAS BASICOS
    ######################################################################

    HashMap<Integer, String> mapa = new HashMap<>();
    mapa.put(1, "Marruecos");
    mapa.put(2, "Espana");
    mapa.put(3, "Belgica");
    mapa.put(3, "Francia"); // pisa el valor anterior

    System.out.println(mapa.keySet());
    System.out.println(mapa.values());

    for (Map.Entry<Integer, String> entrada : mapa.entrySet()) {
        System.out.println(entrada.getKey() + ": " + entrada.getValue());
    }
    */

    /*
    ######################################################################
    # 21. [COLAS] COLA VIRTUAL
    # Patron real de AppCompraEntradas
    ######################################################################

    private void simularColaVirtual(Set<Usuario> usuarios, Usuario comprador) {
        Queue<Usuario> cola = new LinkedList<>();

        for (Usuario usuario : usuarios) {
            if (usuario != comprador) {
                cola.offer(usuario);
            }
        }

        cola.offer(comprador);

        int posicion = cola.size();
        while (posicion > 1) {
            System.out.println("Cola virtual: tu posicion actual es " + posicion);
            cola.poll();
            posicion--;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Cola virtual: tu posicion actual es 1. Es tu turno.");
    }
    */

    /*
    ######################################################################
    # 22. [MENU] MENU CON SWITCH
    ######################################################################

    boolean salir = false;
    while (!salir) {
        System.out.println("[1] Anadir");
        System.out.println("[2] Eliminar");
        System.out.println("[3] Pagar");

        int opcion = leerEnteroSeguro("Elige una opcion:");

        switch (opcion) {
            case 1:
                System.out.println("Anadir");
                break;
            case 2:
                System.out.println("Eliminar");
                break;
            case 3:
                System.out.println("Pagar");
                salir = true;
                break;
            default:
                System.out.println("Error: opcion no contemplada.");
        }
    }
    */

    /*
    ######################################################################
    # 23. [VALIDACION] IF DE VALIDACION TIPICO
    ######################################################################

    if (opcion < 1 || opcion > lista.size()) {
        System.out.println("Error");
        return null;
    }
    */

    /*
    ######################################################################
    # 24. [ITERATOR] ITERATOR PARA BORRAR
    ######################################################################

    Iterator<Invitado> it = listaInvitados.iterator();
    while (it.hasNext()) {
        Invitado invitado = it.next();
        if (invitado.getFechaVisita().equals(LocalDate.now())) {
            it.remove();
        }
    }
    */

    /*
    ######################################################################
    # 25. [ITERATOR] LISTITERATOR
    # Patron real de Ejemplo_ListaIt
    ######################################################################

    ArrayList<String> alumnos = new ArrayList<>(Arrays.asList("Juan", "Ismael", "Paula"));
    ListIterator<String> it = alumnos.listIterator();

    while (it.hasNext()) {
        String nombre = it.next();
        if (nombre.equals("Ismael")) {
            it.add("Patri");
        }
    }
    */

    /*
    ######################################################################
    # 26. [HERENCIA] INSTANCEOF
    ######################################################################

    for (Banista b : listaBanistas) {
        if (b instanceof Invitado) {
            System.out.println(b);
        }
    }
    */

    /*
    ######################################################################
    # 27. [FECHAS] FECHA ACTUAL
    ######################################################################

    LocalDate hoy = LocalDate.now();
    */

    /*
    ######################################################################
    # 28. [EXCEPCIONES] EXCEPCION PERSONALIZADA
    ######################################################################

    public class EdadInvalidaException extends Exception {
        public EdadInvalidaException(String mensaje) {
            super(mensaje);
        }
    }
    */

    /*
    ######################################################################
    # 29. [EXCEPCIONES] LANZAR EXCEPCION PERSONALIZADA
    ######################################################################

    if (tipo == TipoUsuario.NINIO && edad > 16) {
        throw new EdadInvalidaException("Un ninio no puede tener mas de 16 anios");
    }
    */

    /*
    ######################################################################
    # 30. [EXCEPCIONES] EXCEPCIONES REALES DE TU CODIGO
    ######################################################################

    public void ingresar(double importe) throws DepositoMaximoException {
        validarImporte(importe);

        if (importe > 3000) {
            throw new DepositoMaximoException("No puedes ingresar mas de 3000");
        }

        saldo += importe;
    }

    public void retirar(double importe) throws SaldoInsuficienteException, LimiteDiarioException {
        validarImporte(importe);

        if (importe > 600) {
            throw new LimiteDiarioException("No puedes retirar mas de 600");
        }

        if (importe > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }

        saldo -= importe;
    }
    */

    /*
    ######################################################################
    # 31. [EXCEPCIONES] VALIDACION DE IMPORTE
    ######################################################################

    private void validarImporte(double importe) {
        if (importe <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que 0.");
        }
    }
    */

    /*
    ######################################################################
    # 32. [ENUM] CAMBIO DE ESTADO
    ######################################################################

    ticket.setEstado(Estado.GENERADO);
    ticket.setEstado(Estado.RECOGIDO);
    ticket.setEstado(Estado.PAGADO);
    */

    /*
    ######################################################################
    # 33. [CALCULO] IMPORTE A PAGAR
    ######################################################################

    double importe = ticket.getMinutos() * parking.getPrecio_minuto();
    System.out.println("Importe a pagar: " + importe);
    */

    /*
    ######################################################################
    # 34. [TOSTRING] TOSTRING
    ######################################################################

    @Override
    public String toString() {
        return "Ticket{" +
                "matricula='" + matricula + '\\'' +
                ", minutos=" + minutos +
                ", estado=" + estado +
                '}';
    }
    */

    /*
    ######################################################################
    # 35. [EQUALS] EQUALS Y HASHCODE
    # util para Set y no repetir
    ######################################################################

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(nombre, evento.nombre) &&
               Objects.equals(fecha, evento.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fecha);
    }
    */

    /*
    ######################################################################
    # 36. [MAIN] MAIN TIPO PARKING
    ######################################################################

    static Parking parking = new Parking("Mutxamel Centro", 1000, 0.025);

    public static void main(String[] args) {
        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();
    }
    */

    /*
    ######################################################################
    # 37. [MAIN] MAIN TIPO TICKETMUTXA
    ######################################################################

    public static void main(String[] args) {
        TicketMutxa.insertarEvento("Paellas", LocalDate.of(2025, 4, 16), 20, "festival");
        TicketMutxa.insertarEvento("Concierto Estopa", LocalDate.of(2025, 4, 21), 40, "concierto");
        TicketMutxa.generarUsuarios(4);

        Usuario comprador = autentificarse(TicketMutxa.getUsuariosRegistrados());
        TicketMutxa.verEventos(comprador);
    }
    */

    /*
    ######################################################################
    # 38. [MAIN] MAIN TIPO PAGO CON METODO ABSTRACTO
    ######################################################################

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Que metodo de pago quieres usar? [Bizum, PayPal, Tarjeta]");
        MetodoPago metodoPago = crearMetodoPago(teclado.nextLine());

        if (metodoPago == null) {
            System.out.println("El metodo de pago no existe");
            return;
        }

        if (!metodoPago.validarDatos(teclado)) {
            return;
        }

        double importe = leerDoubleSeguro("Introduce el importe:");
        metodoPago.procesarPago(importe);
    }
    */

    /*
    ######################################################################
    # 39. [LISTAS] ARRAYLIST BASICO
    ######################################################################

    ArrayList<String> lista = new ArrayList<>();
    lista.add("Uno");
    lista.add("Dos");
    lista.remove("Uno");
    System.out.println(lista.get(0));
    */

    /*
    ######################################################################
    # 40. [SET] SET BASICO
    ######################################################################

    Set<String> conjunto = new LinkedHashSet<>();
    conjunto.add("A");
    conjunto.add("A"); // no se repite
    conjunto.add("B");
    */

    /*
    ######################################################################
    # 41. [TEORIA] QUE RESPONDER EN TEORIA
    ######################################################################

    POLIMORFISMO:
    Animal a = new Perro();
    a.hacerSonido(); // se ejecuta Perro porque el objeto real es Perro

    ENCAPSULACION:
    atributo private + getter + setter validando

    HERENCIA MULTIPLE:
    Java no permite herencia multiple de clases.
    La alternativa es implementar varias interfaces.

    ITERATOR:
    se usa para borrar mientras recorres sin ConcurrentModificationException
    */

    /*
    ######################################################################
    # 42. [VECTORES] VECTORES
    ######################################################################

    int[] vector = {4, 2, 7, 1};
    int suma = 0;

    for (int i = 0; i < vector.length; i++) {
        suma += vector[i];
    }

    int mayor = vector[0];
    for (int i = 1; i < vector.length; i++) {
        if (vector[i] > mayor) {
            mayor = vector[i];
        }
    }
    */

    /*
    ######################################################################
    # 43. [MATRICES] MATRICES
    ######################################################################

    int[][] matriz = {
        {5, 3, 2},
        {1, 4, 6},
        {7, 8, 9}
    };

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.println(matriz[i][j]);
        }
    }

    int suma = 0;
    int columna = 1;
    for (int i = 0; i < matriz.length; i++) {
        suma += matriz[i][columna];
    }
    */

    /*
    ######################################################################
    # 44. [RECURSIVIDAD] RECURSIVIDAD
    ######################################################################

    static int potencia(int base, int exponente) {
        if (exponente == 0) return 1;
        return base * potencia(base, exponente - 1);
    }
    */

    /*
    ######################################################################
    # 45. [TRAZAS] TRAZA DE BUCLES
    ######################################################################

    int suma = 0;
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 2; j++) {
            suma += i * j;
            System.out.println("i: " + i + ", j: " + j + ", suma: " + suma);
        }
    }
    */

    /*
    ######################################################################
    # 46. [CHECKLIST] RECORDATORIO DE EXAMEN PRACTICO
    ######################################################################

    1. Primero crear clases, atributos, enum, interfaz y constructores.
    2. Luego metodos basicos: insertar, mostrar, buscar, validar.
    3. Luego flujo de la app principal.
    4. Controlar null, duplicados, menus y limites.
    5. Imprimir por pantalla para demostrar que funciona.
    */

    /*
    ######################################################################
    # 47. [STACK] STACK / PILA BASICA
    # Sacado de Colecciones
    ######################################################################

    Stack<String> pila = new Stack<>();
    pila.push("a");
    pila.push("e");
    pila.push("i");

    System.out.println(pila.peek()); // ultimo elemento
    System.out.println(pila.size());

    while (!pila.isEmpty()) {
        System.out.println(pila.pop());
    }
    */

    /*
    ######################################################################
    # 48. [STACK] INVERTIR DATOS CON PILA
    ######################################################################

    Stack<String> pila = new Stack<>();
    for (int i = 1; i <= 3; i++) {
        System.out.print("Introduce valor " + i + ": ");
        pila.push(teclado.nextLine());
    }

    System.out.print("Orden inverso: ");
    while (!pila.isEmpty()) {
        System.out.print(pila.pop() + " ");
    }
    */

    /*
    ######################################################################
    # 49. [STACK] PARENTESIS BALANCEADOS
    # Patron real de ParentesisBalanceados
    ######################################################################

    public static boolean esBalanceado(String expresion) {
        ArrayList<Character> abiertos = new ArrayList<>(Arrays.asList('(', '[', '{'));
        ArrayList<Character> cerrados = new ArrayList<>(Arrays.asList(')', ']', '}'));
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (abiertos.contains(c)) {
                pila.push(c);
            } else if (cerrados.contains(c)) {
                if (pila.isEmpty()) {
                    return false;
                }

                int pos = cerrados.indexOf(c);
                if (pila.peek() == abiertos.get(pos)) {
                    pila.pop();
                } else {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }
    */

    /*
    ######################################################################
    # 50. [STACK] EVALUAR EXPRESION POSTFIJA
    # Patron real de EvaluacionOperadores
    ######################################################################

    public static int evaluarPostfija(String expresion) {
        Stack<Integer> pila = new Stack<>();

        for (String token : expresion.split(" ")) {
            if (token.matches("\\\\d+")) {
                pila.push(Integer.parseInt(token));
            } else {
                int b = pila.pop();
                int a = pila.pop();

                switch (token) {
                    case "+": pila.push(a + b); break;
                    case "-": pila.push(a - b); break;
                    case "*": pila.push(a * b); break;
                    case "/": pila.push(a / b); break;
                }
            }
        }

        return pila.pop();
    }
    */

    /*
    ######################################################################
    # 51. [STRINGS] CHARAT + RECORRER STRING
    # Util para partidos, validaciones, formatos
    ######################################################################

    String texto = "ABABSF";
    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        System.out.println(c);
    }
    */

    /*
    ######################################################################
    # 52. [STRINGS] VALIDAR QUE CADENA ACABA EN F
    # Muy util para problemas tipo partido / formato
    ######################################################################

    if (!cadena.endsWith("F")) {
        System.out.println("Formato invalido");
        return;
    }

    if (cadena.substring(0, cadena.length() - 1).contains("F")) {
        System.out.println("Formato invalido");
        return;
    }
    */

    /*
    ######################################################################
    # 53. [STRINGS] SPLIT
    ######################################################################

    String linea = "10 20 30 40";
    String[] partes = linea.split(" ");

    for (int i = 0; i < partes.length; i++) {
        System.out.println(partes[i]);
    }
    */

    /*
    ######################################################################
    # 54. [LISTAS] ARRAYLIST DE OBJETOS
    # Sacado de PartidoTenis y muchos proyectos
    ######################################################################

    private ArrayList<Set> listaSet;

    public Partido(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        listaSet = new ArrayList<>();
    }
    */

    /*
    ######################################################################
    # 55. [MAPAS] HASHMAP TIPO DICCIONARIO
    # Sacado de JuegoDiccionario
    ######################################################################

    HashMap<String, String> diccionario = new HashMap<>();
    diccionario.put("casa", "house");
    diccionario.put("perro", "dog");

    if (diccionario.containsKey("casa")) {
        System.out.println(diccionario.get("casa"));
    }
    */

    /*
    ######################################################################
    # 56. [MAPAS] RECORRER HASHMAP
    ######################################################################

    for (Map.Entry<String, String> entrada : diccionario.entrySet()) {
        System.out.println(entrada.getKey() + " -> " + entrada.getValue());
    }
    */

    /*
    ######################################################################
    # 57. [ABSTRACTA] CLASE ABSTRACTA SENCILLA
    # Sacado de PracticoModeloA
    ######################################################################

    public abstract class PizzaExpress {
        public abstract void obtenerDetalles();
    }
    */

    /*
    ######################################################################
    # 58. [INTERFAZ] IMPLEMENTAR VARIAS INTERFACES
    # Sacado de interfaces/Superman
    ######################################################################

    public class Superman extends Superheroe implements Voladores, Ataques {

        @Override
        public void volar() {
            System.out.println("Sobrevolando la ciudad");
        }

        @Override
        public void ojos_laser() {
            System.out.println("Lanzando laser");
        }

        @Override
        public void hielo() {
            System.out.println("Escupiendo hielo");
        }
    }
    */

    /*
    ######################################################################
    # 59. [INTERFAZ] INTERFAZ MINIMA
    ######################################################################

    public interface Voladores {
        void volar();
    }
    */

    /*
    ######################################################################
    # 60. [SWITCH] SWITCH CON STRING
    ######################################################################

    switch (metodoPago.trim().toLowerCase()) {
        case "bizum":
            return new Bizum("", 0);
        case "paypal":
            return new PayPal(23, "");
        case "tarjeta":
            return new TarjetaCredito("");
        default:
            return null;
    }
    */

    /*
    ######################################################################
    # 61. [HERENCIA] CREAR OBJETO SEGUN TIPO
    # Muy repetido en examenes
    ######################################################################

    if (tipo.equalsIgnoreCase("adulto")) {
        nuevo = new Adulto(numero, nombre, edad, TipoUsuario.ADULTO);
    } else if (tipo.equalsIgnoreCase("ninio")) {
        nuevo = new Ninio(numero, nombre, edad, TipoUsuario.NINIO, telefono);
    } else if (tipo.equalsIgnoreCase("invitado")) {
        nuevo = new Invitado(numero, nombre, edad, TipoUsuario.INVITADO);
    } else {
        System.out.println("Tipo no valido");
        return;
    }
    */

    /*
    ######################################################################
    # 62. [ITERATOR] ELIMINAR DE LISTA CON REMOVEIF
    # usar solo si el examen no prohibe lambdas
    ######################################################################

    listaBanistas.removeIf(b -> b instanceof Invitado);
    */

    /*
    ######################################################################
    # 63. [ITERATOR] ELIMINAR DE LISTA SIN LAMBDAS
    # version segura para examen
    ######################################################################

    Iterator<Banista> it = listaBanistas.iterator();
    while (it.hasNext()) {
        Banista b = it.next();
        if (b instanceof Invitado) {
            it.remove();
        }
    }
    */

    /*
    ######################################################################
    # 64. [VALIDACION] COMPROBAR DUPLICADOS EN LISTA
    ######################################################################

    boolean repetido = false;
    for (Usuario u : listaUsuarios) {
        if (u.getNombre().equals(nombreBuscado)) {
            repetido = true;
            break;
        }
    }
    */

    /*
    ######################################################################
    # 65. [SET] COMPROBAR DUPLICADOS EN SET
    ######################################################################

    Set<String> nombres = new LinkedHashSet<>();
    nombres.add("Ana");
    nombres.add("Ana"); // no entra
    */

    /*
    ######################################################################
    # 66. [RANDOM] FORMULA RANDOM RAPIDA
    ######################################################################

    random.nextInt(10) + 1;   // 1 a 10
    random.nextInt(300) + 1;  // 1 a 300
    random.nextInt(301) + 60; // 60 a 360
    */

    /*
    ######################################################################
    # 67. [LISTAS] FOR EACH
    ######################################################################

    for (Ticket ticket : clientesActuales) {
        System.out.println(ticket);
    }
    */

    /*
    ######################################################################
    # 68. [LISTAS] FOR CLASICO
    ######################################################################

    for (int i = 0; i < lista.size(); i++) {
        System.out.println(lista.get(i));
    }
    */

    /*
    ######################################################################
    # 69. [FECHAS] COMPARAR FECHAS
    ######################################################################

    if (fecha1.equals(fecha2)) {
        System.out.println("Misma fecha");
    }

    if (fecha1.compareTo(fecha2) < 0) {
        System.out.println("fecha1 va antes");
    }
    */

    /*
    ######################################################################
    # 70. [EXCEPCIONES] TRY CATCH SIMPLE
    ######################################################################

    try {
        int numero = Integer.parseInt(texto);
    } catch (NumberFormatException e) {
        System.out.println("Error: numero invalido");
    }
    */

    /*
    ######################################################################
    # 71. [EXCEPCIONES] THROW SIMPLE
    ######################################################################

    if (saldo < 0) {
        throw new IllegalArgumentException("Saldo invalido");
    }
    */

    /*
    ######################################################################
    # 72. [PLANTILLA] PLANTILLA DE CLASE DE EXAMEN
    ######################################################################
    Random rnd = new Random();

    // 4 dígitos: 1000–9999
    int numeros = rnd.nextInt(9000) + 1000;

    // letras válidas en matrículas españolas (sin vocales, sin Ñ, sin Q)
    String letrasValidas = "BCDFGHJKLMNPRSTUVWXYZ";

    // 3 letras aleatorias del conjunto
    String letras = "";
    for (int i = 0; i < 3; i++) {
        int pos = rnd.nextInt(letrasValidas.length());
        letras += letrasValidas.charAt(pos);
    }

       String matricula = numeros + " " + letras;


    public class Ticket {
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

        @Override
        public String toString() {
            return "Ticket{" +
                    "matricula='" + matricula + '\\'' +
                    ", minutos=" + minutos +
                    ", estado=" + estado +
                    '}';
        }
    }
    */

    /*
    ######################################################################
    # 73. [CHECKLIST] CHECKLIST DE COSAS QUE SUELEN PEDIR
    ######################################################################

    [ ] Clase principal App...
    [ ] Clase gestora con listas
    [ ] Clases del dominio
    [ ] Enum de estados o tipos
    [ ] Interfaz si hay acciones comunes
    [ ] Constructor
    [ ] Getters y setters
    [ ] toString
    [ ] Metodo insertar
    [ ] Metodo buscar / validar
    [ ] Metodo mostrar
    [ ] Menu
    [ ] Validacion de errores
    [ ] Pruebas en main
    */
}
