import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    //BFS迭代法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();

        if (root == null) return answer;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>(); //同一层节点数组
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();//出队列
                level.add(node.val);
                if (node.left != null) {
                    q.add(node.left);//入队
                }
                if (node.right != null) {
                    q.add(node.right);//入队
                }
            }
            answer.add(level);
        }
        return answer;
    }

    // DFS递归法
    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if (root == null) return levels;
        dfs(root, 0);
        return levels;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }

        levels.get(level).add(node.val);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
// @lc code=end

