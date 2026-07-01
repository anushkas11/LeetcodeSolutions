class Solution {
    public boolean checkGoodInteger(int n) {
        int sum=0,squaresum=0;
        while(n>0){
            int d=n%10;
            sum+=d;
            squaresum+=(d*d);
            n=n/10;
        }
        if(squaresum-sum>=50) return true;
        else return false;
    }
}