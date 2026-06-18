class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans=new ArrayList<>();
        for(int i[]: intervals){
            ans.add(i);
        }
        ans.add(newInterval);
        int[][] result = ans.toArray(new int[ans.size()][2]);
        return merge(result);
    }
   public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b)-> a[0]-b[0]);
        List<int[]> ans=new ArrayList<>();
        int current[] =intervals[0];
        ans.add(current);
        for(int []interval:intervals){
            int currentend=current[1];
            int nextstart=interval[0];
            int nextend=interval[1];

            if(nextstart<=currentend){
                current[1]=Math.max(currentend,nextend);
            }
            else{
                current=interval;
                ans.add(current);
            }

        }
         return ans.toArray(new int[ans.size()][]);
    }

}