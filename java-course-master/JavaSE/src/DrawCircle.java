import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawCircle extends JFrame implements ActionListener {
    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        DrawCircle frame = new DrawCircle();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

//        add panel
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,200));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        paper.drawOval(0,0,100,100);
        paper.drawLine(120,20,220,20);
        paper.drawLine(170,20,170,120);
    }
}
