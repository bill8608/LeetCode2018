package numOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslands {
    public int numOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(queue.size() > 0) {
            int[] currLoc = queue.poll();
            for (int[] dir : dirs) {
                int row = currLoc[0] + dir[0];
                int col = currLoc[1] + dir[1];
                if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
                    continue;
                }
                queue.offer(new int[]{row, col});
                grid[row][col] = '0';
            }
        }
    }
    
    public static void main(String[] args) {
        NumOfIslands numOfIslands = new NumOfIslands();
        char[][] grid = new char [][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numOfIslands.numOfIslands(grid) == 1);

        grid = new char [][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numOfIslands.numOfIslands(grid) == 3);

    }
}
