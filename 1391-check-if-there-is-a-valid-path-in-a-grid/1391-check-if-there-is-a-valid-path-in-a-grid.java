import java.util.*;

class Solution {

    int m, n;

    public boolean hasValidPath(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Map<Integer, int[][]> directions = new HashMap<>();
        directions.put(1, new int[][]{{0, -1}, {0, 1}});
        directions.put(2, new int[][]{{-1, 0}, {1, 0}});
        directions.put(3, new int[][]{{0, -1}, {1, 0}});
        directions.put(4, new int[][]{{0, 1}, {1, 0}});
        directions.put(5, new int[][]{{0, -1}, {-1, 0}});
        directions.put(6, new int[][]{{0, 1}, {-1, 0}});

        return dfs(0, 0, grid, visited, directions);
    }

    private boolean dfs(int i, int j, int[][] grid, boolean[][] visited,
                        Map<Integer, int[][]> directions) {

        if (i == m - 1 && j == n - 1) return true;

        visited[i][j] = true;

        for (int[] dir : directions.get(grid[i][j])) {

            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {

                for (int[] back : directions.get(grid[ni][nj])) {

                    if (ni + back[0] == i && nj + back[1] == j) {

                        if (dfs(ni, nj, grid, visited, directions)) return true;
                    }
                }
            }
        }

        return false;
    }
}