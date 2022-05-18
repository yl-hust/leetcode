package 剑指offer.leetcode.editor.cn;
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 
// 👍 440 👎 0

import java.util.ArrayList;
import java.util.List;

// 和为s的连续正数序列
public class 剑指Offer57II {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer57II().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        // target是奇数有解
        // 双指针，寻找满足条件的区间 [left, right)
        int left = 1;
        int right = 1;
        List<int[]> res = new ArrayList<>();

        int sum = 0;
        while (left <= target / 2) {
            if(sum > target) { // left move on
                sum -= left;
                left++;
            } else if (sum < target) { // right move on
                sum += right;
                right++;
            } else { // find one
                int[] ans = new int[right - left];
                // [left...right) is one answer
                for (int i = left; i < right; i++) {
                    ans[i - left] = i;
                }
                res.add(ans);
                // left move on
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}