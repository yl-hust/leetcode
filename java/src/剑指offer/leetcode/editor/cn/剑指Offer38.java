package 剑指offer.leetcode.editor.cn;
//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 
// 👍 563 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 字符串的排列
public class 剑指Offer38 {
    public static void main(String[] args) {
        Solution solution = new 剑指Offer38().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res;
    public String[] permutation(String s) {
        res = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        backtrack(arr, used, sb);
        return res.toArray(new String[res.size()]);
    }

    private void backtrack(char[] arr, boolean[] used, StringBuilder sb) {
        if (sb.length() == arr.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            if (i > 0 && arr[i] == arr[i - 1] && used[i - 1] == false){
                continue;
            }
            // 同树枝未使用过
            if (!used[i]) {
                used[i] = true;
                sb.append(arr[i]);
                backtrack(arr, used, sb);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}