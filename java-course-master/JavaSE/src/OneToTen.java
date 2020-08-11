import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OneToTen extends JFrame implements ActionListener {
    private JButton button;
    private JTextField textField;

    public static void main(String[] args) {
        OneToTen demo = new OneToTen();
        demo.setSize(200,120);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("Go");
        window.add(button);
        button.addActionListener(this);

        textField = new JTextField(15);
        window.add(textField);
    }

    public void actionPerformed(ActionEvent event) {
        int number;
        String oneToTem = "";
        number = 1;
        while (number <= 10) {
            oneToTem += Integer.toString(number) + " ";
            number ++;
        }
        textField.setText(oneToTem);
    }
}
