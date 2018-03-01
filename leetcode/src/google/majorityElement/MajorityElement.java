package google.majorityElement;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == majority) {
                count++;
            } else if (count == 0) {
                majority = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majorityElement(new int[]{2, 3, 4, 5, 2, 2, 2}));
    }
}
