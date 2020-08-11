import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomNumbers extends JFrame {
    private JTextField textField;

    public static void main(String[] args) {
        RandomNumbers frame = new RandomNumbers();
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

        int num, sum;
        String oneToTen = "";
        num = 0;
        Random random = new Random();

        while (num < 10) {
            num = random.nextInt(10) + 1;
            oneToTen += Integer.toString(num) + " ";
            num ++;
        }
        textField.setText(oneToTen);
    }
}
