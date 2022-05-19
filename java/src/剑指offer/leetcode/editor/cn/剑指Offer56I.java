package 剑指offer.leetcode.editor.cn;
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 638 👎 0


// 数组中数字出现的次数
public class 剑指Offer56I {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer56I().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        // XOR for all nums
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        // Find lowest 1 bit
        int lowbit = 1;
        while ((x & lowbit) == 0) {
            lowbit <<= 1;
        }
        // Group into 2 groups
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}