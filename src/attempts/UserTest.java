package attempts;

import classes.Concert;
import classes.Ticket;
import classes.User;
import exceptions.ConcertNotAttendedException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void rateConcert() throws Exception {
        Concert concert = new Concert("Daft Punk", "Paris", 120.0, 80000, new ArrayList<>(), true);
        User user = new User();

        user.buyTicket(concert, Ticket.EntryType.STANDS);
        user.rateConcert(concert, 9);

        assertEquals(9, user.getRatings().get(concert), "The rating should be 9.");

        User user2 = new User();
        assertThrows(ConcertNotAttendedException.class, () -> {
            user2.rateConcert(concert, 8);
        }, "Should throw ConcertNotAttendedException because user2 didn't buy a ticket.");
    }
}