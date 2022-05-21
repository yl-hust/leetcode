package 剑指offer.leetcode.editor.cn;
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 
// 👍 535 👎 0


// 连续子数组的最大和
public class 剑指Offer42 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer42().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // If pre > 0, add to current num, then update max if pre > max
        int max = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = pre > 0 ? num + pre : num;
            max = Math.max(max, pre);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}