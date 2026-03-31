package Recuperacion_1.TicketMutxa;
import java.util.Set;

public interface Acciones {
    void pagar();
    boolean autentificarse(Set<Usuario> usuariosRegistrados);

}
