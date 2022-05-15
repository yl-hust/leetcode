import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        
        List<String> list = new ArrayList<>();
        for(int num : nums) {
            list.add(num + "");
        }
        
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String str1 = a + b;
                String str2 = b + a;
                return str2.compareTo(str1);
            }
        });

        StringBuilder res = new StringBuilder();
        for(String str : list) {
            res.append(str);
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();        
    }
}
// @lc code=end

