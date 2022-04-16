import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }

    public void generate(List<String> result, String subList, int leftCount, int rightCount) {
        if (leftCount == 0 && rightCount == 0) {
            result.add(subList);
            return;
        }
        if (leftCount > 0) {
            generate(result, subList + '(', leftCount - 1, rightCount);
        }
        if (rightCount > leftCount) {
            generate(result, subList + ')', leftCount, rightCount - 1);
        }
    }

}
// @lc code=end

