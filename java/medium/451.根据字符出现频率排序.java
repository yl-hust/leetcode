/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        List<Character> keys = new ArrayList<>(freqMap.keySet());

        Collections.sort(keys, (k1, k2) -> (freqMap.get(k2) - freqMap.get(k1)));

        StringBuilder sb = new StringBuilder();
        for (char key: keys) {
            for (int i = 0; i < freqMap.get(key); i++) {
                sb.append(key);
            }
        }

        return sb.toString();                        
    }
}
// @lc code=end

