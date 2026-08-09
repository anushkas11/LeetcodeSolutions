class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }

        //nums2 ke basis par sort krna h
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0;
        long answer = 0;

        for (int[] pair : pairs) {

            int num2 = pair[0];
            int num1 = pair[1];
            pq.offer(num1);
            sum += num1;

            // sirf k largest elements rkhne h islie mallest wala hta diya size bdhne par 
            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                long score = sum * num2;
                answer = Math.max(answer, score);
            }
        }

        return answer;
    }
}