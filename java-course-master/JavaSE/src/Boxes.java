import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Boxes extends JFrame implements ChangeListener {
    private JSlider slider;
    private JPanel panel;

    public static void main(String[] args) {
        Boxes demo = new Boxes();
        demo.setSize(250,150);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        slider = new JSlider(0,10,1);
        window.add(slider);
        slider.addChangeListener(this);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(180,50));
        panel.setBackground(Color.white);
        window.add(panel);
    }

    public void stateChanged(ChangeEvent e) {
        Graphics paper = panel.getGraphics();
        int x, numberOfBoxes, counter;
        numberOfBoxes = slider.getValue();
        paper.setColor(Color.white);
        paper.fillRect(0,0,180,50);
        x = 10;
        counter = 1;
        paper.setColor(Color.black);
        while (counter <= numberOfBoxes) {
            paper.drawRect(x,10,10,10);
            x += 15;
            counter ++;
        }
    }
}
