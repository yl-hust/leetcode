import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int j = 0; //窗口的右边界，左指针
        int i = 0; //窗口的左边界，右指针
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {//无重复
                set.add(s.charAt(j++));//窗口加宽
                max = Math.max(max, set.size());
            } else {//发现重复
                set.remove(s.charAt(i++));//窗口右移一位
            }
        }            
        return max;
    }
}
// @lc code=end

