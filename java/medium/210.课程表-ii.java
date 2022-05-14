import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        
        // 入度数组
        int[] indegree = new int[numCourses];
        // 建立入度表
        for (int[] p: prerequisites) {
            indegree[p[0]]++;            
        }

        // 入度为0的入队
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] solution = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            solution[index++] = course;
            for(int[] p : prerequisites) { // p[1]是先修课
                if (p[1] == course) {
                    indegree[p[0]]--; // 由于先修课学了，所以更新入度
                    if(indegree[p[0]] == 0) {
                        q.offer(p[0]);
                    }
                }
            }
        }

        if (index == numCourses) return solution;
        return new int[0];
        
    }
}
// @lc code=end

