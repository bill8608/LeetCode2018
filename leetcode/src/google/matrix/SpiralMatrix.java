package google.matrix;

import java.util.ArrayList;
import java.util.List;
/*1. 给一个2d matrix，顺时针方向从外往里trace一遍里面的element。
        举个例子. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
        1  2   3  4
        5  6   7  8
        9 10 11 12. more info on 1point3acres.com
        那 return的就是
        1 2 3 4 8 12 11 10 9 5 6 7
        注意这个matrix不一定是square martirx. 鍥*/
//http://www.1point3acres.com/bbs/thread-210985-1-1.html
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
