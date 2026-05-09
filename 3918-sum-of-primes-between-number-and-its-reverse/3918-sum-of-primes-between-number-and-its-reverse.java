class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev=0,num=n;
        while(num>0){
            int d=num%10;
            rev=rev*10+d;
            num=num/10;
        }
        int l=Math.min(n,rev);
        int r=Math.max(n,rev);
        int sum=0;

        for(int i=l;i<=r;i++){
            if(isPrime(i)) sum+=i;
        }
        return sum;
    }
    public boolean isPrime(int n) {

        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}