package 剑指offer.leetcode.editor.cn;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 517 👎 0


// 二叉搜索树的后序遍历序列
public class 剑指Offer33 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer33().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // left right root BST left < root < right
        // 任意子树[i,j]，划分左子树[i,m-1] 右子树[m, j-1], j为根
        // 判定[i,m-1] < j < [m, j-1]
        return dfs(postorder, 0, postorder.length - 1);
    }
    private boolean dfs(int[] tree, int start, int end) {
        if (start >= end) return true;
        int p = start;
        while (tree[p] < tree[end]) p++;
        int m = p;
        while (tree[p] > tree[end]) p++;
        return p == end && dfs(tree, start, m - 1) && dfs(tree, m, end - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}