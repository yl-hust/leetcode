package 剑指offer.leetcode.editor.cn;
//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 
// 👍 232 👎 0


// 构建乘积数组
public class 剑指Offer66 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer66().new Solution();
        solution.constructArr(new int[]{7, 2, 2, 4, 2, 1, 8, 8, 9, 6, 8, 9, 6, 3, 2, 1});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        // result = 前缀积 * 后缀积
        int[] prefix = new int[a.length];
        prefix[0] = 1;
        for (int i = 1; i < a.length; i++) {
            prefix[i] = prefix[i - 1] * a[i - 1];
        }
        int[] post = new int[a.length];
        post[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0 ; i--) {
            post[i] = post[i + 1] * a[i + 1];
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = prefix[i] * post[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}