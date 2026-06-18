class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int lastend=intervals[0][1];

        int count=1;
        for(int i=1;i<intervals.length;i++){
            if(lastend<=intervals[i][0]){
                count++;
                lastend=intervals[i][1];
            }

        }
        return intervals.length-count;
    }
}