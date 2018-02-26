package slidingWindow;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int ri = 0;
        // keep [i - k + 1, i] sliding window
        for (int i = 0; i < nums.length; ++i) {
            // remove out of [i - k + 1, i]
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            // remove if smaller numbers are in k range because it is useless
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);
            if (i >= k - 1) {
                res[ri++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        /*int[] res = obj.maxSlidingWindow(new int[]{4, 3, 11}, 3);*/
        int[] res = obj.maxSlidingWindow(new int[]{4, -2}, 2);
        for(int r : res) {
            System.out.println(r);
        }
    }
}
