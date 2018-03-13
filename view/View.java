package view;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends JFrame {

    private final JButton btnSend;
    private final JEditorPane txtChat;
    private final JTextField txtInput;
    private final HTMLEditorKit editorKit;
    private final HTMLDocument document;

    public View() {
        setTitle("Chatbot");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 298));
        setLocationRelativeTo(null);

        final JPanel content = (JPanel) getContentPane();
        content.setBorder(BorderFactory.createEmptyBorder(10, 10,10,10));
        ((BorderLayout) content.getLayout()).setVgap(5);

        txtChat = new JEditorPane("text/html", "");
        txtChat.setEditable(false);
        txtChat.setFont(new Font("Calibri", 0, 12));
        editorKit = (HTMLEditorKit) txtChat.getEditorKit();
        document = (HTMLDocument) txtChat.getDocument();

        final JScrollPane scrollPane = new JScrollPane(txtChat);
        content.add(scrollPane, BorderLayout.CENTER);

        final JPanel southPanel = new JPanel(new BorderLayout());
        btnSend = new JButton("Send");
        southPanel.add(btnSend, BorderLayout.EAST);

        txtInput = new JTextField();
        southPanel.add(txtInput, BorderLayout.CENTER);

        content.add(southPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                txtInput.requestFocus();
            }
        });
    }

    public void pressSend() {
        btnSend.doClick();
    }

    public String getUserInput() {
        return txtInput.getText();
    }

    public void clearUserInput() {
        txtInput.setText("");
    }

    public boolean addUserInput(String content) {
        return addText("User", content, "blue");
    }

    public boolean addBotResponse(String content) {
        return addText("Bot", content, "red");
    }

    private boolean addText(String user, String content, String cssColor) {
        String text = String.format("<p style='font-family: Calibri; margin: 0 3 0 3'><b style='color: %s'>%s: </b>%s</p>",
                cssColor, user, content);

        try {
            editorKit.insertHTML(document, document.getLength(), text,0, 0, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void registerController(ActionListener al, KeyListener kl) {
        btnSend.addActionListener(al);
        txtInput.addKeyListener(kl);
    }
}
