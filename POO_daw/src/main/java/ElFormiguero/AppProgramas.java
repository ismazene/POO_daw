package ElFormiguero;

public class AppProgramas {
    public static void main(String[] args) {
        Cadena antena3 = new Cadena("Antena 3");
        System.out.println("Cadena creada: " + antena3.getNombre());

        Programa elHormiguero = new Programa("El Hormiguero", antena3, "Patri");
        System.out.println("Programa creado: " + elHormiguero.getNombre());

        elHormiguero.insertarEmpleado(new Empleado("Pablo Motos", "presentador", null));
        elHormiguero.insertarEmpleado(new Empleado("Jose", "colaborador", null));
        elHormiguero.insertarEmpleado(new Empleado("Pedro", "técnico", null));
        elHormiguero.insertarEmpleado(new Empleado("Sandra", "directora", null));

        elHormiguero.insertarInvitado("Aitana", "cantante", 1);
        elHormiguero.insertarInvitado("Pablo Alborán", "cantante", 1);
        elHormiguero.insertarInvitado("Aitana", "cantante", 2);
        elHormiguero.insertarInvitado("Anuel AA", "pintor", 3);

        String invitadoBuscado = "Aitana";
        int veces = elHormiguero.vecesInvitado(invitadoBuscado);
        System.out.println("El " + invitadoBuscado + " ha ido " + veces + " veces al programa.");

        invitadoBuscado = "Ismael";
        System.out.println("Buscando si " + invitadoBuscado + " ha acudido:");
        elHormiguero.buscarInvitado(invitadoBuscado);

    }
}
