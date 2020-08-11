import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FutureValueApp {
    public static void main(String[] args) {
        JFrame frame = new FutureValueFrame();
        frame.setVisible(true);
    }
}
class FutureValueFrame extends JFrame {
    public FutureValueFrame() {
        setTitle("Future Value Calculator");
        setSize(267, 200);
        centerWindow(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new FutureValuePanel();
        this.add(panel);
    }
    private void centerWindow (Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth()) / 2, (d.height-w.getHeight()) / 2);
    }
}
class FutureValuePanel extends JPanel implements ActionListener {
    private JButton calculateButton;
    private JButton exitButton;

    public FutureValuePanel() {
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        this.add(calculateButton);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        this.add(exitButton);
    }
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == exitButton)
            System.exit(0);
        else if (source == calculateButton)
            calculateButton.setText("Clicked!");
    }
}
