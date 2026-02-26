package classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void getTotalPrice() {
        // 1. Set up the concert context
        Concert concert = new Concert("Maluma", "Lima", 60.0, 1, new ArrayList<>(), true);

        // 2. Test STANDS ticket
        Ticket standsTicket = new Ticket(concert, Ticket.EntryType.STANDS);
        assertEquals(60.0, standsTicket.getTotalPrice(), "The price for STANDS should match the base price.");

        // 3. Test VIP ticket
        Ticket vipTicket = new Ticket(concert, Ticket.EntryType.VIP);
        assertEquals(72.0, vipTicket.getTotalPrice(), "The price for VIP should include the extra charge (1.2x).");
    }
}