/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        // 统计字符出现的次数
        int[] map = new int[26];
        for(char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 找到不符合条件的字符，二分
            if (map[ch - 'a'] != 0 && map[ch - 'a'] < k) {
                String part1 = s.substring(0, i);
                String part2 = s.substring(i + 1);
                res = Math.max(longestSubstring(part1, k), longestSubstring(part2, k));
                return res;
            }
        }
        return s.length();
    }
}
// @lc code=end

