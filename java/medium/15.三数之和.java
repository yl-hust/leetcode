import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//从小到大
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //枚举a
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;//重复数字，略过
            }
            int target = -nums[first];
            //由于数组已排序，所以可以用双指针找到所有b+c=-a的解
            int third = nums.length - 1;
            for(int second = first+1; second < third; second++){
                if (second > first+1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }
                //此时b+c<=target
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    //找到一组
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                } 
            }
        }
        return result;
    }
}
// @lc code=end

