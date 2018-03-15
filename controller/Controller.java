package controller;

import model.Bot;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter implements ActionListener {

    private final View view;
    private final Bot bot;

    public Controller(View view) {
        this.view = view;
        bot = new Bot();
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
            view.addUserInput(view.getUserInput());
            view.addBotResponse(bot.getResponseFor(view.getUserInput()));
            view.clearUserInput();

            if (bot.wasFinal()) view.disableInput();
        }
    }
}
