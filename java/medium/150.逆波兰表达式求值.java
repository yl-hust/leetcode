import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch(token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                    default:
                }
            }            
        }
        return stack.pop();
    }

    private boolean isNumber(String s) {
        return !("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }
}
// @lc code=end

