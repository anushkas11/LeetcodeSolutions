class Solution {
    public long maxWeight(int[] pizzas) {
        int n=pizzas.length;
        Arrays.sort(pizzas);
        long ans=0;
        int days=n/4;
        int odd=(days+1)/2;
        int even=days-odd;
        int idx=n-1;
        while(odd>0){
            ans+=pizzas[idx];
            idx--;
            odd--;
        }
        idx--;
        while(even>0){
            ans+=pizzas[idx];
            idx-=2;
            even--;
        }
        return ans;
    }
}