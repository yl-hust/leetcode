import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {
    
    List<Integer> nums;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            int index = nums.size();
            nums.add(val);
            map.put(val, index);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            // 保持数组下标连续
            int lastVal = nums.get(nums.size() - 1);
            nums.set(index, lastVal);
            map.put(lastVal, index);
            nums.remove(nums.size() - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        int x = random.nextInt(nums.size());
        return nums.get(x);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

