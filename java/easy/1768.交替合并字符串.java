/*
 * @lc app=leetcode.cn id=1768 lang=java
 *
 * [1768] 交替合并字符串
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p = 0;
        StringBuilder sb = new StringBuilder();
        while (p < word1.length() || p < word2.length()) {
            if (p < word1.length()) {
                sb.append(word1.charAt(p));
            }
            if (p < word2.length()) {
                sb.append(word2.charAt(p));
            }            
            p++;            
        }
        return sb.toString();        
    }
}
// @lc code=end

