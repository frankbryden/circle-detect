import java.awt.*;
import java.awt.image.BufferedImage;

public class EdgeDetect {
    private Image image;
    private Algorithms algs;

    public EdgeDetect(Image image){
        this.image = image;
        this.algs = new Algorithms();
    }

    public void applySobel(){
        /* Strip off the first and last pixels, as they don't have neighbours :/ */
        BufferedImage result = new BufferedImage(image.getWidth() - 2, image.getHeight() - 2, BufferedImage.TYPE_BYTE_GRAY);
        System.out.printf("Value of RGB at 20, 20 is %d%n", image.getValueAt(20, 20));
        System.out.printf("Value of WHITE at 20, 20 is %d%n", Color.WHITE.getRGB());

        for (int x = 1; x < image.getWidth() - 1; x++){
            for (int y = 1; y < image.getHeight() - 1; y++){
                Matrix3 pixels = getSurroundingPixels(x, y);
                int transformedVal = algs.sobelOperator2(pixels);
                int greyVal = transformedVal & 0xFF;
                if (greyVal > 210){
                    System.out.println("WHITE " + transformedVal);
                    result.setRGB(x - 1, y - 1, Color.WHITE.getRGB());
                } else {
                    //result.setRGB(x - 1, y - 1, transformedVal);
                    result.setRGB(x - 1, y - 1, Color.BLACK.getRGB());
                }
            }
        }
        this.image = new Image(result);
    }



    public Matrix3 getSurroundingPixels(int x, int y){
        /*
        *   We create a table like this
        *       -1      0     1
        *   -1 | 125 | 210 | 120 |
        *   0  | 85  | 175 | 200 |
        *   1  | 150 | 20  | 55  |
        *
         */
        int[][] data = new int[3][3];
        for (int i = -1; i < 2; i ++){
            for (int j = -1; j < 2; j++){
                data[i + 1][j + 1] = image.getValueAt(x - i, y - j);
            }
        }
        return new Matrix3(data);
    }

    public Image getImage(){
        return this.image;
    }
}
