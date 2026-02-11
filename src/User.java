import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private ArrayList<Ticket> purchasedTickets;
    private HashSet<Concert> attendedConcerts;
    private HashMap<Concert, Integer> ratings;

    // Full Constructor
    public User(String name, int age, ArrayList<Ticket> purchasedTickets, HashSet<Concert> attendedConcerts, HashMap<Concert, Integer> ratings) {
        this.name = name;
        this.age = age;
        this.purchasedTickets = purchasedTickets;
        this.attendedConcerts = attendedConcerts;
        this.ratings = ratings;
    }

    // No-arg Constructor
    public User() {
        this.purchasedTickets = new ArrayList<>();
        this.attendedConcerts = new HashSet<>();
        this.ratings = new HashMap<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(ArrayList<Ticket> purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public HashSet<Concert> getAttendedConcerts() {
        return attendedConcerts;
    }

    public void setAttendedConcerts(HashSet<Concert> attendedConcerts) {
        this.attendedConcerts = attendedConcerts;
    }

    public HashMap<Concert, Integer> getRatings() {
        return ratings;
    }

    public void setRatings(HashMap<Concert, Integer> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    public void buyTicket(Concert concert, Ticket.EntryType type) {
        if (!concert.isActive()) {
            System.out.println("Error: The concert is not active.");
            return;
        }

        if (attendedConcerts.contains(concert)) {
            System.out.println("Error: You have already attended this concert.");
            return;
        }

        if (!concert.ticketsAvailable()) {
            System.out.println("Error: No tickets available for this concert.");
            return;
        }

        // Create the new ticket
        Ticket newTicket = new Ticket(concert, type);

        // Update concert and user records
        concert.getSoldTickets().add(newTicket);
        this.purchasedTickets.add(newTicket);
        this.attendedConcerts.add(concert);

        System.out.println("Success: Ticket purchased for " + concert.getArtist());
    }


    public void rateConcert(Concert concert, int rating) {
        if (!attendedConcerts.contains(concert)) {
            System.out.println("Error: You cannot rate a concert you haven't attended.");
            return;
        }

        if (rating < 0 || rating > 10) {
            System.out.println("Error: Rating must be between 0 and 10.");
            return;
        }

        ratings.put(concert, rating);
        System.out.println("Success: Rating updated for " + concert.getArtist());
    }

    @Override
    public String toString() {
        return name + " (has attended " + attendedConcerts.size() + " concerts)";
    }
}
