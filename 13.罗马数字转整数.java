import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    // public int romanToInt(String s) {
    //     int num = 0;
    //     char prev_char = '0';
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         switch (c) {
    //             case 'M':
    //                 if (prev_char == 'C') {
    //                     num -= 200;                        
    //                 }
    //                 num += 1000;
    //                 break;
    //             case 'D':
    //                 if (prev_char == 'C') {
    //                     num -= 200;
    //                 }
    //                 num += 500;
    //                 break;
    //             case 'C':
    //                 if (prev_char == 'X') {
    //                     num -= 20;
    //                 } 
    //                 num += 100;
    //                 break;
    //             case 'L':
    //                 if (prev_char == 'X') {
    //                     num -= 20;
    //                 } 
    //                 num += 50;
    //                 break;
    //             case 'X':
    //                 if (prev_char == 'I') {
    //                     num -= 2;
    //                 }
    //                 num += 10;
    //                 break;
    //             case 'V':
    //                 if (prev_char == 'I') {
    //                     num -= 2;
    //                 }
    //                 num += 5;
    //                 break;
    //             case 'I':
    //                 num += 1;
    //                 break;
    //             default:
    //                 break;
    //         }
    //         prev_char = c;
    //     }
    //     return num;
    // }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int preVal = 10000;//前值
        int res = 0;
        for (char c : s.toCharArray()) {
            int v = map.get(c).intValue();
            if (v > preVal) {//6种特殊情况：大数字在右边，特殊处理
                res = res - 2 * preVal;
            }
            res += v;
            preVal = v;
        }
        return res;
    }
}
// @lc code=end