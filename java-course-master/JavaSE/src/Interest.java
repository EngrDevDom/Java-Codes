import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interest extends JFrame implements ActionListener {
    private JLabel initialLabel;
    private JTextField initialField;
    private JLabel interestLabel;
    private JTextField interestField;
    private JButton button;
    private JTextArea textArea;

    private int year = 1;
    private double oldAmount;

    public static void main(String[] args) {
        Interest frame = new Interest();
        frame.setSize(600,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        initialLabel = new JLabel("Enter initial amount");
        window.add(initialLabel);

        initialField = new JTextField(3);
        window.add(initialField);

        initialLabel = new JLabel("Enter interest rate");
        window.add(interestLabel);

        initialField = new JTextField(3);
        window.add(interestField);

        button = new JButton("another year");
        window.add(button);
        button.addActionListener(this);

        textArea = new JTextArea(10,35);
        window.add(textArea);

        JScrollPane scrollPane = new JScrollPane(textArea);
        window.add(scrollPane);
    }

    public void actionPerformed(ActionEvent event) {
        oneYear();
    }

    private void oneYear() {
        String newLine = "\n";
        double rate, newAmount;
        int dollars, cents;

        if (year == 1)
            oldAmount = Double.parseDouble(initialField.getText());

        rate = Double.parseDouble(initialField.getText());

        newAmount = oldAmount + (oldAmount * rate / 100);

        dollars = (int)newAmount;
        cents = (int)Math.round(100 * (newAmount - dollars));
        textArea.append("After " + Integer.toString(year) + " years the money has become "
                + Integer.toString(dollars) + " dollars and "
                + Integer.toString(cents) + " cents" + newLine);

        oldAmount = newAmount;
        year ++;
    }
}
