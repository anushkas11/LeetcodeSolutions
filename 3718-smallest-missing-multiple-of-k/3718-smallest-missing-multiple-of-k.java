class Solution {
    public int missingMultiple(int[] nums, int k) {
      HashSet<Integer> set=new HashSet<>();
      for(int x:nums) set.add(x);

      int i=1;
      int ans=0;
      while(true){
        if(!set.contains(k*i)){
            ans=k*i;
            break;
        }
        else i++;
      }
      return ans;
    }
}