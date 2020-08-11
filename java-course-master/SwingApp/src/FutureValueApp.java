import javax.swing.*;

public class FutureValueApp {
    public static void main(String[] args) {
        JFrame frame = new FutureValueFrame();
        frame.setVisible(true);
    }
}

class FutureValueFrame extends JFrame {
    public FutureValueFrame() {
        setTitle("Future Value Calculator");
        setBounds(267, 200, 267, 200);
        setResizable(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
