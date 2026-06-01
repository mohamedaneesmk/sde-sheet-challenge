package arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        setMatrixZeros(matrix);
        convertToZeros(matrix);
        printMatrix(matrix);
    }

    private static void convertToZeros(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == -1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    public static void setMatrixZeros(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    markRow(row, matrix);
                    markCol(col, matrix);
                }
            }
        }
    }

    private static void markCol(int col, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] != 0) {
                matrix[row][col] = -1;
            }
        }
    }

    private static void markRow(int row, int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[row][col] != 0) {
                matrix[row][col] = -1;
            }
        }
    }
}
