package attempts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import classes.Concert;
import classes.Ticket;
import exceptions.ZeroEntriesException;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ConcertTest {

    @Test
    void getTotalPrice() throws ZeroEntriesException {
        // Set up a concert with tickets
        Concert concert = new Concert("Guns and Roses", "Miami", 110.0, 40000, new ArrayList<>(), true);

        // We create tickets
        Ticket t1 = new Ticket(concert, Ticket.EntryType.TRACK);
        Ticket t2 = new Ticket(concert, Ticket.EntryType.STANDS);

        // Add tickets to the concert list
        concert.getSoldTickets().add(t1);
        concert.getSoldTickets().add(t2);

        // Test the successful calculation
        // Note: The expected value (115.5) depends on your Ticket.getTotalPrice() logic
        Assertions.assertEquals(115.5, concert.calculateAveragePrice());

        // Set up an empty concert to trigger the exception
        Concert emptyConcert = new Concert("Bad Bunny", "Oslo", 24.0, 560000, new ArrayList<>(), true);

        // 4. Test that the exception is thrown
        assertThrows(ZeroEntriesException.class, () -> emptyConcert.calculateAveragePrice());
    }
}