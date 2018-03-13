import controller.Controller;
import view.View;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            Controller controller = new Controller(view);
            view.registerController(controller, controller);
            view.setVisible(true);
        });
    }
}
