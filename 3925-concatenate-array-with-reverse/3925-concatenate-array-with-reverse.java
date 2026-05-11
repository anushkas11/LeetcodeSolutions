class Solution {
    public int[] concatWithReverse(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        int ans[]=new int[2*nums.length];
        int i=0;
        for(int x:nums){
            list.add(x);
            ans[i++]=x;
            
        } 
        Collections.reverse(list);
        for(int x:list) ans[i++]=x;
        return ans;
        
        
    }
}