import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Product p = productPanel.getProduct();
        productDAO.deleteProduct(p);
        products.remove(p);
        selectorPanel.fillComboBox(products);
        selectorPanel.selectProduct(products.get(0));
        productPanel.showProduct(products.get(0));
        selectorPanel.productComboBox.requestFocusInWindow();
    }
}
