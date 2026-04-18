class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int x:nums) set.add(x);
        int k=1;
        while(true){
            if(!set.contains(k)) return k;
            k++;
        }
    }
}