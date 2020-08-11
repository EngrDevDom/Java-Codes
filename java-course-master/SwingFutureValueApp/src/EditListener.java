import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        buttonPanel.setAddEditMode(true);
        productPanel.setEditMode();
    }
}
