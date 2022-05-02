import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int ans = 0, index = 0;
        // 单调递减栈，栈顶记录可能的存水点
        Deque<Integer> queue = new LinkedList<>();
        while (index < height.length) {
            while (!queue.isEmpty() && height[index] > height[queue.peek()]) {
                int top = queue.pop(); // 存水点出栈
                System.out.println("出栈" + top);
                if (queue.isEmpty()) { // 判断有左边界，queue.peek()有意义
                    break;
                }
                int left_bound = queue.peek(); // 左边界位置
                int width = index - left_bound - 1; // 存水的宽度
                int gao = Math.min(height[index], height[left_bound]) - height[top];
                ans += gao * width;
            }
            queue.push(index); // 记录单调下降过程
            System.out.println("入栈：" + index);
            index++;
        }
        return ans;
    }
}
// @lc code=end

