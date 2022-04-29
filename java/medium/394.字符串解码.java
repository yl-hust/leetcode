import java.util.Stack;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                // 重复次数k可能不止一位
                StringBuilder num = new StringBuilder();                
                while (Character.isDigit(s.charAt(index))) {
                    num.append(s.charAt(index++));
                }
                stack.push(num.toString());
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                // Get letters
                while (!stack.peek().equals("[")) {
                    sb.append(stack.pop());
                }
                sb.reverse();
                stack.pop(); // This should be "[", ignore
                int repeat = Integer.parseInt(stack.pop());
                StringBuilder t = new StringBuilder();
                for (int i = 0; i < repeat; i++) {
                    t.append(sb);
                }
                // stack.push(t.toString()); // 不能直接进栈，会出顺序问题
                String subString = t.toString();
                for (char item : subString.toCharArray()) {
                    stack.push(String.valueOf(item));                    
                }
                index++;
            } else {
                stack.push(String.valueOf(c));
                index++;
            }
        }
        // 遍历栈返回
        StringBuilder res = new StringBuilder();
        for (String str : stack) {
            res.append(str);
        }
        return res.toString();
    }
}
// @lc code=end

