import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WSomeShapes extends JFrame implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        WSomeShapes frame = new WSomeShapes();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        paper.drawRect(30, 30, 80, 40);
        paper.drawOval(130, 30, 50, 50);
        paper.drawOval(230, 30, 30, 50);
        paper.setColor(Color.lightGray);
        paper.fillRect(30, 100, 50, 50);
        paper.fillOval(130, 100, 50, 50);
        paper.fillOval(230, 100, 30, 50);
    }
}
