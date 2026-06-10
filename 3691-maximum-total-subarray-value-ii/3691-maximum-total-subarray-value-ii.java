import java.util.*;

class Solution {

    class Node {
        int l, r;
        long val;

        Node(int l, int r, long val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }

    int[][] stMax;
    int[][] stMin;
    int[] log;

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        buildSparseTables(nums);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(l, n - 1, value(l, n - 1)));
        }

        long ans = 0;

        while (k-- > 0) {

            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(cur.l, nr, value(cur.l, nr)));
            }
        }

        return ans;
    }

    private void buildSparseTables(int[] nums) {

        int n = nums.length;

        log = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;

        stMax = new int[K][n];
        stMin = new int[K][n];

        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {

            for (int i = 0; i + (1 << j) <= n; i++) {

                stMax[j][i] =
                        Math.max(stMax[j - 1][i],
                                 stMax[j - 1][i + (1 << (j - 1))]);

                stMin[j][i] =
                        Math.min(stMin[j - 1][i],
                                 stMin[j - 1][i + (1 << (j - 1))]);
            }
        }
    }

    private long value(int l, int r) {

        int len = r - l + 1;
        int j = log[len];

        int mx = Math.max(
                stMax[j][l],
                stMax[j][r - (1 << j) + 1]
        );

        int mn = Math.min(
                stMin[j][l],
                stMin[j][r - (1 << j) + 1]
        );

        return (long) mx - mn;
    }
}