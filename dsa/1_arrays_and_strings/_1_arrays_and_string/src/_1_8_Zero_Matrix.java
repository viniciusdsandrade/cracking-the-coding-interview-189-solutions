public class _1_8_Zero_Matrix {
    public static void main(String[] args) {

        int[][] matriz = new int[][]{
                {0, 2},
                {3, 4}
        };

        int[][] matriz0 = new int[][]{
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        int[][] matrix1 = new int[][]{
                {0, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 12},
                {13, 14, 15, 16}
        };

        int[][] matrix2 = new int[][]{
                {0, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 0, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int[][] matrix3 = new int[][]{
                {0, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 0, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 0, 30},
                {31, 32, 33, 34, 35, 36}
        };

        int[][] matrix4 = new int[][]{
                {1, 2, 3, 4, 5, 6, 7},
                {8, 0, 10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19, 20, 21},
                {22, 23, 24, 0, 26, 27, 28},
                {29, 30, 31, 32, 33, 34, 35},
                {36, 37, 38, 39, 40, 0, 42},
                {43, 44, 45, 46, 47, 48, 49}
        };

        int[][] matrix5 = new int[][]{
                {1, 0, 3, 4, 5, 6, 7, 8},
                {9, 10, 11, 12, 13, 14, 15, 16},
                {17, 18, 0, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31, 32},
                {33, 34, 35, 36, 37, 0, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48},
                {49, 50, 51, 52, 53, 54, 55, 56},
                {57, 58, 59, 60, 61, 62, 63, 64}
        };

        int[][] matrix6 = new int[][]{
                {1, 0, 3, 4, 5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14, 15, 16, 17, 18},
                {19, 20, 21, 0, 23, 24, 25, 26, 27},
                {28, 29, 30, 31, 32, 33, 34, 35, 36},
                {37, 38, 39, 40, 41, 42, 43, 44, 45},
                {46, 47, 48, 49, 50, 0, 52, 53, 54},
                {55, 56, 57, 58, 59, 60, 61, 62, 63},
                {64, 65, 66, 67, 68, 69, 70, 71, 0},
                {73, 74, 75, 76, 77, 78, 79, 80, 81}
        };

        int[][] matrix7 = new int[][]{
                {0, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 0, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 0, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 0, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 0, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 0},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
        };

        testSetZeros(matriz);
        testSetZeros(matriz0);
        testSetZeros(matrix1);
        testSetZeros(matrix2);
        testSetZeros(matrix3);
        testSetZeros(matrix4);
        testSetZeros(matrix5);
        testSetZeros(matrix6);
        testSetZeros(matrix7);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }
    }

    public static void setZeros(int[][] matrix) {

        // Check if matrix is empty
        if (matrix.length == 0 || matrix[0].length == 0) return;

        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Verifica se a matriz tem zeros e guarda as linhas e colunas que tem zeros
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }

            if (column[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void testSetZeros(int[][] matrix) {
        System.out.println("Input: ");
        printMatrix(matrix);

        long startTime = System.nanoTime();
        setZeros(matrix);
        long endTime = System.nanoTime();

        System.out.println("Output: ");
        printMatrix(matrix);

        System.out.println("Execution time: " + (endTime - startTime) + "ns");
        System.out.printf("Execution time: %.5f ms%n", (endTime - startTime) / 1_000_000.0);
    }
}