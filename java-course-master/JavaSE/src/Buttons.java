import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JFrame implements ActionListener {
    private JButton button1, button2;
    private JTextField textField;

    public static void main(String[] args) {
        Buttons demo = new Buttons();
        demo.setSize(100,100);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button1 = new JButton("1");
        window.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("2");
        window.add(button2);
        button2.addActionListener(this);

        textField = new JTextField(6);
        window.add(textField);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == button1)
            textField.setText("Button 1");
        else
            textField.setText("Button 2");
    }
}
