/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        // sliding window
        // 先滑动右边界找到满足题意的解，再滑动左边界找到最优解
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        int[] tFreq = new int[128]; // 出现频次数组
        for(char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int distance = tLen; // 滑动窗口中还差多少个t中的字符
        int minLen = sLen + 1;
        String res = "";
        int left = 0, right = 0;
        while (right < sLen) { // 先滑动右边界
            char charRight = s.charAt(right);
            if (tFreq[charRight] > 0) { // 字符匹配
                distance--;
            }
            tFreq[charRight]--; // 保证非t的字符都是-1
            right++;
            while (distance == 0) { // 满足题意，开始滑动左边界
                if (right - left < minLen) {
                    minLen = right - left;
                    res = s.substring(left, right);
                }
                char charLeft = s.charAt(left);
                if (tFreq[charLeft] == 0) { // 找到了左边界
                    distance++;
                }
                tFreq[charLeft]++;
                left++;
            }
        }
        return res;
    }
}
// @lc code=end

