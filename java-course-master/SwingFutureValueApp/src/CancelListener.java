import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (newProduct != null)
            newProduct = null;
        productPanel.setDisplayMode();
        productPanel.showProduct(selectorPanel.getCurrentProduct());
        buttonPanel.setAddEditMode(false);
        selectorPanel.productComboBox.requestFocusInWindow();
    }
}
