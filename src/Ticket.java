import java.util.Objects;

public class Ticket {
    // Enum for the different types of tickets
    public enum EntryType { TRACK, STANDS, VIP }

    private Concert concert;
    private EntryType type;

    // Full Constructor
    public Ticket(Concert concert, EntryType type) {
        this.concert = concert;
        this.type = type;
    }

    // No-arg Constructor
    public Ticket() {
    }

    // Getters and Setters
    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(concert, ticket.concert) && type == ticket.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(concert, type);
    }


    public double getTotalPrice() {
        if (concert == null || type == null) return 0.0;

        double basePrice = concert.getBasePrice();

        switch (type) {
            case TRACK:
                return basePrice * 1.10;
            case VIP:
                return basePrice * 1.20;
            case STANDS:
            default:
                return basePrice;
        }
    }

    // toString method as requested
    @Override
    public String toString() {
        return "Ticket for " + getTotalPrice() + " €";
    }
}