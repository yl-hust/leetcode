import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 本质上是有向图检测是否有环
        // 入度方法BFS，前置课程（入度）为0的课程可以学
        
        // 邻接表，目的是能从先修课程找到后继课程
        List<List<Integer>> edegs = new ArrayList<>(); 
        for (int i = 0; i < numCourses; i++) {
            edegs.add(new ArrayList<>());
        }
        // 每门课的入度 e.g. indegree[0] = 2; 第0门课入度为2（2门先修课）
        int[] indegrees = new int[numCourses];
        for (int[] info : prerequisites) {
            edegs.get(info[1]).add(info[0]);
            indegrees[info[0]] += 1;             
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) { // 先修课完成（入度为0）的课程入栈
                queue.add(i);
            }
        }

        int count = 0; // 记录已修课程
        while(!queue.isEmpty()) {
            count++;
            int course_start = queue.poll(); // 修课程
            for (int course_pending : edegs.get(course_start)) {
                indegrees[course_pending] -= 1;
                if (indegrees[course_pending] == 0) { // 入度为0 可以修
                    queue.add(course_pending);
                }
            }
        }

        return count == numCourses;
    }
}
// @lc code=end

