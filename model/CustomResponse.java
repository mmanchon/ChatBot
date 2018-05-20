package model;

import java.util.Random;

public enum CustomResponse {

    RESERVATION_SUCCESS(
            "Reservation successfully made. Anything else I can help you with?",
            "Done! Thanks for booking with us.",
            "Reservation noted down. Would you like to do something else?"
    ),

    RESERVATION_FAIL(
            "Sorry, I'm afraid a reservation at that time already exists.",
            "Sorry, a table has already been booked for that moment.",
            "I must inform you there are no available tables at that time"
    ),

    HAS_RESERVATIONS(
            "Here are the booked tables I found for your name:",
            "You've reserved these tables:",
            "These are the reservations you've made:"
    ),

    NO_RESERVATIONS(
            "I'm sorry, you don't have any reservations with us.",
            "Sorry, it seems like there aren't any bookings with that name.",
            "Sorry, we don't have any records for with your name."
    ),

    CANCEL_SUCCESS(
            "Your reservation has been cancelled.",
            "I've successfully cancelled your booking.",
            "Done! Anything else I can help you with?"
    ),

    CANCEL_FAIL(
            "Seems like there's no reservation made like the one you've described.",
            "That reservation doesn't exists.",
            "I can't cancel it, it's not in our books!"
    );

    private static final Random random = new Random();
    private final String[] responses;

    CustomResponse(String... responses) {
        this.responses = responses;
    }

    public String random() {
        return responses[random.nextInt(responses.length)];
    }
}
