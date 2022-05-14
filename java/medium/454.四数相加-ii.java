import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 两两一组，降低时间复杂度O为(n*n)
        // nums1+nums2 : 出现次数 
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                int count = map.getOrDefault(sum, 0);
                map.put(sum, count + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = -(nums3[i] + nums4[j]);
                ans += map.getOrDefault(sum, 0);
            }
        }
        return ans;
    }
}
// @lc code=end

