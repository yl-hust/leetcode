import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        // 最直接的办法，先sort，然后分成两个子数组，最后反序，穿插
        // [1,2,3,2,4,2]=>[1,2,2]和[2,3,4]=>[2,2,1]和[4,3,2]=>[2,4,2,3,1,2]
        // 反序的目的是使相同的元素分布在最两端
        int[] helper = nums.clone();        
        Arrays.sort(helper);
        int len = nums.length;
        // 填充奇数位(反序)
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = helper[--len]; // =>[x,4,x,3,x,2]
        }
        // 填充偶数位(反序)
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = helper[--len]; // =>[2,4,2,3,1,2]
        }
    }
}
// @lc code=end

