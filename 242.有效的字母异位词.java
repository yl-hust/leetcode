import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    // public boolean isAnagram(String s, String t) {
    //     HashMap<Character, Integer> hm1 = new HashMap<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         char charS = s.charAt(i);
    //         if (hm1.containsKey(charS)) {
    //             hm1.put(charS, hm1.get(charS) + 1);
    //         } else
    //             hm1.put(charS, 1);
    //     }
    //     HashMap<Character, Integer> hm2 = new HashMap<>();
    //     for (int i = 0; i < t.length(); i++) {
    //         char charT = t.charAt(i);
    //         if (hm2.containsKey(charT)) {
    //             hm2.put(charT, hm2.get(charT) + 1);
    //         } else {
    //             hm2.put(charT, 1);
    //         }

    //     }
    //     return hm1.equals(hm2);
    // }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int i : table) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
// @lc code=end
