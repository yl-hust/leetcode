package 剑指offer.leetcode.editor.cn;
//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 
// 👍 257 👎 0


// 数字序列中某一位的数字
public class 剑指Offer44 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer44().new Solution();
        solution.findNthDigit(Integer.MAX_VALUE); // 2,147,483,647
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        // num      位数   数字数量   数位数量
        // 1 ~ 9     1      9       9
        // 10 ~ 99   2      90      180
        // 100 ~999  3      900     2700
        // start~end digit  9*start digit*9*start
        // start = start * 10 digit = digit + 1 count=9*digit*start
        // 确定位数digit，确定数字num，确定数位ans
        int digit = 1;
        int start = 1;
        long count = 9;
        // e.g. input 490
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = (long)digit * start * 9;
        }
        // 490 - 9 - 180 = 301, num = 100 + 301/3 = 200
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}