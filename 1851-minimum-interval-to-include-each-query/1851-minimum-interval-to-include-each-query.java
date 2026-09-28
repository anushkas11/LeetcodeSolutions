class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int q = queries.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] sortedQueries = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[q];
        int i = 0; 
        for (int[] query : sortedQueries) {
            int qVal = query[0];
            int qIdx = query[1];

            while (i < n && intervals[i][0] <= qVal) {
                int len = intervals[i][1] - intervals[i][0] + 1;
                minHeap.offer(new int[]{len, intervals[i][1]});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < qVal) {
                minHeap.poll();
            }

            ans[qIdx] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return ans;
    }
}