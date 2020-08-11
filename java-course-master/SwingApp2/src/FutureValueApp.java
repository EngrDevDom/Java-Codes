import javax.swing.*;
import java.awt.*;

public class FutureValueApp {
    public static void main(String[] args) {
        JFrame frame = new FutureValueFrame();
        frame.setVisible(true);
    }
}
class FutureValueFrame extends JFrame {
    public FutureValueFrame() {
        setTitle("Future Value Calculator");
//        setBounds(267, 200, 267, 200);
        setSize(267, 200);
        centerWindow(this);
//        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void centerWindow (Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth()) / 2, (d.height-w.getHeight()) / 2);
    }

}