package controller;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter implements ActionListener {

    private static final String API_TOKEN = "801799692ab648db9ab594e28f9e2d33";

    private final View view;
    private final AIConfiguration configuration;
    private final AIDataService dataService;

    public Controller(View view) {
        this.view = view;

        configuration = new AIConfiguration(API_TOKEN);
        dataService = new AIDataService(configuration);
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

            getResponse(input);
        }
    }

    private void getResponse(String input) {
        new Thread(() -> {
            try {
                AIRequest request = new AIRequest(input);
                AIResponse response = dataService.request(request);

                if (response.getStatus().getCode() == 200) {
                    view.addBotResponse(response.getResult().getFulfillment().getSpeech());
                } else {
                    view.addText("Admin", response.getStatus().getErrorDetails(), "red");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}
