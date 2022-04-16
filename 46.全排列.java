import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Stack<Integer> path = new Stack<Integer>();
        // boolean[] used = new boolean[nums.length];
        // dfs(nums, res, path, used);
        dfs(nums, res, path);
        return res;
    }

    // private void dfs(int[] nums, List<List<Integer>> list, Stack path, boolean[] used) {
    //     System.out.println(path);
    //     if (path.size() == nums.length) {
    //         list.add(new ArrayList<>(path));
    //         return;
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (used[i]) {
    //             continue;
    //         }
    //         path.push(nums[i]);
    //         used[i] = true;
    //         dfs(nums, list, path, used);
    //         path.pop();
    //         used[i] = false;
    //     }
    // }

    private void dfs(int[] nums, List<List<Integer>> list, Stack path) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.push(nums[i]);
            dfs(nums, list, path);
            path.pop();
        }

    }


}
// @lc code=end

