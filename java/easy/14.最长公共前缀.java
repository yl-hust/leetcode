/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {       
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String ans = "";
        //遍历每一列
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //i是列号，要先判断字符串长度避免越界
                if (strs[j].length() == i || c != strs[j].charAt(i)) {
                    return ans;
                }
            }
            ans += c;                       
        }
        return ans;
    }
}
// @lc code=end

