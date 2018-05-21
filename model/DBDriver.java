package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBDriver {

    private Connection connection;

    private static final String ADD_RESERVATION = "INSERT INTO Reserva(name, quantity, date) VALUES(?, ?, ?)";
    private static final String CANCEL_RESERVATION = "DELETE FROM Reserva WHERE name = ? AND date = ?";
    private static final String VIEW_RESERVATIONS = "SELECT name, quantity, date FROM Reserva WHERE name = ?";

    public DBDriver() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatbot?user=sbc&password=sbc&useSSL=false&serverTimezone=UTC");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addReservation(String name, String date, String time, int quantity) {
        try {
            PreparedStatement stmt = connection.prepareStatement(ADD_RESERVATION);
            String finalDate = date + " " + time;

            stmt.setString(1, name);
            stmt.setInt(2, quantity);
            stmt.setString(3, finalDate);

            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean cancelReservation(String name, String date, String time) {
        try {
            PreparedStatement stmt = connection.prepareStatement(CANCEL_RESERVATION);

            stmt.setString(1, name);
            stmt.setString(2, date + " " + time);

            return stmt.executeUpdate() == 1;
        } catch (SQLException ex) {
            return false;
        }
    }

    public List<Reservation> viewReservations(String name) {
        try {
            PreparedStatement stmt = connection.prepareStatement(VIEW_RESERVATIONS);
            stmt.setString(1, name);

            ResultSet set = stmt.executeQuery();
            List<Reservation> out = new ArrayList<>();
            while (set.next()) {
                out.add(new Reservation(set.getString(1), set.getInt(2), set.getString(3)));
            }

            return out;
        } catch (SQLException ex) {
            return null;
        }
    }
}
