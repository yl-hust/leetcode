import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    /**
     * 用一个栈存放列表
     */
    private Stack<NestedInteger> stack; 

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        // 列表元素逆序入栈，并不展开
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }        
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();        
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger x = stack.peek();
            if (x.isInteger()) {
                return true;
            } else {
                // 扁平化
                stack.pop();
                List<NestedInteger> list = x.getList();
                // 展开后逆序放回栈中
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));                    
                }
            }
        }
        return false;        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

