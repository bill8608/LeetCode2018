package partitionEqualSubsetSum;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    // one dimensional array
      public boolean canPartition(int[] nums) {
          int total = 0;
          for (int num : nums) {
              total += num;
          }
          if ((total & 1) == 1) {
              return false;
          }
          total /= 2;

          boolean [] dp = new boolean[total + 1];
          dp[0] = true;

          for (int num : nums) {
              for (int i = total; i > 0; --i) {
                  if (i >= num) {
                      dp[i] = dp[i] || dp[i - num];
                  }
              }
          }
          return dp[total];
      }

    // two dimensional array
/*    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if ((total & 1) == 1) {
            return false;
        }
        total /= 2;

        boolean [][] dp = new boolean[nums.length + 1][total + 1];

        dp[0][0] = true;

        for (int i = 1; i <= nums.length; ++i) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= total; ++j) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 1; j <= total; ++j) {
                dp[i][j] = dp[i - 1][j];

                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][total];
    }*/

    public static void main(String[] args) {
        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
        System.out.println(obj.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(obj.canPartition(new int[]{1, 2, 3, 5}));
    }
}
