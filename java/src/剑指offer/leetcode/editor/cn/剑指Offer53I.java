package 剑指offer.leetcode.editor.cn;
//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 317 👎 0


// 在排序数组中查找数字 I
public class 剑指Offer53I {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer53I().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == target && nums[right] == target) {
                break;
            }
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (nums[left] < target) {
                    left++;
                }
                if (nums[right] > target) {
                    right--;
                }
            }
        }
        return right - left + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}