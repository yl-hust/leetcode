/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针, TC:O(m+n) SC:O(m+n)
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m+n];
        int p = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                sorted[p++] = nums2[p2++];
            } else if (p2 == n) {
                sorted[p++] = nums1[p1++];
            } else {
                sorted[p++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
            }            
        }
        for (int i = 0; i < sorted.length; i++) {
            nums1[i] = sorted[i];
        }        
    }
}
// @lc code=end

