import javax.swing.*;
import java.awt.*;

public class PaymentFrame extends JFrame {
    public PaymentFrame() {
        setTitle("Payment Application");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new PaymentPanel();
        this.add(panel);
        this.pack();
        centerWindow(this);
    }
    private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
}
