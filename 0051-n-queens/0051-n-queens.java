class Solution {
   
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solve(0,board,n,ans);
        return ans;
    }
    public void solve(int row,char[][] board,int n, List<List<String>> ans){
        if(row==n){
            List<String> curr=new ArrayList<>();
            for(int i=0;i<n;i++){
                curr.add(new String(board[i]));
            }
            ans.add(curr);
            return;
        }
        for(int col=0;col<n;col++){
            if(!isSafe(row,col,board,n)){
                continue;
            }
            board[row][col]='Q';
            solve(row+1,board,n,ans);
            board[row][col]='.';
        }
    }
    public boolean isSafe(int r,int c,char[][] board,int n){
        for(int row=0;row<r;row++){
            if(board[row][c]=='Q') return false;
        }
        int row=r,col=c;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        row=r;
        col=c;
        while(row>=0 && col<n){
            if(board[row][col]=='Q') return false;
            row--;
            col++;
        }
        return true;
    }
}