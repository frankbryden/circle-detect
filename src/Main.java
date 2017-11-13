public class Main {
    public static void main(String[] args){
        CircleDetectionWindow window = new CircleDetectionWindow();
        Image img = new Image("img.png");
        window.updateImage(img.getBufferedImage());

        EdgeDetect ed = new EdgeDetect(img);
        ed.applySobel();
        window.updateImage(ed.getImage().getBufferedImage());
    }
}
