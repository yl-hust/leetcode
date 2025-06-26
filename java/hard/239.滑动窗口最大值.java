import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int j = 0;        
        for (int i = 0; i < n; i++) {
            // remove element out of the window
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) {   
                q.pollFirst();
            }
            // clean smaller element from the queue
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                res[j++] = nums[q.peekFirst()]; 
            }            
        }
        return res;
    }
}
// @lc code=end

