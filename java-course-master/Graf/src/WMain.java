import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class WMain {

    public static final double WIDTH = 400;

    public static final double HEIGHT = 400;

    public static void main(String[] args) {
        new GraphFrame().setVisible(true);
    }

}

class GraphFrame extends JFrame {

    public GraphFrame() {
        super();
        setBounds(200, 200, (int) WMain.WIDTH, (int) WMain.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        final GraphPanel gp = new GraphPanel();

        JMenuBar mb = new JMenuBar();

        JMenu graph = new JMenu("Graphic");

        JMenuItem paint = new JMenuItem("Paint");
        paint.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gp.dieGraph(false);
            }

        });
        graph.add(paint);
        JMenuItem reset = new JMenuItem("Reset");
        reset.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gp.dieGraph(null);
            }

        });

        graph.add(reset);

        JMenuItem Defolt = new JMenuItem("Defoult");
        Defolt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gp.dieGraph(true);


            }

        });
        graph.add(Defolt);

        mb.add(graph);
        add(mb, BorderLayout.NORTH);

        add(gp, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout());
        JButton b = new JButton("Paint");
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gp.dieGraph(false);
            }

        });

        JButton r = new JButton("Reset");
        r.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gp.dieGraph(null);
            }

        });
        buttons.add(b);
        buttons.add(r);
        JButton d = new JButton("Defoult");
        d.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                gp.dieGraph(true);
            }
        });
        buttons.add(d);
        add(buttons, BorderLayout.SOUTH);
    }

}

class GraphPanel extends JPanel {

    private static final double SCALE_X = 20;

    private static final double SCALE_Y = 15;

    private Boolean die = false;

    public GraphPanel() {
        super();
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g2);
        drawAxis(g2);
        if (die == null) {
            drawGrid(g2);
            drawAxis(g2);
            return;
        }
        if (die) {
            drawGraph1(g2);
        } else {
            drawGraph(g2);
        }

    }

    private void drawAxis(Graphics2D g2) {
        Color c = g2.getColor(); // save color
        final int W = getWidth();
        final int H = getHeight();
        g2.setColor(Color.RED);
        g2.drawLine(0, 0, 0, H);
        g2.drawLine(0, 0, 3, 5);
        g2.drawLine(0, 0, -3, 5);
        int y = H / 2;
        g2.drawLine(0, y, W, y);
        g2.drawLine(W, y, W - 5, y - 3);
        g2.drawLine(W, y, W - 5, y + 3);
        g2.setColor(c); // restore color
    }

    public void dieGraph(Boolean die) {
        this.die = die;
        repaint();
    }

    private void drawGrid(Graphics2D g2) {
        int dx, dy;
        dx = dy = 20;
        Color c = g2.getColor(); // save color
        final int W = getWidth();
        final int H = getHeight();
        g2.setColor(Color.GREEN);
        for (int x = 0; x < W; x += dx) {
            g2.drawLine(x, 0, x, H);
        }
        for (int y = 0; y < H; y += dy) {
            g2.drawLine(0, y, W, y);
        }
        g2.setColor(c); // restore color
    }

    private void drawGraph(Graphics2D g2) {
        double lastX = 0;
        double lastY1 = getHeight() / 2;
        double lastY2 = getHeight() / 2;
        double lastY3 = getHeight() / 2;
        for (int x = 1; x <= WMain.WIDTH; x++) {
            double y1 = getHeight() / 2 - func1(x / SCALE_X) * SCALE_Y;
//            double y2 = getHeight() / 2 - func2(x / SCALE_X) * SCALE_Y;
//            double y3 = getHeight() / 2 - func3(x / SCALE_X) * SCALE_Y;
            g2.drawLine((int) lastX, (int) lastY1, (int) x, (int) y1);
//            g2.drawLine((int) lastX, (int) lastY2, (int) x, (int) y2);
//            g2.drawLine((int) lastX, (int) lastY3, (int) x, (int) y3);
            lastX = x;
            lastY1 = y1;
//            lastY2 = y2;
//            lastY3 = y3;
        }
    }

    private double func1(double x) {
        return 10 * Math.exp(-x / 4) * Math.cos(3 * x);
    }

    private double func2(double x) {
        return 10 * Math.exp(-x / 4);
    }

    private double func3(double x) {
        return -10 * Math.exp(-x / 4);
    }

    private void drawGraph1(Graphics2D g2) {
        double lastX = 0;
        double lastY1 = getHeight() / 2;
        double lastY2 = getHeight() / 2;
        double lastY3 = getHeight() / 2;
        for (int x = 1; x <= WMain.WIDTH; x++) {
            double y1 = getHeight() / 2 - func11(x / SCALE_X) * SCALE_Y;
            double y2 = getHeight() / 2 - func22(x / SCALE_X) * SCALE_Y;
            double y3 = getHeight() / 2 - func33(x / SCALE_X) * SCALE_Y;
            g2.drawLine((int) lastX, (int) lastY1, (int) x, (int) y1);
            g2.drawLine((int) lastX, (int) lastY2, (int) x, (int) y2);
            g2.drawLine((int) lastX, (int) lastY3, (int) x, (int) y3);
            lastX = x;
            lastY1 = y1;
            lastY2 = y2;
            lastY3 = y3;
        }
    }

    private double func11(double x) {
        return 10 * Math.exp(-x / 4) * Math.cos(5 * x);
    }

    private double func22(double x) {
        return 10 * Math.exp(-x / 4);
    }

    private double func33(double x) {
        return -10 * Math.exp(-x / 4);
    }

}