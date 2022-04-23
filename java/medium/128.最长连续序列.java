import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {        
        // Step1: 序列去重，加入哈希表 
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // Step2：仅记录递增序列的开始
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果不是递增序列的开始，跳过
            if (set.contains(nums[i] - 1)) {
                continue;
            }            
            int count = 1;
            int cur = nums[i];
            // 穷尽连续递增序列
            while (set.contains(cur + 1)) {
                count++;
                cur++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
// @lc code=end

