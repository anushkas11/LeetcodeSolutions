class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]=='1'){
                    count++;
                    dfs(r,c,grid);
                }
            }
        }
        return count;
    }
    public void dfs(int r,int c,char[][] grid){
        if(r<0 || r>=m ||c<0|| c>=n|| grid[r][c]=='0') return;
        grid[r][c]='0';
        dfs(r-1,c,grid);
        dfs(r+1,c,grid);
        dfs(r,c-1,grid);
        dfs(r,c+1,grid);
    }
}