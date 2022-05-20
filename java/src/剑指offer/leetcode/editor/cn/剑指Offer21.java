package 剑指offer.leetcode.editor.cn;
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 
// 👍 227 👎 0


// 调整数组顺序使奇数位于偶数前面
public class 剑指Offer21 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer21().new Solution();
        solution.exchange(new int[]{1, 3, 5});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        // in place exchange
        int i = 0, j = nums.length - 1;
        // case [1,3,5] failed
        while (i < j) {
            // find first even
            if ((nums[i] & 1) == 1) {
                i++;
                continue;
            }
            // find last odd
            if ((nums[j] & 1) == 0) {
                j--;
                continue;
            }
            // here is the case: even + odd, exchange
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}