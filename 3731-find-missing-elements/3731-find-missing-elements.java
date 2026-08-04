class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int max=0,min=Integer.MAX_VALUE;
        for(int x:nums){
            set.add(x);
            max=Math.max(max,x);
            min=Math.min(min,x);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;

    }
}