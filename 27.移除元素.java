import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {

    // 交换移除
    // public int removeElement(int[] nums, int val) {
    //     int count = nums.length;
    //     for (int i = 0; i < count; i++) {
    //         if (nums[i] == val) {
    //             nums[i] = nums[count - 1];//最后一个元素与当前元素交换
    //             count--;// 释放最后一个元素
    //             i--;                             
    //         }
    //         System.out.println(Arrays.toString(nums));            
    //     }
    //     return count;
    // }
    
    
    // 拷贝覆盖
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

