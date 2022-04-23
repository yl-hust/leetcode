/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    // in place O(1) 解法 
    // Key: 左子树找到最后一个右节点, 做为右子树的前驱节点
    public void flatten(TreeNode root) {
        // 根节点 左子树 右子树
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                // 缓存左节点
                TreeNode leftNode = cur.left;
                // 找到左子树的最后一个右节点
                TreeNode lastRight = leftNode;
                while (lastRight.right != null) {
                    lastRight = lastRight.right;
                }
                // 设置成右子树的父节点
                lastRight.right = cur.right;
                // 左节点置null
                cur.left = null;
                // 右节点置为左节点
                cur.right = leftNode;
            }
            // 迭代
            cur = cur.right;
        }
    }
}
// @lc code=end

