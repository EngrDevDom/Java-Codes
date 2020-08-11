import javax.swing.*;

public class DisplayedNumbers extends JFrame {
    public static void main(String[] args) {
        int n, m;
        n = 10;
        m = 5;
        while ((n > 0) || (m > 0)) {
            n --;
            m --;
        }
        JOptionPane.showMessageDialog(null, "n = " + Integer.toString(n) +
                " m = " + Integer.toString(m));
        System.exit(0);
    }
}
