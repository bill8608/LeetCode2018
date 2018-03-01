package google.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[][]{};
        }
        int[][] matrix = new int[n][n];

        int x = 0;
        int y = 0;
        int val = 1;
        while (n > 0) {
            if (n == 1) {
                matrix[n - 1][n - 1] = 1;
                break;
            }
            for (int i = 0; i < n - 1; ++i) {
                matrix[x][y++] = val++;
            }
            for (int j = 0; j < n - 1; ++j) {
                matrix[x++][y] = val++;
            }
            for (int i = 0; i < n - 1; ++i) {
                matrix[x][y--] = val++;
            }
            for (int j = 0; j < n - 1; ++j) {
                matrix[x--][y] = val++;
            }
            n -= 2;
            x++;
            y++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        //int[][] matrix = spiralMatrixII.generateMatrix(0);
        int[][] matrix = spiralMatrixII.generateMatrix(4);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
