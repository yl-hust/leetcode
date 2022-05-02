/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        // 暴力解法
        if (needle.length() == 0) return 0;
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            int a = i; // 原串匹配起始位置，尝试匹配
            int b = 0; // 匹配长度
            while (b < n && haystack.charAt(a) == needle.charAt(b)) {
                a++;
                b++;
            }
            if (b == n) return i;            
        }
        return -1;
    }
}
// @lc code=end

