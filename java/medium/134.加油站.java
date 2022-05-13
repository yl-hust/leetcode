/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];            
        }
        if (sum < 0) { // 总消耗大于汽油量，肯定走不了一圈
            return -1;
        }
        // 到这里一定有解
        int start = 0;
        int gasRemain = 0;
        for (int i = 0; i < n; i++) {
            gasRemain += gas[i] - cost[i];
            if (gasRemain < 0) { // 走不通时，以下一个站点为起点
                gasRemain = 0;
                start = i + 1;
            }            
        }

        return start;

    }
}
// @lc code=end

