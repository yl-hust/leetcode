import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = i + 1;
            if (x % 15 == 0) {
                res.add("FizzBuzz");
            } else if (x % 3 == 0) {
                res.add("Fizz");
            } else if (x % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add("" + x);
            }
        }
        return res;
    }
}
// @lc code=end

