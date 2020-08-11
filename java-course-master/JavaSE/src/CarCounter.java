import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarCounter extends JFrame implements ActionListener {
    private int carCount = 0;
    private JButton button;

    public static void main(String[] args) {
        CarCounter frame = new CarCounter();
        frame.setSize(300,200);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("Car Entering");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        carCount ++;
        JOptionPane.showMessageDialog(null, "Cars: " + carCount);
    }
}
