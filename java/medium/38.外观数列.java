/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            int start = 0;
            int pos = 0;
            StringBuilder sb = new StringBuilder();
            while (pos < ans.length()) {
                while (pos < ans.length() && ans.charAt(pos) == ans.charAt(start)) {
                    pos++;
                }
                sb.append("" + (pos - start)).append(ans.charAt(start));
                start = pos;
            }
            ans = sb.toString();
        }

        return ans;

    }
}
// @lc code=end

