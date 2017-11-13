public class Matrix3 {
    private final int[][] data;

    public Matrix3(int[][] input){
        data = new int[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                data[i][j] = input[i][j];
            }
        }
    }

    public int[][] multiply(Matrix3 input){
        int[][] result = new int[3][3];
        int[][]inputMatrix = input.getMatrix();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                result[i][j]  += data[i][j] * inputMatrix[j][i];
            }
        }
        return result;
    }

    public int[][] getMatrix(){
        return this.data;
    }
}
