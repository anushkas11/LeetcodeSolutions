class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]>0  && !visited[i][j]) {
                    long islandSum = dfs(i, j, grid, visited, n, m);
                    if (islandSum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public long dfs(int r, int c, int[][] grid, boolean[][] visited, int n, int m) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        long currentsum=grid[r][c];
        currentsum+= dfs(r, c - 1, grid, visited, n, m);
        currentsum+= dfs(r, c + 1, grid, visited, n, m);
        currentsum+= dfs(r - 1, c, grid, visited, n, m);
        currentsum+= dfs(r + 1, c, grid, visited, n, m);
        return currentsum;
    }
} 