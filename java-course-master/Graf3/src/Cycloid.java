import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Cycloid {

    public static void main(String[] args) {
        new GraphFrame().setVisible(true);
    }

}

class GraphFrame extends JFrame {

    static final double FRAME_WIDTH = 400d;

    static final double FRAME_HEIGHT = 400d;

    public GraphFrame() {
        super();
        setBounds(200, 200, (int) FRAME_WIDTH, (int) FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new GraphPanel());
    }

}

class GraphPanel extends JPanel {

    private static final double SCALE = 15d;

    private static final double STRETCH = 3d;

    private static final double A = 20d;

    public GraphPanel() {
        super();
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawGraph(g2);
    }

    private void drawGraph(Graphics2D g2) {
        double lastX = 0;
        double lastY = GraphFrame.FRAME_HEIGHT / 2;
        for (int t = 1; t <= GraphFrame.FRAME_WIDTH; t++) {
            double x = getX(t / SCALE);
            double y = GraphFrame.FRAME_HEIGHT / 2 - getY(t / SCALE) * STRETCH;
            g2.drawLine((int) lastX, (int) lastY, (int) x, (int) y);
            lastX = x;
            lastY = y;
        }
    }

    private double getX(double  t) {
        return A * (t - Math.sin(t));
    }

    private double getY(double  t) {
        return A * (1d - Math.cos(t));
    }

}