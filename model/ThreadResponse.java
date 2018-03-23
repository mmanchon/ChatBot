package model;

import controller.Controller;

public class ThreadResponse extends Thread {
    private Controller controller;
    private boolean running;

    public ThreadResponse(Controller controlador) {
        this.controller = controlador;
        running = false;
    }

    public void run() {

        while(true) {
            while (running) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                controller.updateBotChat();

            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean status) {
        running = status;
    }


}
