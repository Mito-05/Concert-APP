# 🎫 Concert Management System

A simple yet robust **Java-based** system designed to manage concert ticket sales, user attendance tracking, and financial revenue statistics.

## 🚀 Features

* **Concert Management:** Track attendance capacity, base pricing, and active/inactive status.
* **Ticket Categories:** Automatic surcharge calculation based on ticket type:
    * **Stands:** Base price.
    * **Track:** +10% surcharge.
    * **VIP:** +20% surcharge.
* **User Validations:**
    * Duplicate purchase restriction for the same event (one ticket per user).
    * Real-time seat availability checks.
* **Rating System:** Users can rate concerts they have attended on a scale from 0 to 10.
* **Advanced Statistics:** Automatic calculation of total revenue, average ticket prices, and identification of the most/least sold concerts.

## 🛠️ Technologies Used

* **Language:** Java 17+
* **IDE:** IntelliJ IDEA
* **Data Structures:** * `ArrayList`: Dynamic lists for sold tickets and purchases.
    * `HashSet`: Ensuring unique concert attendance records.
    * `HashMap`: Mapping specific ratings to concert objects.

## 📂 Project Structure

* `Main.java`: The entry point that simulates business logic and displays statistics.
* `Concert.java`: Entity managing event data and revenue calculations.
* `Ticket.java`: Defines access types and calculates final prices.
* `User.java`: Represents the customer with purchase and validation logic.

## 📊 Sample Output

When running the `Main` class, the system processes the data and returns a detailed summary:

```text
---------- CONCERT STATISTICS ----------
Total tickets sold: 6
Tickets by type -> TRACK: 2 | STANDS: 3 | VIP: 1
Total revenue: 430.00 €
Overall average ticket price: 71.67 €
----------------------------------------
Top Selling Concert: Michael Jackson (3 tickets)
Lowest Selling Concert: Cheese Atlantis (1 tickets)
--- Thank you for using our Concerts ---