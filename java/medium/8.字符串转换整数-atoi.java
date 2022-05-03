/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {        
        boolean negative = false;
        int ans = 0;
        int i = 0;
        // 处理开头的空格
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) return 0;
        
        // 处理符号位
        char c = s.charAt(i);
        if (c == '+') {
            i++;
        } else if (c == '-') {
            negative = true;
            i++;                               
        }
        while(i < s.length()) {
            char ch = s.charAt(i++);
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                // 判断是否越界
                if (ans > Integer.MAX_VALUE / 10 || 
                    (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10 + digit;               
            } else { // 非数字，跳出
                break;                
            }
        }
        return negative ? -ans : ans;
    }
}
// @lc code=end

