package 剑指offer.leetcode.editor.cn;
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false 
//
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
// Related Topics 字符串 
// 👍 342 👎 0


// 表示数值的字符串
public class 剑指Offer20 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer20().new Solution();
//        solution.isNumber(".1");
//        solution.isNumber("1 ");
//        solution.isNumber("     0");
        solution.isNumber("-1E-16");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        int i = 0;
        char first = s.charAt(i);
        if (first == '+' || first == '-') {
            i++;
        }
        boolean preDot = false;
        boolean preE = false;
        boolean seenDigit = false;
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c >= '0' && c <= '9') {
                // 数字
                seenDigit = true;
            } else if (c == '.') {
                if (preE || preDot) {
                    return false;
                }
                preDot = true;
            } else if (c == '+' || c == '-') {
                char preCh = s.charAt(j - 1);
                if (preCh != 'E' && preCh != 'e') {
                    return false;
                }
            } else if (c == 'E' || c == 'e') {
                if (preE || !seenDigit) {
                    return false;
                }
                preE = true;
                seenDigit = false; // in case 123e
            } else {
                return false;
            }
        }
        return seenDigit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}