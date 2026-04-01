package Recuperacion_1.Piscina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AppPiscina {
    static List<Banista> listaBanistas = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws EdadNinioException {
        listaBanistas.add(new Adulto(1, "patricia", 20, TipoUsuario.ADULTO));
        listaBanistas.add(new Adulto(2, "pablo", 30, TipoUsuario.ADULTO));
        listaBanistas.add(new Ninio(3, "pepe", 12, TipoUsuario.NINIO, "34565432"));
        listaBanistas.add(new Ninio(4, "carla", 8, TipoUsuario.NINIO, "8569512"));
        listaBanistas.add(new Invitado(5, "Fran", 40, TipoUsuario.INVITADO));
        listaBanistas.add(new Invitado(6, "Marta", 12, TipoUsuario.INVITADO));

        mostrarBanistas();
        altaUsuario();
        mostrarInvitados();
        eliminarInvitados();
        mostrarBanistas();
    }

    public static void altaUsuario() throws EdadNinioException {
        System.out.println("1. Adulto");
        System.out.println("2. Ninio");
        System.out.println("3. Invitado");
        System.out.print("Elige tipo: ");
        int opcion = Integer.parseInt(teclado.nextLine());

        int numeroNuevo = listaBanistas.get(listaBanistas.size() - 1).getNumero() + 1;

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(teclado.nextLine());

        Banista banista;

        switch (opcion) {
            case 1:
                banista = new Adulto(numeroNuevo, nombre, edad, TipoUsuario.ADULTO);
                break;
            case 2:
                if (edad > 16) {
                    throw new EdadNinioException("Un ninio no puede tener mas de 16 anios.");
                }
                System.out.print("Telefono tutor: ");
                String telefono = teclado.nextLine();
                banista = new Ninio(numeroNuevo, nombre, edad, TipoUsuario.NINIO, telefono);
                break;
            case 3:
                banista = new Invitado(numeroNuevo, nombre, edad, TipoUsuario.INVITADO);
                break;
            default:
                System.out.println("Tipo no valido.");
                return;
        }

        listaBanistas.add(banista);
        cobrar(banista);
    }

    public static void cobrar(Banista banista) {
        banista.pagar();
    }

    public static void mostrarInvitados() {
        System.out.println("Invitados de hoy:");
        for (Banista banista : listaBanistas) {
            if (banista instanceof Invitado) {
                Invitado invitado = (Invitado) banista;
                if (invitado.getFechaVisita().equals(LocalDate.now())) {
                    System.out.println(invitado);
                }
            }
        }
    }

    public static void eliminarInvitados() {
        Iterator<Banista> it = listaBanistas.iterator();
        while (it.hasNext()) {
            Banista b = it.next();
            if (b instanceof Invitado) {
                Invitado invitado = (Invitado) b;
                if (invitado.getFechaVisita().equals(LocalDate.now())) {
                    it.remove();
                }
            }
        }
    }

    public static void mostrarBanistas() {
        System.out.println("Lista actual de banistas:");
        for (Banista banista : listaBanistas) {
            System.out.println(banista);
        }
    }
}
