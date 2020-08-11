import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaMethod3 extends JFrame implements ActionListener {
    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        AreaMethod3 frame = new AreaMethod3();
        frame.setSize(400,300);
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
        drawHouse(paper,10,20,70,20);
        drawHouse(paper,10,90,50,50);
    }

    private void drawHouse(Graphics drawingArea,int topRoofX,int topRoofY, int width, int height) {
        drawTriangle(drawingArea,topRoofX,topRoofY,width, height);
        drawingArea.drawRect(topRoofX, topRoofY + height, width, height);
    }

    private void drawTriangle(Graphics drawingArea, int xPlace, int yPlace, int width, int height) {
        drawingArea.drawLine(xPlace, yPlace, xPlace,yPlace + height);
        drawingArea.drawLine(xPlace, yPlace + height, xPlace + width,yPlace + height);
        drawingArea.drawLine(xPlace, yPlace, xPlace + width,yPlace + height);
    }

    private int areaRectangle(int length, int width) {
        return length * width;
    }
}
