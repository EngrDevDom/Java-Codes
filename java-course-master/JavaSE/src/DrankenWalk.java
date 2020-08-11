import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DrankenWalk extends JFrame implements ActionListener {
    private JButton button;
    private JPanel panel;
    private Random random;
    private int paperWidth = 100, paperHeight = 100;
    private JTextField textField;

    public static void main(String[] args) {
        DrankenWalk demo = new DrankenWalk();
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
        panel.setPreferredSize(new Dimension(380,300));
        panel.setBackground(Color.white);
        window.add(panel);

        textField = new JTextField(15);
        window.add(textField);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        int x, y, xStep, yStep, xNew, yNew, steps;
        paper.setColor(Color.white);
        paper.fillRect(0,0, paperWidth, paperHeight);
        x = paperWidth / 2;
        y = paperHeight / 2;
        paper.setColor(Color.white);
        for (steps = 0; x < paperWidth && x > 0 && y < paperHeight && y > 0; steps ++) {
            xStep = random.nextInt(100) - 50;
            yStep = random.nextInt(100) - 50;

            xNew = x + xStep;
            yNew = y + yStep;
            paper.setColor(Color.black);
            paper.drawLine(x, y, xNew, yNew);

            x = xNew;
            y = yNew;
        }
        textField.setText("It took " + steps + " steps");
    }
}
