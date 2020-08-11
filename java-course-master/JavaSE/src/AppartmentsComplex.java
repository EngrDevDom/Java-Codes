import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class AppartmentsComplex extends JFrame implements ChangeListener {
    private JSlider slider1, slider2;
//    private JTextField totalTextField, commentTextField;
    private JPanel panel;
    static final int min = 0;
    static final int max = 10;
    static final int intr = 1;


    public static void main(String[] args) {
        AppartmentsComplex demo = new AppartmentsComplex();
        demo.setSize(380,380);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        slider1 = new JSlider(min, max, intr);
        window.add(slider1);
        slider1.addChangeListener(this);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 250));
        panel.setBackground(Color.white);
        window.add(panel);

        slider2 = new JSlider(JSlider.VERTICAL, min, max, intr);
        window.add(slider2);
        slider2.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Graphics paper = panel.getGraphics();
        int x, y, nBox1, nBox2, counter;
        nBox1 = slider1.getValue();
        nBox2 = slider2.getValue();
        paper.setColor(Color.white);
        paper.fillRect(0,0,180,180);

        int floors, apartments;
        y = 10;
        paper.setColor(Color.white);
        paper.fillRect(0, 0,200,200);

        apartments = slider1.getValue();
        floors = slider2.getValue();
        for (int floor = 0; floor <= floors; floor ++) {
            x = 10;
            for (int count = 0; count <= apartments; count ++) {
                paper.setColor(Color.black);
                paper.drawRect(x, y, 10, 5);
                x += 15;
            }
            y += 15;
        }
    }


}
