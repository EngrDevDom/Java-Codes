import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StarProgram extends JFrame implements ActionListener {
    private JButton button;
    private JPanel panel;
    private Random random;

    public static void main(String[] args) {
        StarProgram demo = new StarProgram();
        demo.setSize(400,400);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        random = new Random();

        button = new JButton("Go");
        window.add(button);
        button.addActionListener(this);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(380,330));
        panel.setBackground(Color.white);
        window.add(panel);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.black);
        paper.fillRect(0,0,380,330);
        paper.setColor(Color.white);
        for (int count = 0; count < 2000; count ++) {
            int x, y, radius;
            x = random.nextInt(380);
            y = random.nextInt(330);
            radius = 5;
            paper.fillOval(x,y,radius,radius);
        }
    }
}
