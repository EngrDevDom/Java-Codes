import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Graph extends JFrame implements ChangeListener {
    int a, b, c, d;

    private JSlider aSlider, bSlider, cSlider, dSlider;
    private JTextField aText, bText, cText, dText;
    private JPanel panel;
    private int height = 200, width = 200;

    public static void main(String[] args) {
        Graph frame = new Graph();
        frame.setSize(320,350);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        aSlider = new JSlider(-5, 5);
        aSlider.addChangeListener(this);
        window.add(aSlider);

        aText = new JTextField(4);
        window.add(aText);

        bSlider = new JSlider(-5, 5);
        bSlider.addChangeListener(this);
        window.add(bSlider);

        bText = new JTextField(4);
        window.add(bText);

        cSlider = new JSlider(-5, 5);
        cSlider.addChangeListener(this);
        window.add(cSlider);

        cText = new JTextField(4);
        window.add(cText);

        dSlider = new JSlider(-5, 5);
        dSlider.addChangeListener(this);
        window.add(dSlider);

        dText = new JTextField(4);
        window.add(dText);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(Color.lightGray);
        window.add(panel);
    }

    public void stateChanged(ChangeEvent e) {
        a = aSlider.getValue();
        b = bSlider.getValue();
        c = cSlider.getValue();
        d = dSlider.getValue();

        aText.setText("a = " + Integer.toString(a));
        bText.setText("b = " + Integer.toString(b));
        cText.setText("c = " + Integer.toString(c));
        dText.setText("d = " + Integer.toString(d));
        draw();
    }

    private void draw() {
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.white);
        paper.fillRect(0,0,width,height);
        double x, y, nextX, nextY;
        int xPixel, yPixel, nextXPixel, nextYPixel;
        paper.setColor(Color.black);
        for (xPixel = 0; xPixel <= width; xPixel ++) {
            x = scaleX(xPixel);
            y = theFunction(x);
            yPixel = scaleY(y);
            nextXPixel = xPixel + 1;
            nextX = scaleX(nextXPixel);
            nextY = theFunction(nextX);
            nextYPixel = scaleY(nextY);
            paper.drawLine(xPixel, yPixel, nextXPixel, nextYPixel);
        }
    }

    private double theFunction(double x) {
        return a * x * x * x + b * x * x + c * x + d;
    }

    private double scaleX(int xPixel) {
        double xStart = -5, xEnd = 5;
        double xScale = width / (xEnd - xStart);
        return (xPixel - (width / 2)) / xScale;
    }

    private int scaleY(double y) {
        double yStart = -5, yEnd = 5;
        int pixelCoord;
        double yScale = height / (yEnd - yStart);
        pixelCoord = (int)(-y * yScale) + (int)(height / 2);
        return pixelCoord;
    }
}
