class Solution {
    public int mirrorDistance(int n) {
        int n1=n;
        int rev=0;
        while(n1>0){
            rev=rev*10+(n1%10);
            n1=n1/10;
        }
        return Math.abs(rev-n);
    }
}