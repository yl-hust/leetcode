/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return helper(root, targetSum) + 
               pathSum(root.left, targetSum) + 
               pathSum(root.right, targetSum);
    }

    private int helper(TreeNode root, int target) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == target) {
            res += 1;
        }

        res += helper(root.left,  target - root.val);
        res += helper(root.right, target - root.val);
        return res;
    }
}
// @lc code=end

