package arrays;

/*
    BRUTE FORCEC SOLUTION
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
*/

/* 
// BETTER SOLUTION
public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        setMatrixZeros(matrix);
        printMatrix(matrix);
    }

    private static void setMatrixZeros(int[][] matrix) {
        int[] rowMatrix = new int[matrix.length];
        int[] colMatrix = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rowMatrix[row] = 1;
                    colMatrix[col] = 1;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (rowMatrix[row] == 1 || colMatrix[col] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}*/

// OPTIMAL
public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        setMatrixZeros(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void setMatrixZeros(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row contains 0
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if first col contains 0
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Mark rows and columns
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Set zeros based on markers
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Zero out first row if needed
        if (firstRowZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }

        // Zero out first row if needed
        if (firstColZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
