package model;

public class Reservation {

    private String name;
    private int quantity;
    private String timestamp;

    public Reservation(String name, int quantity, String timestamp) {
        this.name = name;
        this.quantity = quantity;
        this.timestamp = timestamp.substring(0, timestamp.length() - 5);
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("Table for %d guest%c, at %s", quantity, quantity == 1 ? '\0' : 's',timestamp);
    }
}
