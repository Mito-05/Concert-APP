import java.util.ArrayList;
import java.util.Objects;

public class Concert {
    private String artist;
    private String city;
    private double basePrice;
    private int maxCapacity;
    private ArrayList<Ticket> soldTickets;
    private boolean active;

    // Full Constructor
    public Concert(String artist, String city, double basePrice, int maxCapacity, ArrayList<Ticket> soldTickets, boolean active) {
        this.artist = artist;
        this.city = city;
        this.basePrice = basePrice;
        this.maxCapacity = maxCapacity;
        this.soldTickets = soldTickets;
        this.active = active;
    }

    // No-arg Constructor
    public Concert() {
        this.soldTickets = new ArrayList<>();
    }

    // Getters and Setters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ArrayList<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(ArrayList<Ticket> soldTickets) {
        this.soldTickets = soldTickets;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // equals and hashCode based on artist and city
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(artist, concert.artist) && Objects.equals(city, concert.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, city);
    }


    public double calculateRevenue() {
        double totalRevenue = 0;
        for (Ticket ticket : soldTickets) {
            totalRevenue += ticket.getTotalPrice();
        }
        return totalRevenue;
    }


    public double calculateAveragePrice() {
        if (soldTickets.isEmpty()) {
            return 0.0;
        }
        return calculateRevenue() / soldTickets.size();
    }


    public boolean ticketsAvailable() {
        return soldTickets.size() < maxCapacity;
    }

    // toString as requested: "Concert by <artist> in <city>"
    @Override
    public String toString() {
        return "Concert by " + artist + " in " + city;
    }
}
