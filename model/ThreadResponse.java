package model;

import controller.Controller;

public class ThreadResponse extends Thread {
    private Controller controller;

    public ThreadResponse(Controller controlador) {
        this.controller = controlador;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controller.updateBotChat();
    }
}
