class Solution {
    int n,m;
    public boolean exist(char[][] board, String word) {
        n=board.length;
        m=board[0].length;
       //saare cell se possibility check krenge 
       for(int r=0;r<n;r++){
        for(int c=0;c<m;c++){
            if(dfs(r,c,0,board,word)) return true;
        }
       }
       return false;
    }
    public boolean dfs(int r,int c,int i,char[][] board,String word){
        if(i==word.length()) return true;
        if(r<0 || r>=n|| c<0||c>=m||board[r][c]!=word.charAt(i)) return false;
        char temp=board[r][c];
        board[r][c]='*';
        boolean found=dfs(r+1,c,i+1,board,word)||dfs(r-1,c,i+1,board,word)||dfs(r,c+1,i+1,board,word)||dfs(r,c-1,i+1,board,word);
        board[r][c]=temp;
        return found;
    }
}