import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    // 记录回溯算法的递归路径
    List<Integer> track = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {       
        // 回溯
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        // 每个节点的值都是一个子集
        result.add(new ArrayList(track));
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 向下递归
            backtrack(nums, i + 1);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }
}
// @lc code=end

