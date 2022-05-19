package 剑指offer.leetcode.editor.cn;
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 283 👎 0


import java.util.HashMap;
import java.util.Map;

// 数组中出现次数超过一半的数字
public class 剑指Offer39 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer39().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // O(n) 解法
        // num : count
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (count >= nums.length / 2) {
                return num;
            } else {
                map.put(num, count + 1);
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}