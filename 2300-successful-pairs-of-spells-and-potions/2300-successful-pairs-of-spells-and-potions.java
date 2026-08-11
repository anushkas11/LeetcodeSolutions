class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int ans[]=new int[spells.length];
        int n=potions.length;
        Arrays.sort(potions);

        for(int i=0;i<spells.length;i++){
            ans[i]=n-check(spells[i],potions,success);
        }
        return ans;
    }
    public int check(int spell,int potions[], long success){
        int low=0,high=potions.length;
        while(low<high){
            int mid=low+(high-low)/2;
            if((long)spell*potions[mid]>=success) high=mid;
            else low=mid+1;
        }
        return low;
    }
}