import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Dice extends JFrame implements ChangeListener {
    private JSlider slider1, slider2;
    private JTextField totalTextField, commentTextField;

    public static void main(String[] args) {
        Dice demo = new Dice();
        demo.setSize(200,150);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        slider1 = new JSlider(1,6,3);
        slider1.addChangeListener(this);
        window.add(slider1);

        slider2 = new JSlider(1,6,3);
        slider2.addChangeListener(this);
        window.add(slider2);

        totalTextField = new JTextField(10);
        window.add(totalTextField);
        commentTextField = new JTextField(10);
        window.add(commentTextField);
    }

    public void stateChanged(ChangeEvent event) {
        int die1, die2, total;
        die1 = slider1.getValue();
        die2 = slider2.getValue();
        total = die1 + die2;
        totalTextField.setText("Total is " + total);
        if (total == 6)
            commentTextField.setText("You have won");
        else
            commentTextField.setText("You have lost");
    }
}
