import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <=0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n-k+1]; //返回的数组
        Deque<Integer> q = new ArrayDeque<>(); //记录数组的index
        int j = 0;
        for (int i = 0; i < n; i++) {
            // 移除划出窗口的元素
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.pollFirst();
            }
            // 入队整理，移除所有比自己小的
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i); //记录数组的下标
            if (i >= k - 1) {
                res[j++] = nums[q.peek()];
            }            
        }
        return res;
    }
}
// @lc code=end

