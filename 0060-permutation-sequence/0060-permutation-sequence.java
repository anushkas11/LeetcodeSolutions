class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums=new ArrayList<>();
        for(int i=1;i<=n;i++) nums.add(i);
        int fact=1;
        for( int i=1;i<n;i++) fact*=i;
        k--;
        StringBuilder ans=new StringBuilder();
        for(int rem=n;rem>=1;rem--){
            int idx=k/fact;
            ans.append(nums.get(idx));
            nums.remove(idx);
            if(rem>1){
                k=k%fact;
                fact=fact/(rem-1);
            }
        }
        return ans.toString();
    }
}