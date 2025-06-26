import java.util.Queue;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric1(TreeNode root) {
        // DFS
        if (root == null) return true;
        return dfs(root.left, root.right);
    }
    boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        System.out.println("Left:" + left.val);
        System.out.println("Right:" + right.val);
        if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
    // BFS迭代法
    public boolean isSymmetric(TreeNode root) {        
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            // System.out.println("Left is:" + left.val);
            // System.out.println("Right is:" + right.val);
            if (left == null && right == null) {                
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            // now neither left nor right is null
            if (left.val != right.val) {
                return false;
            }

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);            
        }
        return true;
    }

    // DFS递归解法
    // public boolean isSymmetric(TreeNode root) {
    //     if (root == null) return true;
    //     return dfs(root.left, root.right);
    // }

    // boolean dfs(TreeNode left, TreeNode right) {
    //     if (left == null && right == null) {
    //         return true;
    //     }
    //     if (left == null || right == null) {
    //         return false;
    //     }
    //     if (left.val != right.val) {
    //         return false;
    //     }
    //     return dfs(left.left, right.right) 
    //         && dfs(left.right, right.left);
    // }
}
// @lc code=end

