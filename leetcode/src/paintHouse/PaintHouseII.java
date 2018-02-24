package paintHouse;

import java.util.*;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        // mininum number's index min1 and second minimum number's index
        int min1 = -1, min2 = -1;
        for (int i = 0; i < costs.length; ++i) {
            int last1 = min1, last2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < costs[0].length; ++j) {
                if (j != last1) {
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else if (j != last2) {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return min1 < 0 ? 0 : costs[costs.length - 1][min1];
    }

    public static void main(String[] args) {
        PaintHouseII obj = new PaintHouseII();
/*        int[][] inputs = new int[][]{{20,19,11,13,12,16,16,17,15,9,5,18},{3,8,15,17,19,8,18,3,11,6,7,12},{15,4,11,1,18,2,10,9,3,6,4,15}};*/
        //int[][] inputs = new int[][]{{8,16,12,18,9},{19,18,8,2,8},{8,5,5,13,4},{15,9,3,19,2},{8,7,1,8,17},{8,2,8,15,5},{8,17,1,15,3},{8,8,5,5,16},{2,2,18,2,9}};
        int[][] inputs = new int[][]{{1,5,3},{2,9,4}};
        System.out.println(obj.minCostII(inputs));
    }
}
