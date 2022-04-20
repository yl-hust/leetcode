import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(int[] candidates, int remains, ArrayList path, int start) {
        if (remains == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
           if (candidates[i] > remains) {
               continue;
           }
           path.add(candidates[i]);
           backtrack(candidates, remains - candidates[i], path, i);
           path.remove(path.size() - 1);
        }
    }

}
// @lc code=end

