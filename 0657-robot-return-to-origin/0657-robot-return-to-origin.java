class Solution {
    public boolean judgeCircle(String moves) {
        int y=0,x=0;
        char arr[]=moves.toCharArray();
        for(char c:arr){
            if(c=='U') y++;
            if(c=='D') y--;
            if(c=='L') x++;
            if(c=='R') x--;
        }
        return y==0&&x==0;
    }
}