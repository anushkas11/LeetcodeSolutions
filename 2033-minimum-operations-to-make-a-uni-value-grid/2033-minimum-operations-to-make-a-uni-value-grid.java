class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                list.add(grid[i][j]);
            }
        }
        int rem=list.get(0)%x;
        for(int val:list){
            if(val%x!=rem) return -1;
        }

        Collections.sort(list);
        int mid=list.get(list.size()/2);

        int ops=0;
        for(int val:list){
            ops+=Math.abs(val-mid)/x;
        }
        return ops;
    }
}