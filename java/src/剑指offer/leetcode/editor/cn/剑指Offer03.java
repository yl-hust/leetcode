package 剑指offer.leetcode.editor.cn;
//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 
// 👍 838 👎 0


import java.util.HashSet;
import java.util.Set;

// 数组中重复的数字
public class 剑指Offer03 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer03().new Solution();
        int[] input = new int[]{1,2,3,4,5};
        solution.findRepeatNumber(input);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeatNumber = -1;
        for(int num : nums) {
            if (set.contains(num)) {
                repeatNumber = num;
                break;
            } else {
                set.add(num);
            }
        }
        return repeatNumber;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}