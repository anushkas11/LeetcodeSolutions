class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean vis[]=new boolean[n];
        dfs(0,rooms,vis);
        
        for(boolean room:vis){
            if(!room) return false;
        }
        return true;
    }

    public void dfs(int room, List<List<Integer>> rooms, boolean[] vis){
        vis[room]=true;
        for(int key:rooms.get(room)){
            if(!vis[key]) dfs(key,rooms,vis);
        }
    }
}