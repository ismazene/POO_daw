package ElFormiguero;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class InvitadoTest {

    @Test
    void creaInvitadoConFecha() {
        System.setIn(new ByteArrayInputStream("2026\n1\n1\n".getBytes()));
        Invitado invitado = new Invitado("Aitana", "cantante", 1);

        assertNotNull(invitado.getFechaVisita());
    }
}
