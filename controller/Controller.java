package controller;

import model.Bot;
import model.ThreadResponse;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter implements ActionListener {

    private final View view;
    private final Bot bot;
    private final ThreadResponse timer;
    private String userInput;


    public Controller(View view) {
        this.view = view;
        bot = new Bot();
        this.timer = new ThreadResponse(this);
        timer.start();

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
            this.userInput = view.getUserInput();
            view.addUserInput(userInput);
            view.clearUserInput();
            timer.setRunning(true);
        }
    }

    public void updateBotChat(){
        view.addBotResponse(bot.getResponseFor(userInput));
        bot.changeContext();
        if (bot.wasFinal()) view.disableInput();
        timer.setRunning(false);

    }
}
