package 剑指offer.leetcode.editor.cn;
//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 302 👎 0


import java.util.ArrayList;
import java.util.List;

// 二叉搜索树的第k大节点
public class 剑指Offer54 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer54().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
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
    int res, count;
    public int kthLargest(TreeNode root, int k) {
        // 右 根 左 遍历, 遍历到第K个元素终止返回结果
        this.count = k;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if (root == null || count == 0) return;
        dfs(root.right);
        if (--count == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}