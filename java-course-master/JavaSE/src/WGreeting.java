import javax.swing.*;
import java.awt.*;

public class WGreeting extends JFrame {
    private JTextField textField;

    public static void main(String[] args) {
        WGreeting frame = new WGreeting();
        frame.setSize(300, 200);
        frame.createGUI();
//        frame.show();
        frame.setVisible(true);
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        textField = new JTextField("Hello!");
        window.add(textField);
    }
}
