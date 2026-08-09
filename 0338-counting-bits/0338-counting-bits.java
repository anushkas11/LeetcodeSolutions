class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        for(int i=0;i<=n;i++) ans[i]=count(i);
        return ans;
    }
    public int count(int n){
        int c=0;
        while (n > 0) {
           if(n%2==1) c++;
           n = n / 2;
        }
        return c;
    }
}