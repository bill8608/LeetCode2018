package google.majorityElement;

import java.util.ArrayList;
import java.util.List;

// output all the elements with appearance > floor(N/3)

/*Great algorithm, but need some more explanation on the confusing word 2 “majorities”. They are not necessarily be the 2 most frequent elements after the 1st round. Here is why the poster’s 2 “majorities” algorithm really works:
        consider 3 cases:

        1. there are no elements that appears more than n/3 times, then whatever the algorithm
        got from 1st round wound be rejected in the second round.
        2. there are only one elements that appears more than n/3 times, after 1st round one of
        the candicate must be that appears more than n/3 times(<2n/3 other elements could only
        pair out for <n/3 times), the other candicate is not necessarily be the second most frequent
        but it would be rejected in 2nd round.
        3. there are two elments appears more than n/3 times, candicates would contain both of
        them. (<n/3 other elements couldn't pair out any of the majorities.)*/

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            if (num == candidate2) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }

    public static void main(String[] args) {
        MajorityElementII obj = new MajorityElementII();
        obj.majorityElement(new int[]{2, 3, 3, 5, 3, 2, 2}).forEach(System.out::println);
        System.out.println();
        obj.majorityElement(new int[]{3, 3, 3, 5, 3, 2, 2}).forEach(System.out::println);
        System.out.println();
        obj.majorityElement(new int[]{3, 3, 3, 5, 3, 3, 3}).forEach(System.out::println);
        System.out.println();
        obj.majorityElement(new int[]{1, 2, 3, 4, 5, 6, 3}).forEach(System.out::println);
        System.out.println();
        obj.majorityElement(new int[]{}).forEach(System.out::println);
    }
}
