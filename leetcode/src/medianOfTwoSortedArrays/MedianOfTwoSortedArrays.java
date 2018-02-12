package medianOfTwoSortedArrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int i = 0;
        int j = 0;
        int iMin = 0;
        int iMax = m;
        int half = (m + n + 1) / 2;
        while(iMin <= iMax) {
            i = iMin + (iMax - iMin) / 2;
            j = half - i;
            if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else if (j > 0 && i < m && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else {
                break;
            }
        }
        int num1;
        if (i == 0) {
            num1 = nums2[j - 1];
        } else if (j == 0) {
            num1 = nums1[i - 1];
        } else {
            num1 = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        if (((m + n) & 1) == 1) {
            return num1;
        }
        int num2;
        if (i == m) {
            num2 = nums2[j];
        } else if (j == n) {
            num2 = nums1[i];
        } else {
            num2 = Math.min(nums1[i], nums2[j]);
        }
        return (num1 + num2) / 2.0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        System.out.println(obj.findMedianSortedArrays(new int[]{1}, new int[]{1}));
        System.out.println(obj.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(obj.findMedianSortedArrays(new int[]{}, new int[]{1, 3}));
        System.out.println(obj.findMedianSortedArrays(new int[]{1}, new int[]{}));
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 2}, new int[]{1}));
        System.out.println(obj.findMedianSortedArrays(new int[]{3, 5}, new int[]{2,8}));
        System.out.println(obj.findMedianSortedArrays(new int[]{4, 5}, new int[]{2,8}));
    }
}
