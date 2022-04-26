/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int m, n;
    boolean[][] visited; // 访问过的陆地
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (grid[i][j] == '1' && !visited[i][j]) {
                   dfs(grid, i, j); // 四周染色
                   count++;
               } 
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n 
           || grid[i][j] != '1' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(grid, i - 1, j);// 上
        dfs(grid, i + 1, j);// 下
        dfs(grid, i, j - 1);// 左
        dfs(grid, i, j + 1);// 右
    }
}
// @lc code=end

