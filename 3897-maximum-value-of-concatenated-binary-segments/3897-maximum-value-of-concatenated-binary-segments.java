class Solution {
    int MOD = 1_000_000_007;

    public int maxValue(int[] nums1, int[] nums0) {
        //lets make a double array storing zeros and ones 
        int n = nums0.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums0[i];
        }
        long ans = 0;
        long total=0;
        for(int i=0;i<n;i++)
            {
                total=total+nums1[i]+nums0[i];
            }
        long[] pow = new long[(int)total + 1];
        pow[0] = 1;
        for (int i = 1; i <= total; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        Arrays.sort(arr,(a,b)->{
            String A=("1".repeat(a[0]))+("0".repeat((a[1])));
            String B=("1".repeat(b[0]))+("0".repeat((b[1])));

            return (B+A).compareTo(A+B);
        });

        
        for (int[] part : arr) {
            int one = part[0];
            int zero = part[1];

            int length=one+zero;

            ans=((ans*pow[length])%MOD);

            long add=(pow[one]-1 +MOD)%MOD;
            add=(add*pow[zero])%MOD;

            ans=(ans+add)%MOD;
        }
        return (int)ans;
    }
}