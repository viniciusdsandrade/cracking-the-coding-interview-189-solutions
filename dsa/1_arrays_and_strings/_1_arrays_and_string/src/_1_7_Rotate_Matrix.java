public class _1_7_Rotate_Matrix {
    public static void main(String[] args) {

        int[][] matriz = new int[][]{
                {1, 2},
                {3, 4}
        };

        int[][] matriz0 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix1 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] matrix2 = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int[][] matrix3 = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };

        int[][] matrix4 = new int[][]{
                {1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19, 20, 21},
                {22, 23, 24, 25, 26, 27, 28},
                {29, 30, 31, 32, 33, 34, 35},
                {36, 37, 38, 39, 40, 41, 42},
                {43, 44, 45, 46, 47, 48, 49}
        };

        int[][] matrix5 = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8},
                {9, 10, 11, 12, 13, 14, 15, 16},
                {17, 18, 19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31, 32},
                {33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48},
                {49, 50, 51, 52, 53, 54, 55, 56},
                {57, 58, 59, 60, 61, 62, 63, 64}
        };

        int[][] matrix6 = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24, 25, 26, 27},
                {28, 29, 30, 31, 32, 33, 34, 35, 36},
                {37, 38, 39, 40, 41, 42, 43, 44, 45},
                {46, 47, 48, 49, 50, 51, 52, 53, 54},
                {55, 56, 57, 58, 59, 60, 61, 62, 63},
                {64, 65, 66, 67, 68, 69, 70, 71, 72},
                {73, 74, 75, 76, 77, 78, 79, 80, 81}
        };

        int[][] matrix7 = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
        };

        testRotateMatrix(matriz);
        testRotateMatrix(matriz0);
        testRotateMatrix(matrix1);
        testRotateMatrix(matrix2);
        testRotateMatrix(matrix3);
        testRotateMatrix(matrix4);
        testRotateMatrix(matrix5);
        testRotateMatrix(matrix6);
        testRotateMatrix(matrix7);
    }

    public static boolean rotateMatrix(int[][] matrix) {

        /*
        for i = 0 to n
            temp = top[i]
            top[i] = left[i]
            left[i] = bottom[i]
            bottom[i] = right[i]
            right[i] = temp
         */

        // Se a matriz for vazia ou não for quadrada, não é possível rotacionar
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int dim = matrix.length;

        // Rotaciona a matriz em camadas
        for (int layer = 0; layer < dim / 2; layer++) {
            // Primeiro e último elemento da camada
            int first = layer;

            // O último elemento é o tamanho da matriz - 1 - a camada
            int last = dim - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                // Salva o valor do topo
                int top = matrix[first][i];

                // Esquerda -> Topo
                matrix[first][i] = matrix[last - offset][first];

                // Baixo -> Esquerda
                matrix[last - offset][first] = matrix[last][last - offset];

                // Direita -> Baixo
                matrix[last][last - offset] = matrix[i][last];

                // Topo -> Direita
                matrix[i][last] = top;
            }
        }

        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }
    }

    public static void testRotateMatrix(int[][] matrix) {
        System.out.println("\nInput:");
        printMatrix(matrix);

        long startTime = System.nanoTime();
        boolean result = rotateMatrix(matrix);
        long endTime = System.nanoTime();

        System.out.println("\nOutput:");
        printMatrix(matrix);

        System.out.println("rotateMatrix: " + result);
        System.out.println("Time: " + (endTime - startTime) + " ns");
        System.out.printf("Time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}