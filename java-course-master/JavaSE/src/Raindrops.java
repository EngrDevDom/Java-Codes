import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Raindrops extends JFrame implements ActionListener, ChangeListener {
    private JPanel panel;
    private Random random;
    private javax.swing.Timer timer;
    private JSlider slider;
    private JTextField gapField;
    private JLabel gapLabel;

    public static void main(String[] args) {
        Raindrops frame = new Raindrops();
        frame.setSize(250, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        random = new Random();

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200,200));
        panel.setBackground(Color.white);
        window.add(panel);

        gapLabel = new JLabel("Time Gap: ");
        window.add(gapLabel);
        gapField = new JTextField(10);
        window.add(gapField);

        slider = new JSlider(JSlider.HORIZONTAL,200,2000,1000);
        window.add(slider);
        slider.addChangeListener(this);
        gapField.setText(Integer.toString(slider.getValue()));
        timer = new javax.swing.Timer(1000,this);
        timer.start();
    }

    public void actionPerformed(ActionEvent event) {
        int x, y, size;
        Graphics paper = panel.getGraphics();
        x = random.nextInt(200);
        y = random.nextInt(200);
        size = random.nextInt(20);
        paper.fillOval(x,y,size,size);
    }

    public void stateChanged(ChangeEvent e) {
        int timeGap = slider.getValue();
        gapField.setText(Integer.toString(timeGap));
        timer.setDelay(timeGap);
    }
}
