import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        newProduct = new Product();
        productPanel.clearFields();
        buttonPanel.setAddEditMode(true);
        productPanel.setAddMode();
    }
}
