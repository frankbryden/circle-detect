import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Image {

    private BufferedImage image;
    private BufferedReader bufferedReader;

    public Image(String path){
        if (!this.loadImage(path)){
            System.err.println("Failed.");
        }
        this.convertGrayScale();
    }

    public Image(int width, int height){
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
    }

    public Image(BufferedImage imageRaw){
        this.image = imageRaw;
    }

    public void convertGrayScale(){
        BufferedImage tmpImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = tmpImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        this.image = tmpImage;
    }

    public boolean loadImage(String path){
        try {
            this.image = ImageIO.read(new File(path));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public BufferedImage getBufferedImage(){
        return this.image;
    }

    public int getWidth(){
        return image.getWidth();
    }

    public int getHeight(){
        return image.getHeight();
    }

    public int getValueAt(int x, int y){
        return image.getRGB(x, y);
    }
}
