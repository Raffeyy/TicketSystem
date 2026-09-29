package com.ticketsystem.backend.repository;

import com.ticketsystem.backend.entity.User;
import org.example.ticketsystem.Repository.LoginRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

// static imports erlauben es uns, die Test-Befehle direkt aufzurufen
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserRepositoryTest {

    @Test
    void testEmailExistsFunctionality() {
        // -------------------------------------------------------------
        // 1. ARRANGE (Wir bereiten die Situation im Kopf vor)
        // -------------------------------------------------------------
        // Wir erstellen eine Attrappe (einen Mock) des UserRepositorys.
        // Das ist wie ein Statist beim Film, der genau das tut, was wir sagen.
        LoginRepository fakeRepository = mock(LoginRepository.class);

        // Jetzt programmieren wir den Statisten:
        // WENN (when) jemand nach "test@mail.com" fragt,
        // DANN soll er mit TRUE antworten (thenReturn).
        when(fakeRepository.existsByEmail("test@mail.com")).thenReturn(true);


        // -------------------------------------------------------------
        // 2. ACT (Wir führen die Aktion aus, die wir prüfen wollen)
        // -------------------------------------------------------------
        // Wir rufen die Methode an unserem Statisten auf und speichern das Ergebnis
        boolean ergebnisWennExistiert = fakeRepository.existsByEmail("test@mail.com");
        boolean ergebnisWennFrei = fakeRepository.existsByEmail("freie-mail@web.de");


        // -------------------------------------------------------------
        // 3. ASSERT (Wir überprüfen, ob die Welt mathematisch noch stimmt)
        // -------------------------------------------------------------
        // assertTrue erwartet, dass in der Variable 'true' steht. Wenn ja: Test GRÜN.
        assertTrue(ergebnisWennExistiert);

        // assertFalse erwartet, dass in der Variable 'false' steht.
        // Da wir für "freie-mail@web.de" keine Regel programmiert haben,
        // antwortet der Mock-Statist standardmäßig mit false. Also: Test GRÜN.
        assertFalse(ergebnisWennFrei);
    }
}
