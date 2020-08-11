import javax.swing.*;
import java.awt.*;

public class ProductButtonPanel extends JPanel {
    public JButton addButton, editButton, deleteButton, acceptButton, cancelButton, exitButton;

    public ProductButtonPanel() {
        JPanel maintPanel = new JPanel();
        maintPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        addButton = new JButton("Add");
        addButton.addActionListener(new AddListener());
        maintPanel.add(addButton);

        editButton = new JButton("Edit");
        editButton.addActionListener(new EditListener());
        maintPanel.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteListener());
        maintPanel.add(deleteButton);

        acceptButton = new JButton("Accept");
        acceptButton.setEnabled(false);
        acceptButton.addActionListener(new AcceptListener());
        maintPanel.add(acceptButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new CancelListener());
        maintPanel.add(cancelButton);

        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());
        exitPanel.add(exitButton);

        setLayout(new BorderLayout());
        add(maintPanel, BorderLayout.CENTER);
        add(exitPanel, BorderLayout.SOUTH);
    }
    public void setAddEditMode(boolean e) {
        addButton.setEnabled(!e);
        editButton.setEnabled(!e);
        deleteButton.setEnabled(!e);
        acceptButton.setEnabled(e);
        cancelButton.setEnabled(e);
    }
}
