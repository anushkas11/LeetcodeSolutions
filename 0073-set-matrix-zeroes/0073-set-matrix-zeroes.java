class Solution {
    int n,m;
    public void setZeroes(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        HashSet<int[]> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0) set.add(new int[]{i,j});
            }
        }
        set(set,matrix);
        return;
    }
    public void set(HashSet<int[]> set,int[][] matrix){
        if(set.size()==0) return;
        for(int[] k:set){
            int r=k[0];
            int c=k[1];
            for(int i=0;i<n;i++) matrix[i][c]=0;
            for(int i=0;i<m;i++) matrix[r][i]=0;
        }
        return;
    }
}