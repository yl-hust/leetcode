import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    // 将大问题分解为规模小一点的子问题：
    // 前i个字符的子串，能否分解成单词
    // 剩余子串[i+1, length]，是否为单个单词。
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // dp[i]：长度为i的s[0:i-1]子串是否能拆分成单词
        boolean[] dp = new boolean[s.length() + 1];
        // base case
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 用指针j来划分s[0:i]子串
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }        
        return dp[s.length()];
    }
}
// @lc code=end

