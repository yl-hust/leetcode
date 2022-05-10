import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // 用一个int数组[值,i,j]记录元素和坐标
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        // 第一列入堆，最小的一批值
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{matrix[i][0], i, 0});
        }

        // 迭代k-1次（从堆中弹出k-1个最小值）
        for (int i = 0; i < k - 1; i++) {
            // 弹出当前的最小值
            int[] now = queue.poll();
            // 将最小值右侧[i，j+1]的元素入堆
            if (now[2] != n - 1) {
                int x = now[1];
                int y = now[2] + 1;
                queue.add(new int[]{matrix[x][y], x, y});
            }
        }

        return queue.poll()[0];
    }
}
// @lc code=end

