import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductMaintenancePanel extends JPanel {
    ProductDAO productDAO;
    ArrayList<Product> products;
    Product newProduct = null;

    ProductSelectorPanel selectorPanel;
    ProductDisplayPanel productPanel;
    ProductButtonPanel buttonPanel;

    public ProductMaintenancePanel() {
        productDAO = DAOFactory.getProductDAO();
        products = productDAO.getProducts();

        setLayout(new GridBagLayout());
        selectorPanel = new ProductSelectorPanel();
        add(selectorPanel, getConstraints(0,0,1,1, GridBagConstraints.EAST));
        productPanel = new ProductDisplayPanel();
        add(productPanel, getConstraints(0,1,1,1, GridBagConstraints.EAST));
        buttonPanel = new ProductButtonPanel();
        add(buttonPanel, getConstraints(0,2,1,1, GridBagConstraints.EAST));

        ProductPanel.showProduct(products.get(0));
        selectorPanel.selectProduct(products.get(0));
    }
    private GridBagConstraints getConstraints(int gridx, int gridy, int gridWidth, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = getHeight();
        c.anchor = anchor;
        return c;
    }
}
