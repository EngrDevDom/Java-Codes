import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * ImageViewer.java
 * A program for viewing images.
 */
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewer();
            frame.setTitle("Image Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a label to show an image.
 */
class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    
    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // use a label to display the images
        var label = new JLabel();
        add(label);

        // set up the file chooser
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // var menu bar
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("File");
        menuBar.add(menu);

        var openItem = new JMenuItem("Open");

        menu.add(openItem);
        openItem.addActionListener(event -> {
            // show file chooser dialog
            int result = chooser.showOpenDialog(null);

            // if file selected, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        var exitItem = newJMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}

