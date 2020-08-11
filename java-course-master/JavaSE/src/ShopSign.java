import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopSign extends JFrame implements ActionListener {
    private JButton onButton, offButton, openButton, closeButton;
    private JTextField textField;

    private boolean on = false, open = false;

    public static void main(String[] args) {
        ShopSign demo = new ShopSign();
        demo.setSize(250,200);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        onButton = new JButton("On");
        window.add(onButton);
        onButton.addActionListener(this);

        offButton = new JButton("Off");
        window.add(offButton);
        offButton.addActionListener(this);

        textField = new JTextField(4);
        textField.setSize(5,100);
        textField.setFont(new Font(null, Font.BOLD, 60));
        window.add(textField);

        openButton = new JButton("Open");
        window.add(openButton);
        openButton.addActionListener(this);

        closeButton = new JButton("Closed");
        window.add(closeButton);
        closeButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == onButton)
            handleOnButton();
        else if (source == offButton)
            handleOffButton();
        else if (source == openButton)
            handleOpenButton();
        else
            handleClosedButton();
        drawSign();
    }

    private void handleOnButton() {
        on = true;
    }

    private void handleOffButton() {
        on = false;
    }

    private void handleOpenButton() {
        open = true;
    }

    private void handleClosedButton() {
        open = false;
    }

    private void drawSign() {
        if (open)
            textField.setText("Open");
        else
            textField.setText("Closed");
        if (!on)
            textField.setText("");
    }
}
