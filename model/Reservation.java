package model;

public class Reservation {

    private String name;
    private int quantity;
    private String timestamp;

    public Reservation(String name, int quantity, String timestamp) {
        this.name = name;
        this.quantity = quantity;
        this.timestamp = timestamp;
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
        return String.format("Table for %d guest(s), at %s", quantity, timestamp);
    }
}
