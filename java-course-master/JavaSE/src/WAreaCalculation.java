import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WAreaCalculation extends JFrame implements ActionListener {
    private JButton button;

    public static void main(String[] args) {
        WAreaCalculation frame = new WAreaCalculation();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int area;
        int length;
        int width;
        length = 20;
        width = 10;
        area = length * width;
        JOptionPane.showMessageDialog(null, "AreaCalculation is: " + area);
    }
}

