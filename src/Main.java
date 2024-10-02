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
            initalizeMatrix(matrixB, random); // matrix initialization

            addMatrices(matrixA, matrixB, matrixC); // matrix addition

            // matrix output
            System.out.println("Matrix A:");
            printMatrix(matrixA);
            System.out.println("Matrix B:");
            printMatrix(matrixB);
            System.out.println("Matrix C (A + B):");
            printMatrix(matrixC);

            int sum = calculateSum(matrixC); // sum of largest elements in even columns and smallest elements in odd columns
            System.out.println("Sum of largest elements in even columns and smallest elements in odd columns: " + sum);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // function to initialize matrix with random values
    private static void initalizeMatrix(int[][] matrix, Random random) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
    }

    // function to add two matrices
    private static void addMatrices(int[][] matrixA, int[][] matrixB, int[][] matrixC) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
    }

    // function to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // function to calculate sum of largest elements in even columns and smallest elements in odd columns
    private static int calculateSum(int[][] matrix) {
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            int extremeValue = (j % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                if (j % 2 == 0) { // even column searching for max
                    extremeValue = Math.max(extremeValue, matrix[i][j]);
                } else { // odd column searching for min
                    extremeValue = Math.min(extremeValue, matrix[i][j]);
                }
            }
            sum += extremeValue;
        }
        return sum;
    }
}