import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        //  num ：出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                int count = map.get(num);
                if (count > 1) {
                    map.put(num, count - 1);
                } else {
                    map.remove(num);
                }
            }                      
        }
        
        int[] ans = new int[list.size()]; 
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);            
        }
        return ans;
        // return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

