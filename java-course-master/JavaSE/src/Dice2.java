import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Dice2 extends JFrame {
    private JTextField textField;

    public static void main(String[] args) {
        Dice2 frame = new Dice2();
        frame.setSize(300,200);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        textField = new JTextField();
        window.add(textField);

        int num1, num2, count;
        Random random = new Random();

        count = 0;
        num1 = random.nextInt(10) + 1;
        do {
            num2 = random.nextInt(10) + 1;
            count ++;
        }
        while (num1 != num2);

        textField.setText("the numbers are " + num1 + " and " + num2 + " count " + count);
    }
}
