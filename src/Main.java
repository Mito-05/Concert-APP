import classes.Concert;
import classes.Ticket;
import classes.User;
import exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Setup Concerts
        // Capacity set to 1 to force FullCapacityException later
        Concert c1 = new Concert("DPR Ian", "Seoul", 50.0, 1, new ArrayList<>(), true);

        Concert c2 = new Concert("Michael Jackson", "London", 80.0, 1000, new ArrayList<>(), false);
        Concert c3 = new Concert("Cheese Atlantis", "Seville", 30.0, 200, new ArrayList<>(), true);

        User user1 = new User("Mito", 20, new ArrayList<>(), new HashSet<>(), new HashMap<>());


        // Trigger InactiveConcertException
        try {
            user1.buyTicket(c2, Ticket.EntryType.STANDS);
        } catch (InactiveConcertException e) {
            System.out.println("Friendly Alert: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        // Trigger FullCapacityException
        try {
            user1.buyTicket(c1, Ticket.EntryType.VIP); // This purchase fills the capacity (1/1)
            User user2 = new User("Capi", 25, new ArrayList<>(), new HashSet<>(), new HashMap<>());
            user2.buyTicket(c1, Ticket.EntryType.TRACK); // This one triggers the exception
        } catch (FullCapacityException e) {
            System.out.println("Friendly Alert: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        // Trigger ConcertAlreadyAttendedException
        try {
            user1.buyTicket(c3, Ticket.EntryType.TRACK);
            user1.buyTicket(c3, Ticket.EntryType.TRACK); // Already attended, triggers exception
        } catch (ConcertAlreadyAttendedException e) {
            System.out.println("Friendly Alert: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        // Trigger ZeroEntriesException (within Concert class)
        try {
            c2.calculateAveragePrice(); // c2 has no sold tickets
        } catch (ZeroEntriesException e) {
            System.out.println("Friendly Alert: " + e.getMessage());
        }

        // Trigger ConcertNotAttendedException (within User class)
        try {
            Concert c4 = new Concert("NewJeans", "Tokyo", 100.0, 500, new ArrayList<>(), true);
            user1.rateConcert(c4, 10); // User has not attended c4
        } catch (ConcertNotAttendedException e) {
            System.out.println("Friendly Alert: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        // 6. Trigger IncorrectRatingException (within User class)
        try {
            user1.rateConcert(c3, 11); // Rating higher than 10
        } catch (IncorrectRatingException e) {
            System.out.println("Friendly Alert: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        System.out.println("\n--- All exception tests completed ---");
    }
}