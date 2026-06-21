class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        if(costs[0]>coins) return 0;
        int count=0;
        for(int i=0;i<costs.length;i++){
            if(costs[i]<=coins){
                count++;
                coins-=costs[i];
            }
        }
        return count;
    }
}