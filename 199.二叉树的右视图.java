import java.util.List;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();        
        dfs(view, root, 0);
        return view;     
    }

    private void dfs(List<Integer> list, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == list.size()) { // 一层只加一个元素，右子树优先
            list.add(node.val);
        }
        
        dfs(list, node.right, depth + 1);
        dfs(list, node.left, depth + 1);              
    }
}
// @lc code=end

