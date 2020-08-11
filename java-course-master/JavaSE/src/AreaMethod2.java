import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaMethod2 extends JFrame implements ActionListener {
    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        AreaMethod2 frame = new AreaMethod2();
        frame.setSize(400,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,200));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press Me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int a;
        a = areaRectangle(10,20);
        JOptionPane.showMessageDialog(null,"Area is: " + a);
    }

    private int areaRectangle(int length, int width) {
        return length * width;
    }
}
