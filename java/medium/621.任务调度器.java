/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        /** 贪心算法
         * 找到出现次数最多的任务类型，假设为A，将其他
         * 任务安排在AA之间，就是最短时间
         * shortest = (maxFreq - 1) * (n + 1) + remain
         */
        int maxFreq = 0;
        int[] task = new int[26];
        for (char ch: tasks) {
            task[ch - 'A']++;
            maxFreq = Math.max(maxFreq, task[ch - 'A']);
        }
        int res = (maxFreq - 1) * (n + 1);
        int maxCount = 0; // 出现次数最多的任务的个数
        for (int x : task) {
            if (x == maxFreq) {
                maxCount++;
            }
        }
        res += maxCount;
        return Math.max(tasks.length, res);
    }
}
// @lc code=end

