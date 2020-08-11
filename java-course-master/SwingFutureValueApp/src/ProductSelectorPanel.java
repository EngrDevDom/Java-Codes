import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductSelectorPanel extends JPanel implements ActionListener {
    public JComboBox productComboBox;
    private JLabel productLabel;

    boolean filling = false;

    public ProductSelectorPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        productLabel = new JLabel("Select Product:");
        add(productLabel);

        productComboBox = new JComboBox();
        fillComboBox(products);
        productComboBox.addActionListener(this);
        add(productComboBox);
    }
    public void actionPerformed(ActionEvent e) {
        if (!filling) {
            Product p = (Product)productComboBox.getSelectedItem();
            productPanel.showProduct(p);
        }
    }
    public void fillComboBox(ArrayList<Product> a) {
        filling = true;
        productComboBox.removeAllItems();
        for (Prduct p : a)
            productComboBox.addItem(p);
        filling = false;
    }
    public void selectProduct(Product p) {
        productComboBox.setSelectedItem(p);
    }
    public Product getCurrentProduct() {
        return (Product) productComboBox.getSelectedItem();
    }
}
