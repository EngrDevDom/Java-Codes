import javax.swing.*;
import java.awt.*;

public class ProductDisplayPanel extends JPanel {
    public JTextField codeTextField, descriptionTextField, priceTextField;
    private JLabel codeLabel, descriptionLabel, priceLabel;

    public ProductDisplayPanel() {
        setLayout(new GridBagLayout());

        codeLabel = new JLabel("Product Code:");
        add(codeLabel, getConstraints(0,0,1,1, GridBagConstraints.EAST));

        codeTextField = new JTextField(10);
        codeTextField.setEnabled(false);
        codeTextField.setFocusable(false);
        codeTextField.addFocusListener(new AutoSelect());
        add(codeTextField, getConstrains(1,0,1,1, GridBagConstraints.WEST));

        descriptionLabel = new JLabel(("Description:"));
        add(descriptionLabel, getConstraints(0,1,1,1, GridBagConstraints.EAST));

        descriptionTextField = new JTextField(30);
        descriptionTextField.setEnabled(false);
        descriptionTextField.setFocusable(false);
        descriptionTextField.addFocusListener(new AutoSelect());
        add(descriptionTextField, getConstraints(1,1,1,1, GridBagConstraints.WEST));

        priceLabel = new JLabel("Unit Price:");
        add(priceLabel, getConstraints(0,2,1,1, GridBagConstraints.EAST));

        priceTextField = new JTextField(10);
        priceTextField.setEnabled(false);
        priceTextField.setFocusable(false);
        priceTextField.addFocusListener(new AutoSelect());
        priceTextField.addKeyListener(new NumFilter());
        add(priceTextField, getConstraints(1,2,1,1, GridBagConstraints.WEST));
    }
    public void showProduct(Product p) {
        codeTextField.setText("");
        descriptionTextField.setText("");
        priceTextField.setText("");
    }
    public Product getProduct() {
        Product p = new Product();
        p.setCode(codeTextField.getText());
        p.setDescription(descriptionTextField.getText());
        p.setPrice(Double.parseDouble(priceTextField.getText()));
        return p;
    }
    public void setAddMode() {
        codeTextField.setEditable(true);
        codeTextField.setFocusable(true);
        codeTextField.requestFocusInWindow();
        descriptionTextField.setEditable(true);
        descriptionTextField.setFocusable(true);
        priceTextField.setEditable(true);
        priceTextField.setFocusable(true);
    }
    public void setEditMode() {
        descriptionTextField.setEditable(true);
        descriptionTextField.setFocusable(true);
        descriptionTextField.requestFocusInWindow();
        priceTextField.setEditable(true);
        priceTextField.setFocusable(true);
    }
    public void setDisplayMode() {
        codeTextField.setEditable(false);
        codeTextField.setFocusable(false);
        descriptionTextField.setEditable(false);
        descriptionTextField.setFocusable(false);
        priceTextField.setEditable(false);
        priceTextField.setFocusable(false);
    }
}
