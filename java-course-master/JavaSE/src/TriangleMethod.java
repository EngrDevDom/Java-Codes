import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriangleMethod extends JFrame implements ActionListener {
    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        TriangleMethod frame = new TriangleMethod();
        frame.setSize(350,300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,200));
        panel.setBackground(Color.white);
        window.add(panel);

        button = new JButton("Press Me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        drawLogo(paper, 10,20);
        drawLogo(paper, 100, 100);
        drawTriangle(paper, 100,10,40,40);
        drawTriangle(paper, 10,100,20,60);
    }

    private void drawLogo(Graphics drawingArea, int xPos, int yPot) {
        drawingArea.drawRect(xPos, yPot,60,60);
        drawingArea.drawRect(xPos, yPot,40,40);
        drawingArea.drawRect(xPos, yPot,20,20);
    }

    private void drawTriangle(Graphics drawingArea, int xPlace, int yPlace, int width, int height) {
        drawingArea.drawLine(xPlace, yPlace, xPlace, yPlace + height);
        drawingArea.drawLine(xPlace, yPlace + height, xPlace + width, yPlace + height);
        drawingArea.drawLine(xPlace, yPlace, xPlace + width, yPlace + height);
    }
}
