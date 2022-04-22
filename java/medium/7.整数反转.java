/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    // public int reverse(int x) {
    //     if (x == 0 || x == Integer.MIN_VALUE) {
    //         return 0;
    //     }
    //     String str = Integer.toString(Math.abs(x));
    //     char[] array = str.toCharArray();
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = array.length - 1; i >= 0; i--) {
    //         sb.append(array[i]);
    //     }
    //     try {
    //         int ret = Integer.parseInt(sb.toString());
    //         return x > 0 ? ret: -ret;            
    //     } catch (NumberFormatException e) {
    //         return 0;
    //     }        
    // }

    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (ret > Integer.MAX_VALUE/10 || ret < Integer.MIN_VALUE/10) {
                return 0;
            }
            ret = ret * 10 + pop;
        }
        return ret;
    }
}
// @lc code=end

