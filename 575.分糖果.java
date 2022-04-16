import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candies) {
        // 糖果的种类数量
        int eachCount = candies.length / 2;        
        Set<Integer> set = new HashSet<>();
        for (int i : candies) {
            set.add(i);
        }
        int classCount = set.size();
        return classCount > eachCount ? eachCount : classCount; 

    }
}
// @lc code=end

