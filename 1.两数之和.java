import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 用散列表记录已遍历的数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i]; //目标值减去当前值
            if (map.containsKey(x)){
                return new int[] {map.get(x), i};
            }
            map.put(nums[i], i);//记录到散列表
        }
        return new int[0]; 
    }
}
// @lc code=end

