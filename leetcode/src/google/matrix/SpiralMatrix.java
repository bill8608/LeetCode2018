package google.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; ++i) {
                    res.add(matrix[x][y++]);
                }
                break;
            }
            if (n == 1) {
                for (int j = 0; j < m; ++j) {
                    res.add(matrix[x++][y]);
                }
                break;
            }
            for (int i = 0; i < n - 1; ++i) {
                res.add(matrix[x][y++]);
            }
            for (int j = 0; j < m - 1; ++j) {
                res.add(matrix[x++][y]);
            }
            for (int i = 0; i < n - 1; ++i) {
                res.add(matrix[x][y--]);
            }
            for (int j = 0; j < m - 1; ++j) {
                res.add(matrix[x--][y]);
            }
            m -= 2;
            n -= 2;
            x++;
            y++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(matrix).forEach(x -> System.out.print(x + " "));
    }
}
