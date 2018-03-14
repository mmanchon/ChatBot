package controller;

import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter implements ActionListener {

    private final View view;

    public Controller(View view) {
        this.view = view;
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
            view.clearUserInput();
            view.addBotResponse("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
    }
}
