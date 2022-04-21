import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        // 先排序
        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {                
                return o1[0] - o2[0];
            }
        });

        List<int[]> path = new ArrayList<>();
        int left = 0, right = 0; // 双指针，右指针滑动
        while (right < intervals.length) {
            int leftBound = intervals[left][0];
            int rightBound = intervals[right][1];
            // 不停的向右探查，找到边界为止，所以要用while而不是if
            while (right < intervals.length && rightBound >= intervals[right][0]) {
                // [1,3] [2,8] [3,6] =>[1,8]
                rightBound = Math.max(intervals[right][1], rightBound);
                right++;
            }
            path.add(new int[]{leftBound, rightBound});
            left = right;
        }
        // 按照题目要求格式输出
        int[][] res = new int[path.size()][2];
        for (int i = 0; i < path.size(); i++) {
            res[i][0] = path.get(i)[0];
            res[i][1] = path.get(i)[1];
        }
        return res;
    }
}
// @lc code=end

