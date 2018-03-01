package google.majorityElement;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementIII {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = -1;
        int candidate2 = -1;
        int candidate3 = -1;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (num == candidate3) {
                count3++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else if (count3 == 0) {
                candidate3 = num;
                count3++;
            } else {
                count1--;
                count2--;
                count3--;
            }
        }

        count1 = 0;
        count2 = 0;
        count3 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            if (num == candidate2) {
                count2++;
            }
            if (num == candidate3) {
                count3++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 4) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 4) {
            res.add(candidate2);
        }
        if (count3 > nums.length / 4) {
            res.add(candidate3);
        }
        return res;
    }

    public static void main(String[] args) {
        MajorityElementIII obj = new MajorityElementIII();
        obj.majorityElement(new int[]{1, 3, 3, 4, 4, 2, 2}).stream().forEach(System.out::println);
        System.out.println();
        obj.majorityElement(new int[]{3, 3, 3, 5, 3, 2, 2}).stream().forEach(System.out::println);
        System.out.println();
        obj.majorityElement(new int[]{3, 3, 3, 5, 3, 3, 2}).stream().forEach(System.out::println);
        System.out.println();
        obj.majorityElement(new int[]{}).stream().forEach(System.out::println);
    }
}
