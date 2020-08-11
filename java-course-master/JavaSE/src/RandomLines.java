import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomLines extends JFrame implements ActionListener {
    private Random randomPositions = new Random();
    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        RandomLines frame = new RandomLines();
        frame.setSize(150,200);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100,100));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press Me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int xEnd, yEnd;
        Graphics paper = panel.getGraphics();

        paper.setColor(Color.white);
        paper.fillRect(0,0,100,100);
        paper.setColor(Color.black);

        xEnd = randomPositions.nextInt(100);
        yEnd = randomPositions.nextInt(100);
        paper.drawLine(0,0,xEnd,yEnd);
    }
}
