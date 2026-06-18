class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ans=new ArrayList<>();
        int current[]=intervals[0];
        ans.add(current);
        for(int i[]:intervals){
            int currentEnd=current[1];
            int nextstart=i[0];
            int nextend=i[1];

            if(nextstart<=currentEnd){
                current[1]=Math.max(current[1],nextend);
            }
            else{
                current=i;
                ans.add(current);

            }
        
        }
        return ans.toArray(new int[ans.size()][2]);

    }
}