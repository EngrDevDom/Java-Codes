import javax.swing.*;
import java.awt.*;

public class Ball  {
    private JPanel panel;
    private int x = 7, xChange = 7;
    private int y = 0, yChange = 2;
    private int diameter = 10;
    private int width = 100, height = 100;

    public Ball(JPanel thePanel) {
        panel = thePanel;
    }

    public void animate() {
        delete();
        move();
        bounce();
        draw();
    }

    private void move() {
        x += xChange;
        y += yChange;
    }

    private void bounce() {
        if (x <= 0 || x >= width)
            xChange = -xChange;
        if (y <= 0 || y >= height)
            yChange = -yChange;
    }

    private void draw() {
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.red);
        paper.drawOval(x,y,diameter,diameter);
    }

    private void delete() {
        Graphics paper = panel.getGraphics();
        paper.setColor(Color.white);
        paper.fillOval(x,y,diameter,diameter);
    }
}
