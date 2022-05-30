/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    // 非最优解 O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        if (i == m) {
            while (j < n) {
                merged[k++] = nums2[j++];             
            }          
        } else {
            while (i < m) {
                merged[k++] = nums1[i++];                
            }
        }        
        int mid = (m + n) / 2;
        if (((m + n) & 1) == 1) {
            return merged[mid];
        } else {
            double x = (merged[mid - 1] + merged[mid]) / 2.0;
            return x;
        }
    }
}
// @lc code=end

