class Solution {
    public long pickGifts(int[] gifts, int k) {
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int gift:gifts){
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            int max = pq.poll();
            pq.offer((int) Math.sqrt(max));
        }

        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}