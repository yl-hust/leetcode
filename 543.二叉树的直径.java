/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        // 左右子树的深度
        int L = dfs(root.left);
        int R = dfs(root.right);

        // 记录最大路径
        ans = Math.max(ans, L + R + 1);

        // 返回当前节点为根的子树的深度
        return Math.max(L, R) + 1;
    }
}
// @lc code=end

