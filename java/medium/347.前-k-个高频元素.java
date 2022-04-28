import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: 构建出现次数数组
        // Key:元素      Value:出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer occurs = map.get(nums[i]);
            System.out.println(occurs);
            if (occurs == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], occurs + 1);
            }
        }
        // map.forEach((key, value) -> {
        //     System.out.println(key + "->" + value);
        // });        

        // Step 2: 大顶堆，按照出现次数入堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[] {entry.getKey(), entry.getValue()});
        }
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     int num = entry.getKey();
        //     int count = entry.getValue();
        //     if (queue.size() == k) {
        //         if (queue.peek()[1] < count) {
        //             queue.poll();
        //             queue.offer(new int[]{num, count});
        //         }
        //     } else {
        //         queue.offer(new int[]{num, count});
        //     }
        // }

        // Step 3: 返回题意数组
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll()[0];
        }

        return ret;                

    }
}
// @lc code=end

