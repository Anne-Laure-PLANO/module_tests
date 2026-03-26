import horloge.MockHorloge;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;


public class DateTest {

    @Test
    void testMessage_semaineMatin_afficherBonjour() {
        LocalDateTime fakeDate = LocalDateTime.of(2026, 3, 25, 9, 0);
        Welcome welcome = new Welcome(new MockHorloge(fakeDate));
        String message = welcome.getMessage();
        assertEquals("Bonjour", message);

    }

    @Test
    void testMessage_semaineApresMidi_afficherBonApresMidi() {
        LocalDateTime fakeDate = LocalDateTime.of(2026, 3, 25, 17, 0);
        Welcome welcome = new Welcome(new MockHorloge(fakeDate));
        String message = welcome.getMessage();
        assertEquals("Bon après-midi", message);

    }

    @Test
    void testMessage_semaineSoir_afficherBonsoir() {
        LocalDateTime fakeDate = LocalDateTime.of(2026, 3, 25, 20, 0);
        Welcome welcome = new Welcome(new MockHorloge(fakeDate));
        String message = welcome.getMessage();
        assertEquals("Bonsoir", message);

    }

    @Test
    void testMessage_weekend_afficherBonWeekend() {
        LocalDateTime fakeDate = LocalDateTime.of(2026, 3, 28, 17, 0);
        Welcome welcome = new Welcome(new MockHorloge(fakeDate));
        String message = welcome.getMessage();
        assertEquals("Bon week-end !", message);

    }
}
