import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum1(int[] nums, int k) {
        // 暴力解法O(n*n)    
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0; // 以i开头的子数组的和
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }        
        return count;        
    }
    public int subarraySum(int[] nums, int k) {
        // 前缀和
        // pre[i] = pre[i-1] + nums[i]
        // 假设存在子数组[j..i]的和为k，那么
        // sum(nums[j->i]) = k = pre[i] - pre[j-1]
        // num [3,4, 7, 2,-1, 3] i=3 j=1 k = 13 
        // pre [3,7,14,16,15,18] pre[3]-pre[0] = 13    
        int count = 0;
        // 缓存 pre值 : 出现次数
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        // base case:
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }            
        return count;
    }
}
// @lc code=end

