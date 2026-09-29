class Solution {
    public int[][] merge(int[][] interval) {
        if(interval.length<=1) return interval;
        List<int[]> list=new ArrayList<>();
        Arrays.sort(interval,(a,b)->a[0]-b[0]);
        int start=interval[0][0];
        int end=interval[0][1];
        for(int i[]:interval){
            if(i[0]<=end){
                end=Math.max(i[1],end);
            }
            else{
                list.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);
    }
}