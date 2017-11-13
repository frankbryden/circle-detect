import javax.swing.*;
import java.awt.image.BufferedImage;

public class CircleDetectionWindow extends JFrame {
    private ImagePanel imagePanel;
    public CircleDetectionWindow(){
        super();
        this.setSize(1024, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void updateImage(BufferedImage imageRaw){
        if (imagePanel != null){
            imagePanel.updateImage(imageRaw);
            imagePanel.repaint();
        } else {
            imagePanel = new ImagePanel(imageRaw);
            this.add(imagePanel);
            System.out.println("Calling repaint...");
            imagePanel.revalidate();
            System.out.println("Done");
        }
    }
}
