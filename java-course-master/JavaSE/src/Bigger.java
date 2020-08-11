import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class Bigger extends JFrame implements ChangeListener {
    private JSlider redSlider;
    private JPanel panel;
    private JSlider blueSlider;
    private JTextField textField;

    public static void main(String[] args) {
        Bigger demo = new Bigger();
        demo.setSize(300,300);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        redSlider = new JSlider(JSlider.VERTICAL);
        redSlider.addChangeListener(this);
        window.add(redSlider);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200,150));
        panel.setBackground(Color.white);
        window.add(panel);

        blueSlider = new JSlider(JSlider.VERTICAL);
        blueSlider.addChangeListener(this);
        window.add(blueSlider);

        textField = new JTextField(10);
        window.add(textField);
    }

    public void stateChanged(ChangeEvent e) {
        Graphics paper = panel.getGraphics();

        int redValue, blueValue;
        redValue = redSlider.getValue();
        blueValue = blueSlider.getValue();

        paper.setColor(Color.white);
        paper.fillRect(0,0,200,150);
        paper.setColor(Color.RED);
        paper.fillOval(10,10,redValue,redValue);
        paper.setColor(Color.blue);
        paper.fillOval(100,10,blueValue,blueValue);

        if (redValue > blueValue)
            textField.setText("Red is bigger");
        else
            textField.setText("Blue is bigger");

    }
}
