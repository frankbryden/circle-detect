import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
    ImageIcon imageIcon;
    public ImagePanel(BufferedImage imageRaw){

        imageIcon = new ImageIcon(imageRaw);
        System.out.printf("(%d, %d)%n", imageIcon.getIconWidth(), imageIcon.getIconHeight());

        this.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
    }

    @Override
    public void paintComponent(Graphics g){
        System.out.println("Painting !");
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        imageIcon.paintIcon(this, g, 0, 0);
        //g2d.fillOval(10, 10, 50, 50);
    }

    public void updateImage(BufferedImage imageRaw){
        this.imageIcon = new ImageIcon(imageRaw);
    }
}
