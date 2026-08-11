class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=0;
        for(int i:piles) high=Math.max(high,i);
        while(low<high){
            int mid=low+(high-low)/2;
            if(canEat(mid,h,piles)) high=mid;
            else low=mid+1;
        }
        return low;
    }
    public boolean canEat(int s,int h,int[] piles){
        int hours=0;
        for(int i:piles) hours+=Math.ceil(i+s-1)/s;
        return hours<=h;
    }
}