import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        // 从后向前查找第一个顺序对 (i,j)，满足 a[i] < a[j], 且a[j]尽量靠右
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    // 交换a[i]和a[j],保证字典序增大
                    swap(nums, i, j);
                    // 将a[i]后面的元素从降序改为升序
                    reverse(nums, i + 1);
                    return;
                }
            }            
        }
        reverse(nums, 0);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);            
        }
    }
}
// @lc code=end

