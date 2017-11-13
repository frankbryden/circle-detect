public class Algorithms {

    private Matrix3 sobelMatrixX,sobelMatrixY;

    public Algorithms(){
        int[][] dataX = {{-1, 0 ,1}, {-2, 0, 2}, {-1, 0, 1}};
        int[][] dataY = {{-1, -2, -1}, {0, 0, 0}, {1, 2, 1}};
        sobelMatrixX = new Matrix3(dataX);
        sobelMatrixY = new Matrix3(dataY);
    }

    public int sobelOperator(Matrix3 pixelArea){
        int[][] result = sobelMatrixX.multiply(pixelArea);
        int sum = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                sum += result[i][j];
            }
        }
        return sum;
    }

    public int sobelOperator2(Matrix3 pixelArea){
        int[][] resultX = sobelMatrixX.multiply(pixelArea);
        int[][] resultY = sobelMatrixY.multiply(pixelArea);
        int sumX = 0;
        int sumY = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                sumX += resultX[i][j];
                sumY += resultY[i][j];
            }
        }
        return (int) Math.sqrt(Math.pow(sumX, 2) + Math.pow(sumY, 2));
    }
}
