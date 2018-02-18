package jumpGame;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int furthest = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (i <= furthest && nums[i] + i >= furthest) {
                furthest = nums[i] + i;
            }
        }
        return furthest >= nums.length - 1;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}) == true);
        System.out.println(jumpGame.canJump(new int[]{3,2,1,0,4}) == false);
    }
}
