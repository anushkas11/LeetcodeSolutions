class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{entrance[0], entrance[1]});
        visited[entrance[0]][entrance[1]] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                if ((row == 0 || row == m - 1 || col == 0 || col == n - 1)
                        && !(row == entrance[0] && col == entrance[1])) {

                    return steps;
                }

                for (int j = 0; j < 4; j++) {

                    int newRow = row + dr[j];
                    int newCol = col + dc[j];

                    if (newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        maze[newRow][newCol] == '.' &&
                        !visited[newRow][newCol]) {

                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}