package 剑指offer.leetcode.editor.cn;
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 231 👎 0


// 第一个只出现一次的字符
public class 剑指Offer50 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer50().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        int[] chars = new int[26];
        for(char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (chars[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}