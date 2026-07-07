class Solution {
    public long sumAndMultiply(int n) {
        int result=0 , mul=1 , sum=0;
        while(n>0){
            int d=n%10;
            if(d!=0){
                sum+=d;
                result=d*mul+result;
                mul*=10;

            }
            n/=10;
        }
        return (long)result*sum;
    }
}