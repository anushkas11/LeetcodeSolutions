import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;
    List<Integer>[] graph;
    boolean[] vis;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        graph = new ArrayList[n + 1];
        vis = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        vis[1] = true;
        int depth = dfs(1);

        return (int) modPow(2, depth - 1);
    }

    private int dfs(int node) {

        int maxDepth = 0;

        for (int nei : graph[node]) {

            if (!vis[nei]) {
                vis[nei] = true;
                maxDepth = Math.max(maxDepth, 1 + dfs(nei));
            }
        }

        return maxDepth;
    }

    private long modPow(long base, long exp) {

        long res = 1;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}