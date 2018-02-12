package singleNumber;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber(new int[]{1, 2, 2}));
        System.out.println(obj.singleNumber(new int[]{1, 3, 4, 6, 7, 8, 4, 3, 7, 1, 6}));
    }
}
