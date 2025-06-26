import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: 构建出现次数数组
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // Step 2: 大顶堆，按照出现次数入堆
        PriorityQueue<int[]> q = new PriorityQueue<>(k, (a, b) -> b[1] - a[1]);
        map.forEach((num, freq) -> q.add(new int[] {num, freq}));

        // Step 3: 返回题意数组
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = q.poll()[0];            
        }
        return result;
    }
}
// @lc code=end

