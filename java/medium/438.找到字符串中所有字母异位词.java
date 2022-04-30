import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int size = p.length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i + size <= s.length()) {
                String x = s.substring(i, i + size);
                if (isAnagram(x, p)) {
                    res.add(i);
                }
            }
        }
        return res;    
    }

    /**
     * 242题
     * @param p
     * @param q
     * @return
     */
    private boolean isAnagram(String p, String q) {
        if (p.length() != q.length()) {
            return false;
        }
        int[] values = new int[26];
        for (int i = 0; i < p.length(); i++) {
            values[p.charAt(i) - 'a']++;
            values[q.charAt(i) - 'a']--;
        }
        for(int value : values) {
            if (value != 0) return false;
        }
        return true;
    }
}
// @lc code=end

