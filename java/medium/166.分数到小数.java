import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if (a % b == 0) return String.valueOf(a/b);
        StringBuilder sb = new StringBuilder();
        if (a * b < 0) sb.append("-");
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        sb.append(a/b + ".");
        // 得到余数
        a = a % b;
        // 记录出现过的余数，用来判定循环节
        Map<Long, Integer> map = new HashMap<>();
        // 长除法，每次余数 * 10
        while (a != 0) {
            // 记录余数的位置
            map.put(a, sb.length());
            a *= 10;
            sb.append(a/b);
            a = a % b;
            // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }
}
// @lc code=end

