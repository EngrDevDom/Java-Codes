import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DrawExample extends JFrame implements ActionListener {
    private JButton button;
    private JPanel panel;
    private Random random;

    public static void main(String[] args) {
        DrawExample frame = new DrawExample();
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

        button = new JButton("Press Me");
        window.add(button);
        button.addActionListener(this);

        random = new Random();
    }
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
//        paper.drawLine(0, 0, 2, 2);
        paper.setColor(Color.black);
//        paper.drawOval(0,0, 20, 20);
//        paper.setColor(Color.white);
//        for (int count = 0; count < 20; count ++) {

        int x, y, radius, numberOfBars, counter;
        numberOfBars = 5;
        x = 10;
        counter = 0;
        while (counter <= numberOfBars) {
//            paper.drawLine(x,10,x,100);
            x = random.nextInt(200);
            y = random.nextInt(200);
            radius = random.nextInt(10);
            paper.fillOval(x,y,radius,radius);
            counter ++;
        }
    }
}
