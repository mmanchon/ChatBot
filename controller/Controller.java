package controller;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;
import model.CustomResponse;
import model.DBDriver;
import model.Reservation;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Controller extends KeyAdapter implements ActionListener {

    private static final String API_TOKEN = "8d67283b3dc7414f8b1ad75889fc8f86";

    private static final String OK_RESERVATION = "OK_RESERVATION";
    private static final String OK_VIEW = "OK_VIEW";
    private static final String OK_CANCEL = "OK_CANCEL";

    private final View view;
    private final AIDataService service;
    private final DBDriver db;

    public Controller(View view) {
        this.view = view;

        AIConfiguration configuration = new AIConfiguration(API_TOKEN);
        service = new AIDataService(configuration);
        db = new DBDriver();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            view.pressSend();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!view.getUserInput().isEmpty()) {
            String input = view.getUserInput();
            view.addUserInput(input);
            view.clearUserInput();
            view.setButtonEnabled(false);

            getResponse(input);
        }
    }

    private void getResponse(String input) {
        new Thread(() -> {
            try {
                AIRequest request = new AIRequest(input);
                AIResponse response = service.request(request);

                if (response.getStatus().getCode() == 200) {
                    handleResponse(response.getResult());
                } else {
                    view.addText("Admin", response.getStatus().getErrorDetails(), "orange");
                }
            } catch (Exception ex) {
                view.addText("Exception", ex.getMessage(), "red");
            }
            view.setButtonEnabled(true);
        }).start();
    }

    private void handleResponse(Result response) {
        String date = response.getStringParameter("date");
        String time = response.getStringParameter("time");
        int quantity = response.getIntParameter("quantity");
        String name = response.getStringParameter("name");

        String speech = response.getFulfillment().getSpeech();
        switch (speech) {
            case OK_RESERVATION:
                if (db.addReservation(name, date, time, quantity)) {
                    view.addBotResponse(CustomResponse.RESERVATION_SUCCESS.random());
                } else {
                    view.addBotResponse(CustomResponse.RESERVATION_FAIL.random());
                }
                break;

            case OK_VIEW:
                List<Reservation> reservations = db.viewReservations(name);
                if (reservations == null || reservations.isEmpty()) {
                    view.addBotResponse(CustomResponse.NO_RESERVATIONS.random());
                } else {
                    view.addBotResponse(CustomResponse.HAS_RESERVATIONS.random());
                    for (Reservation r : reservations) {
                        view.addTabbedText(r.toString());
                    }
                }
                break;

            case OK_CANCEL:
                if (db.cancelReservation(name, date, time)) {
                    view.addBotResponse(CustomResponse.CANCEL_SUCCESS.random());
                } else {
                    view.addBotResponse(CustomResponse.CANCEL_FAIL.random());
                }
                break;

            default:
                view.addBotResponse(speech);
                break;
        }
    }
}
