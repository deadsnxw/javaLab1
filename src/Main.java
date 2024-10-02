import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            int rows = 3;
            int columns = 3;
            int [][] matrixA = new int[rows][columns];
            int [][] matrixB = new int[rows][columns];
            int [][] matrixC = new int[rows][columns];

            Random random = new Random();

            initalizeMatrix(matrixA, random);
            initalizeMatrix(matrixB, random);

            addMatrices(matrixA, matrixB, matrixC);



        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void initalizeMatrix(int[][] matrix, Random random) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
    }

    private static void addMatrices(int[][] matrixA, int[][] matrixB, int[][] matrixC) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
    }
}