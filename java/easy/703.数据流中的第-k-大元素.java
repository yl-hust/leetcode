/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第 K 大元素
 */

// @lc code=start

import java.util.PriorityQueue;

class KthLargest {
    private int k;
    private PriorityQueue<Integer> q;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (q.size() < k) {
            q.add(val);
        } else if (val > q.peek()) {
            q.poll();
            q.add(val);
        }
        return q.peek();        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

