import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>(); // 路径
        boolean[] used = new boolean[nums.length]; // 标记使用过的数字
        dfs(nums, path, used, res);

        return res;
    }

    private void dfs(int[] nums, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i-1])) {
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, path, used, res);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
// @lc code=end

