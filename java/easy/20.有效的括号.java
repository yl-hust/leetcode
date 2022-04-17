import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    private HashMap<Character, Character> mappings = new HashMap<>();

    public Solution() {
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (mappings.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != mappings.get(c))
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
