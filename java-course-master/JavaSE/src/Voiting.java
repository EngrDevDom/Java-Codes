import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Voiting extends JFrame implements ActionListener {
    private JLabel greetingLabel;
    private JTextField ageField;
    private JButton button;
    private JTextField decisionField;
    private JTextField commentaryField;
    private JTextField signOffField;

    public static void main(String[] args) {
        Voiting demo = new Voiting();
        demo.setSize(125,200);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        greetingLabel = new JLabel("Enter your age");
        window.add(greetingLabel);

        ageField = new JTextField(5);
        window.add(ageField);

        button = new JButton("Check");
        window.add(button);
        button.addActionListener(this);

        decisionField = new JTextField(10);
        window.add(decisionField);

        commentaryField = new JTextField(10);
        window.add(commentaryField);

        signOffField = new JTextField(10);
        window.add(signOffField);
    }

    public void actionPerformed(ActionEvent event) {
        int age;

        age = Integer.parseInt(ageField.getText());
        if (age > 17) {
            decisionField.setText("You may vote");
            commentaryField.setText("Congratulations");
        }
        else {
            decisionField.setText("You may not vote");
            commentaryField.setText("Sorry");
        }
        signOffField.setText("Best Wishes");
    }
}
