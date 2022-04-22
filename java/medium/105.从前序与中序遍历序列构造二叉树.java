import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder: 根 左 右
        // inorder: 左 根 右
        int n = preorder.length;
        // 用map记录inorder的位置，快速定位根节点
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, 
                                               int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        // 找到根节点在inorder的位置
        int pIndex = map.get(rootVal);
        // 前序遍历：根         左    子    树          右    子    树
        //          pleft      pleft+1     x           x+1        pRight
        // 中序遍历：左    子    树         根          右    子    树
        //          ileft       pIndex-1   pIndex      pIndex+1   inRight
        // 递归左右子树
        int x = pIndex - inLeft + preLeft;
        root.left = buildTree(preorder, preLeft + 1, x, inLeft, pIndex - 1);
        root.right = buildTree(preorder, x + 1, preRight, pIndex + 1, inRight);

        return root;
    }
}
// @lc code=end

