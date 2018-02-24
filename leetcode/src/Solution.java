import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the function below.
     */
    static int Group(String[] grid) {
        if (grid == null && grid.length == 0) {
            return 0;
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length();
        char[][] chars = new char[m][n];
        int row = 0;
        for (String str : grid) {
            chars[row++] = str.toCharArray();
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (chars[i][j] == 'Y') {
                    chars[i][j] = 'T';
                    res++;
                    helper(chars, i, j);
                }
            }
        }
        System.out.println("res: " + res);
        int sum = 0;
        for (int i = 0; i <= res; i += 2) {
            sum += getCombinationNumber(res, i);
        }
        return sum;
    }
    static void helper(char[][] chars, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int dirs[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int[] dir : dirs) {
                int x = dir[0] + loc[0];
                int y = dir[1] + loc[1];
                if (x < 0 || x > chars.length - 1 || y < 0 || y > chars[0].length -1 || chars[x][y] != 'Y') {
                    continue;
                } else {
                    queue.offer(new int[]{x, y});
                    chars[x][y] = 'T';
                }
            }
        }
    }
    static int getCombinationNumber(int res, int i) {
        int sum = 1;
        if (i == 0) {
            return sum;
        }
        for (int r = res; r > res - i; r--) {
            sum *= r;
        }
        for (int k = 1; k <= i; ++k) {
            sum /= k;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int grid_size = 0;
        grid_size = Integer.parseInt(in.nextLine().trim());

        String[] grid = new String[grid_size];
        for(int i = 0; i < grid_size; i++) {
            String grid_item;
            try {
                grid_item = in.nextLine();
            } catch (Exception e) {
                grid_item = null;
            }
            grid[i] = grid_item;
        }

        res = Group(grid);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
