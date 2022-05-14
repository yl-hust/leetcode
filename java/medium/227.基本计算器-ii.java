import java.util.Stack;

/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        // 先算乘除，将乘除后的结果压栈
        // +号前数字压栈，-号前数字取负后压栈
        // */号前栈顶元素出栈运算后结果压栈
        Stack<Integer> stack = new Stack<>();        
        int num = 0; // 操作符前的数字(可能多位)
        char preOp = '+'; // 数字前的操作符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            // 这里容易出bug：空格结尾的情况需要判断
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (preOp) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                preOp = c;
                num = 0;
            }

        }

        int ans = 0;
        while(!stack.isEmpty()) {
            ans +=stack.pop();
        }
        return ans;
    }
}
// @lc code=end

