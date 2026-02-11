import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 1. Setup Concerts
        Concert c1 = new Concert("DPR Ian", "Seoul", 50.0, 500, new ArrayList<>(), true);
        Concert c2 = new Concert("Michael Jackson", "London", 80.0, 1000, new ArrayList<>(), true);
        Concert c3 = new Concert("Cheese Atlantis", "Seville", 30.0, 200, new ArrayList<>(), true);

        List<Concert> allConcerts = Arrays.asList(c1, c2, c3);

        // 2. Setup Users (Usamos varios para que las validaciones permitan las compras)
        User user1 = new User("Mito", 20, new ArrayList<>(), new HashSet<>(), new HashMap<>());
        User user2 = new User("Capi", 25, new ArrayList<>(), new HashSet<>(), new HashMap<>());
        User user3 = new User("TitaN", 20, new ArrayList<>(), new HashSet<>(), new HashMap<>());

        // Compras para DPR Ian (Total: 2)
        user1.buyTicket(c1, Ticket.EntryType.VIP);
        user2.buyTicket(c1, Ticket.EntryType.TRACK);

        // Compras para Michael Jackson (Total: 3 - El más vendido)
        user1.buyTicket(c2, Ticket.EntryType.STANDS);
        user2.buyTicket(c2, Ticket.EntryType.STANDS);
        user3.buyTicket(c2, Ticket.EntryType.VIP);

        // Compras para Cheese Atlantis (Total: 1 - El menos vendido)
        user1.buyTicket(c3, Ticket.EntryType.TRACK);

        // 3. Calculate Statistics
        int totalTicketsSold = 0;
        int trackCount = 0;
        int standsCount = 0;
        int vipCount = 0;
        double totalRevenue = 0;

        // Inicializamos con el primer concierto de la lista
        Concert mostSold = allConcerts.get(0);
        Concert leastSold = allConcerts.get(0);

        for (Concert c : allConcerts) {
            int soldCount = c.getSoldTickets().size();
            totalTicketsSold += soldCount;
            totalRevenue += c.calculateRevenue();

            // Conteo por tipo usando la lista de entradas de cada concierto
            for (Ticket t : c.getSoldTickets()) {
                switch (t.getType()) {
                    case TRACK -> trackCount++;
                    case STANDS -> standsCount++;
                    case VIP -> vipCount++;
                }
            }

            // Lógica para Max y Min
            if (soldCount > mostSold.getSoldTickets().size()) {
                mostSold = c;
            }
            if (soldCount < leastSold.getSoldTickets().size()) {
                leastSold = c;
            }
        }

        double overallAveragePrice = totalTicketsSold > 0 ? totalRevenue / totalTicketsSold : 0;

        // 4. Print Results
        System.out.println("\n---------- CONCERT STATISTICS ----------");
        System.out.println("Total tickets sold: " + totalTicketsSold);
        System.out.println("Tickets by type -> TRACK: " + trackCount + " | STANDS: " + standsCount + " | VIP: " + vipCount);
        System.out.println("Total revenue: " + String.format("%.2f", totalRevenue) + " €");
        System.out.println("Overall average ticket price: " + String.format("%.2f", overallAveragePrice) + " €");

        System.out.println("----------------------------------------");
        System.out.println("Top Selling Concert: " + mostSold.getArtist() + " (" + mostSold.getSoldTickets().size() + " tickets)");
        System.out.println("Lowest Selling Concert: " + leastSold.getArtist() + " (" + leastSold.getSoldTickets().size() + " tickets)");
        System.out.println("--- Thank you for using our Concerts ---");
    }
}