import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DollarsDialogs extends JFrame implements ActionListener {
    private JButton button;

    public static void main(String[] args) {
        DollarsDialogs frame = new DollarsDialogs();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("Press Me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int totalCents;
        int dollars;
        int centsRemaining;
        String totalCentsString;

        totalCentsString = JOptionPane.showInputDialog("Enter your amount, in cents");
        totalCents = Integer.parseInt(totalCentsString);
        dollars = totalCents / 100;
        centsRemaining = totalCents % 100;
        JOptionPane.showMessageDialog(null, totalCentsString + " cents breaks down into:\n" +
                dollars + " dollars\n" + centsRemaining + " cents.");
    }
}
