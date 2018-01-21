class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0;
        int index = (n + m + 1) / 2, index2 = (n + m + 2) / 2;
        int count = 0;
        double ans1 = 0, ans2 = 0;
        while (count < 2) {
            if ((j >= m) || (i < n && nums1[i] < nums2[j])) {
                i++;
                if (index == (i + j)) {
                    ans1 = nums1[i - 1];
                    count++;
                }
                if (index2 == (i + j)) {
                    ans2 = nums1[i - 1];
                    count++;
                }
            } else {
                j++;
                if (index == (i + j)) {
                    ans1 = nums2[j - 1];
                    count++;
                }
                if (index2 == (i + j)) {
                    ans2 = nums2[j - 1];
                    count++;
                }
            }
        }
        return (ans1 + ans2) / 2;
    }
}