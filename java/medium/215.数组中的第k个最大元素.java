import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else if (nums[i] > queue.peek()) {
                // 有更大的元素，入堆
                queue.remove();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}
// @lc code=end

