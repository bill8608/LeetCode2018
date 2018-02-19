package jumpGameII;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxCover = 0;
        int steps = 0;
        int lastCover = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > lastCover) {
                steps++;
                lastCover = maxCover;
            }
            maxCover = Math.max(maxCover, nums[i] + i);
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{2,3,1,1,4}));
        System.out.println(jumpGameII.jump(new int[]{3,2,1,0,4}));
    }
}
