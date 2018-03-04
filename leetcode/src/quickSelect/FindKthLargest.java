package quickSelect;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while(start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < index) {
                start = pivot + 1;
            } else if (pivot > index) {
                end = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return nums[start];
    }
    private int partition(int[] nums, int start, int end) {
        int pivot = start, tmp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) {
                start++;
            }
            while (start <= end && nums[end] > nums[pivot]) {
                end--;
            }
            if (start > end) {
                break;
            }
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
        tmp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = tmp;
        return end;
    }
    public static void main(String[] args) {
        FindKthLargest obj = new FindKthLargest();
        System.out.println(obj.findKthLargest(new int[]{3, 5, 9, 2, 0, 10, 7}, 4) == 5);
        System.out.println(obj.findKthLargest(new int[]{3, 5, 9, 2, 0, 10, 7}, 7) == 0);
        System.out.println(obj.findKthLargest(new int[]{3, 5, 9, 2, 0, 10, 7}, 2) == 9);
    }
}
