class Solution {
    public int maximumUnits(int[][] boxtypes, int truckSize) {
        Arrays.sort(boxtypes,(a,b)->b[1]-a[1]);
        int ans=0;
        for(int box[]:boxtypes){
            if(truckSize>=box[0]){
                ans+=box[0]*box[1];
                truckSize-=box[0];
            }
            else{
                ans+=truckSize*box[1];
                break;
            }
        }
        return ans;
    }
}