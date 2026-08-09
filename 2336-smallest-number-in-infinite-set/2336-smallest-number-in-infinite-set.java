class SmallestInfiniteSet {
    private int current = 1;
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private HashSet<Integer> set = new HashSet<>();

    public SmallestInfiniteSet() {
    }
    public int popSmallest() {
        // agr heap me current se chota available h
        if (!pq.isEmpty() && pq.peek() < current) {
            int smallest = pq.poll();
            set.remove(smallest);
            return smallest;
        }
        // wrna current remove krna h toh wo increase hoga 
        return current++;
    }

    public void addBack(int num) {
        // sirf wahi number add krna h jo pehle remove ho chuka h and wo humesha curr se chota hoga 
        if (num < current && !set.contains(num)) {

            pq.offer(num);
            set.add(num);
        }
    }
}