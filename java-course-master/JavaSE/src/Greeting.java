import javax.swing.*;
import java.awt.*;

public class Greeting extends JFrame {
    private JTextField textField;

    public static void main(String[] args) {
        Greeting frame = new Greeting();
        frame.setSize(300, 200);
        frame.ccreateGUI();
        frame.show();
    }

    private void ccreateGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        textField = new JTextField("Hello");
        window.add(textField);
    }
}
