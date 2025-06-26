/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            // case 'aba'
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int windowLen = right - left + 1;
                if (windowLen > maxLen) {
                    maxLen = windowLen;
                    startIndex = left;
                }
                left--;
                right++;
            };
            // case 'abba'
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    startIndex = left;
                }
                left--;
                right++;
            }            
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }        

        // dp[i][j]表示s[i..j]是否为回文串
        boolean dp[][] = new boolean[len][len];
        // base case: 长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;

        // dp转移方程如下：如果s为回文子串，那么xsx也是回文子串
        // dp[i][j] = dp[i+1][j-1] && s[i]==s[j]
        // 开始递推，外层从j=1开始
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[j] != charArray[i]) {
                    dp[i][j] = false;
                } else {
                    if (j-i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }                
            }
        }

        return s.substring(begin, begin + maxLen);

    }
}
// @lc code=end

