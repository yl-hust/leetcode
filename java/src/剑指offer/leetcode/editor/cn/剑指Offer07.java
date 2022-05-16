package 剑指offer.leetcode.editor.cn;
//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 787 👎 0


// 重建二叉树
public class 剑指Offer07 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer07().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // preorder: 根 左 右 inorder: 左 根 右
        TreeNode root = new TreeNode(preorder[0]);
        // 找到根的左右子树,然后递归
        int size = preorder.length;
        // 左子树的size
        int leftSize = 0;
        for (int i = 0; i < size; i++) {
            if (inorder[i] == preorder[0]) {
                leftSize = i;
                break;
            }
        }
        // 右子树的size
        int rightSize = size - leftSize - 1;
        int[] leftPreorder = new int[leftSize];
        int[] leftInorder = new int[leftSize];
        int[] rightPreorder = new int[rightSize];
        int[] rightInorder = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftPreorder[i] = preorder[i + 1];
            leftInorder[i] = inorder[i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightPreorder[i] = preorder[i + leftSize + 1];
            rightInorder[i] = inorder[i + leftSize + 1];
        }

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}