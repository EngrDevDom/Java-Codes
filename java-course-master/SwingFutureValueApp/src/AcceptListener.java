import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcceptListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if (isValidData()) {
            if (newProduct != null) {
                newProduct = productPanel.getProduct();
                productDAO.addProduct(newProduct);
                products.add(newProduct);
                selectorPanel.fillComboBox(products);
                selectorPanel.selectProduct(newProduct);
                newProduct = null;
            }
            else {
                Product p = selectorPanel.getCurrentProduct();
                Product newProduct = productPanel.getProduct();
                p.setDescription(newProduct.getDescription());
                p.setPrice(newProduct.getPrice());
                productDAO.updateProduct(p);
                selectorPanel.fillComboBox(products);
                selectorPanel.selectProduct(p);
                productPanel.showProduct(selectorPanel.getCurrentProduct());
            }
            productPanel.setDisplayMode();
            buttonPanel.setAddEditMode(false);
            selectorPanel.productComboBox.requestFocusInWindow();
        }
    }
    public boolean isValidData() {
        if (newProduct != null)
            return SwingValidator.isPresent(productPanel.codeTextField, "Product Code")
                && SwingValidator.isPresent(productPanel.descriptionTextField, "Description")
                && SwingValidator.isPresent(productPanel.priceTextField, "Unit Price")
                && SwingValidator.isDouble(productPanel.priceTextField, "Unit Price");
        else
            return SwingValidator.isPresent(productPanel.descriptionTextField, "Description");
                && SwingValidator.isPresent(productPanel.priceTextField, "Unit Price");
                && SwingValidator.isDouble(productPanel.priceTextField, "Unit Price");
    }
}
