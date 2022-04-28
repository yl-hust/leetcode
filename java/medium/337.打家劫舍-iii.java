/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    public int rob(TreeNode root) {
        // 树形dp，二元数组
        // res[0] 抢抢当前节点的最大值
        // res[1] 不抢劫当前节点的最大值
        int[] res = dp(root);

        return Math.max(res[0], res[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        // case 1：抢当前节点，放弃子节点
        int rob = root.val + left[1] + right[1];
        // case 2: 不抢劫当前节点，子节点可抢可不抢
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, not_rob};
    }
}
// @lc code=end

