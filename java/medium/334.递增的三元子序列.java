/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        // 保证first < second的前提下，寻找third > second
        for (int num : nums) {
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;        
    }
    // public boolean increasingTriplet(int[] nums) {
    //     // 暴力解法，超时！！！
    //     if (nums.length < 3) return false;
    //     int i = 0;
    //     int j = 1;
    //     int k = 2;
    //     while (i < nums.length -2) {
    //         j = i + 1;
    //         if (nums[j] > nums[i]) {
    //             while (j < nums.length - 1) {
    //                 if (nums[j] > nums[i]) {
    //                    k = j + 1;
    //                    while (k < nums.length) {
    //                        if (nums[k] > nums[j]) {
    //                            return true;
    //                        }
    //                        k++;
    //                    } 
    //                 }
    //                 j++;
    //             }
    //         }
    //         i++;
    //     }        
    //     return false;
    // }
}
// @lc code=end

