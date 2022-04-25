import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 原地哈希
        int len = nums.length;
        int index = 0;
        while (index < len) {
            if (nums[index] == index + 1) {
                index++;
            } else {
                int targetIndex = nums[index] - 1;
                if (nums[targetIndex] == nums[index]) {
                    index++;
                    continue;
                }
                // 和正确位置上的元素交换
                int tmp = nums[targetIndex];
                nums[targetIndex] = nums[index];
                nums[index] = tmp;
            }
        }
        List<Integer> result = new ArrayList<>();
        // 遍历，不在位置上的加入结果集
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }        

        return result;

    }
}
// @lc code=end

